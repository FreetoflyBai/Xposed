package com.android.xposed.hook;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * author   : kevin.bai
 * date      : 2020-02-11 23:16
 * qq        :904869397@qq.com
 */
public class MethodHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if(loadPackageParam.packageName.equals("com.cool.c.wallpaper")){
            XposedBridge.log("=="+"包名匹配");
            XposedHelpers.findAndHookMethod(
                    "c.a.a.Er",
                    loadPackageParam.classLoader,
                    "shouldStart",
                    Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(true);
                            XposedBridge.log("=="+"结果修改");
//                        super.afterHookedMethod(param);
                        }
                    });
        }

    }
}
