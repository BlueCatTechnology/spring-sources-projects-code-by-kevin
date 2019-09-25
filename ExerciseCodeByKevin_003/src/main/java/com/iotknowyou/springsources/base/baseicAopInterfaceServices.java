package com.iotknowyou.springsources.base;

public interface baseicAopInterfaceServices {
    /* 这里我们定义二个方法，一个会被拦截器拦截，一个不会被拦截器拦截 */

    /* 该方法将会 使用拦截器拦截 */
    public String withAopMethod() throws Exception;

    /* 该方法将 不会使用拦截器拦截*/
    public String withNoAopMethod() throws Exception;

}
