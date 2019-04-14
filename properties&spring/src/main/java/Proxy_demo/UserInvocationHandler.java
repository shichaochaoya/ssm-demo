package Proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {

    private Object target;//target:目标

    public UserInvocationHandler(){}
    public UserInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前---"+method.getName());

        Object obj = method.invoke(target,args);

        System.out.println("调用后---"+method.getName());
        return obj;//返回调用结果
    }
}
