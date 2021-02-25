package com.xcw.freemarker.demo.app.base;

/**
 * @Author xcw
 * @Date 2021/1/18 13:53
 * @Description 匿名登录类
 */
public abstract class AppBaseAnonym implements AppCmd {

    @Override
    public boolean allow(AppRequest<?> request) {return true;}

}