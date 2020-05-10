package com.example.spring_boot_demo.requestMerge;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * 请求合并参数类
 * @param <R>
 * @param <P>
 */
class DeferredResultRequest<R,P>{
       private DeferredResult<P> result;
       private   R request;
        public DeferredResultRequest(DeferredResult<P> result, R request) {
            this.result = result;
            this.request = request;
        }
        public DeferredResult<P> getResult() {
            return result;
        }
        public R getRequest() {
            return (R)request;
        }
    }