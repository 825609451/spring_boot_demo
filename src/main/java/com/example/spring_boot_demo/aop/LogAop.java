package com.example.spring_boot_demo.aop;

/**
 * @ClassName : LogAop
 * @Description :
 * @Author : sky
 * @Date: 2020-05-12 22:26
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component
@Aspect
public class LogAop {
    private ExpressionParser parser = new SpelExpressionParser();
    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Around(value = "@annotation(aop)")
    public Object test(ProceedingJoinPoint point,Log aop) throws Throwable {
        Object obj=point.getTarget();
        // 获取方法参数值
        Object[] arguments = point.getArgs();
        // 获取方法
        Method method = getMethod(point);
        // 从注解中获取spel字符串，省略...
        String spel = parseSpel(method,arguments,aop.value(),String.class,"");
        // 解析spel表达式
        System.out.println(">>>>>>>"+spel);
        //Boolean result = parseSpel(method, arguments, spel, Boolean.class, Boolean.FALSE);
        // 业务操作，省略...
        return point.proceed();
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.getDeclaringClass().isInterface()) {
            try {
                method = joinPoint
                        .getTarget()
                        .getClass()
                        .getDeclaredMethod(joinPoint.getSignature().getName(),
                                method.getParameterTypes());
            } catch (SecurityException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return method;
    }

    /**
     * 解析 spel 表达式
     * @param method    方法
     * @param arguments 参数
     * @param spel      表达式
     * @param clazz     返回结果的类型
     * @param defaultResult 默认结果
     * @return 执行spel表达式后的结果
     */
    private <T> T parseSpel(Method method, Object[] arguments, String spel, Class<T> clazz, T defaultResult) {
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], arguments[len]);
        }
        try {
            Expression expression = parser.parseExpression(spel);
            return expression.getValue(context, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultResult;
        }
    }
}
