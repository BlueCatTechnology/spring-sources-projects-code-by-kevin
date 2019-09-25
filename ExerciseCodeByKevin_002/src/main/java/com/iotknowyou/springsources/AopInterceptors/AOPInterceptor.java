package com.iotknowyou.springsources.AopInterceptors;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import com.iotknowyou.springsources.server.AopServicesImpl;

import java.lang.reflect.Method;

/*
*   定义AOP的拦截方法， 让 AOP 去实现 AfterReturningAdvice,MethodBeforeAdvice,ThrowsAdvice 三个接口
 *
* */
public class AOPInterceptor implements AfterReturningAdvice,MethodBeforeAdvice,ThrowsAdvice {
    @Override
    public void afterReturning(Object value, Method method, Object[] args, Object instance) throws Throwable {
        System.out.println("方法："+method.getName()+"运行结束，返回的值为："+value);
    }

    @Override
    public void before(Method method, Object[] args, Object instance) throws Throwable {
        System.out.println("执行 MethodBeforeAdvice ，即将执行的方法："+ method.getName());
        if(instance instanceof AopServicesImpl){
            String description = ((AopServicesImpl) instance).getDescription();
            if (description == null){
                throw new NullPointerException("description 属性不能为 null");
            }
        }
    }

    public void afterThrowing(Exception e){
        System.out.println("抛出异常:"+e.getMessage());
    }

    public void afterThrowing(Method method ,Object[] args ,Object target,Exception e){
        System.out.println("方法"+method.getName()+"抛出异常"+e.getMessage());
    }
}
