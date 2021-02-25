package com.xcw.freemarker.demo.app.base;

/**
 * @Author xcw
 * @Date 2021/1/18 13:57
 * @Description 基础登录类
 */
public abstract class AppBaseLogin implements AppCmd {

    @Override
    public boolean allow(AppRequest<?> request) {
        return request.getMemberId() != null;
    }
}
