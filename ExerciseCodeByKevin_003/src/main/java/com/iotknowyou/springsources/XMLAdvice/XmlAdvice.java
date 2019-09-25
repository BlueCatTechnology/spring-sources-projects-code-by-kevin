package com.iotknowyou.springsources.XMLAdvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/*
*   定义了 XmlAdvice  拦截的方法，
*       用于演示，前置、后置、成功返回、异常返回、环绕通知
*
*
*
*
*
*
* */
public class XmlAdvice {
    public void beforeAdvice(){
        System.out.println("前置通知执行了。。。。。");
    }

    public void afterAdvice(){
        System.out.println("后置通知执行了。。。。。");
    }

    public void afterReturnAdvice(String result){
        System.out.println("返回通知执行了。。。。。。");
        System.out.println("运行业务方法返回的结果为："+result);
    }

    public String aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        String result = "";
        try {
            System.out.println("环绕通知执行了。。。。。");
            long start = System.currentTimeMillis();
            result =(String) proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("环绕通知结束了。。。。。");
            System.out.println("执行业务方法共计："+ (end - start) + "毫秒");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

    public void throwingAdvice(JoinPoint joinPoint,Exception e){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("异常通知执行了。。。。。");
        stringBuffer.append("方法：").append(joinPoint.getSignature().getName()).append("出现了异常。！");
        stringBuffer.append("异常的信息为：").append(e.getMessage());
        System.out.println(stringBuffer.toString());
    }
}
