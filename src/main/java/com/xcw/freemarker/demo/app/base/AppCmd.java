package com.xcw.freemarker.demo.app.base;

import com.xcw.freemarker.demo.app.base.AppRequest;
import com.xcw.freemarker.demo.app.base.AppResponse;

/**
 * @Author xcw
 * @Date 2021/1/18 13:29
 * @Description 基础操作接口
 */
public interface AppCmd {
    String ID_PREFIX = "App";
    String ID_DEFAULT = "";
    String VERSION_PREFIX = "v";
    String VERSION_DEFAULT = "v1";
    String PATH_SEP = "/";

    default String getName() {
        return this.getClass().getSimpleName();
    }

    default String getPath() {
        return getVer()+PATH_SEP+getId();
    }

    default String getId() {
        String c = this.getClass().getSimpleName();
        int v = c.lastIndexOf(VERSION_PREFIX);
        if(v>0){
            return c.substring(ID_PREFIX.length(), v).toLowerCase();
        }else{
            return ID_DEFAULT;
        }
    }

    default String getVer() {
        String c = this.getClass().getSimpleName();
        int v = c.lastIndexOf(VERSION_PREFIX);
        if(v>0){
            return c.substring(v, c.length());
        }else{
            return VERSION_DEFAULT;
        }
    }

    boolean allow(AppRequest<?> request);

    AppRequest<?> instanceRequest(String body);


    void execute(AppRequest<?> request, AppResponse<?> response) throws Exception;
}
