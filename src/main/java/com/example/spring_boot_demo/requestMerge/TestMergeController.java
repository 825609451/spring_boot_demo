package com.example.spring_boot_demo.requestMerge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import com.example.spring_boot_demo.entity.User;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;

/**
 * @ClassName : TestMergeController
 * @Description :
 * @Author : sky
 * @Date: 2020-05-10 19:18
 */
@RestController
public class TestMergeController {

    List<User> users= Arrays.asList(new User(1,"SKY",26),new User(2,"SKY2",27));
    //缓存请求
    private volatile BlockingQueue<DeferredResultRequest<Integer, User>> blockingQueue = new ArrayBlockingQueue(1000);
    // 模拟返回多个
    @GetMapping("/merge/user/{userId}")
    @ResponseBody
    public DeferredResult<R> getUser(@PathVariable Integer userId){
        DeferredResult<R> result=new DeferredResult<>();
        boolean isAdd = blockingQueue.offer(new DeferredResultRequest(result, userId));
        //如果沒有成功添加則執行限流策略直接返回錯誤User
        if(!isAdd){
            result.setResult(R.error());
        }
        return result;
    }

    /**
     * 起一个周期线程没100毫秒 合并处理一次请求
     */
    @PostConstruct
    public void init(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        //ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.scheduleAtFixedRate(()->{
            int size=blockingQueue.size();
            //批量获取并设置请求参数
            //System.out.println("size>>>>>>  "+ size);
            if(size>0){
                System.out.println("合并请求数：>>>>>>  "+ size);
                List<Integer> userIds=new ArrayList<>(size);
                Map<Integer,List<DeferredResult<User>>> mres=new HashMap<>(size);
                for (int i = 0; i <size ; i++) {
                    try {
                        DeferredResultRequest<Integer,User> take = blockingQueue.take();
                        userIds.add(take.getRequest());
                        if(!mres.containsKey(take.getRequest())){
                            mres.put(take.getRequest(),new ArrayList<DeferredResult<User>>());
                        }
                        List<DeferredResult<User>> userResults=mres.get(take.getRequest());
                        //List<DeferredResult<SysUser>> userResults = mres.putIfAbsent(take.getRequest(), new ArrayList<DeferredResult<SysUser>>());
                        userResults.add(take.getResult());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //模拟合并查询数据库
                List<User> sysUsers = selectUserByIds(userIds);
                //返回结果
                sysUsers.forEach(u->{
                    mres.get(u.getId()).forEach(r->{
                        if(!r.isSetOrExpired()){
                            r.setResult(u);
                        }
                    });
                });
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

    }
    // 模拟select U from user U where id in(xxxxx....);
    private List<User> selectUserByIds(List<Integer> userIds) {
       return users.stream().filter(u->userIds.contains(u.getId())).collect(Collectors.toList());
    }

}
