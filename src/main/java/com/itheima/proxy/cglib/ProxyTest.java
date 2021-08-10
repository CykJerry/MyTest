package com.itheima.proxy.cglib;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    @Test
    public void test1(){
        //创建目标对象
        Target target = new Target();
        //获得增强对象
        Advice advice = new Advice();
        //返回值 就是动态代理生成对象 基于cglib
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterReturning();//执行后置
                return invoke;
            }
        });
        //4.生成代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
