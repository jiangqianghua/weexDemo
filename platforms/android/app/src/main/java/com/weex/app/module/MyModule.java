package com.weex.app.module;

import android.widget.Toast;

import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;

public class MyModule extends WXModule {

    @WXModuleAnno(runOnUIThread = true)
    public void printLog(String msg) {
        Toast.makeText(mWXSDKInstance.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @WXModuleAnno(runOnUIThread = false)
    public void nativeCallBack(JSCallback callback) {
        //回调信息
        callback.invoke("I am callback message");
    }
}
