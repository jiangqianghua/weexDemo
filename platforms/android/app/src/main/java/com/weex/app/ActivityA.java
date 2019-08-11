package com.weex.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;
import java.util.Map;

public class ActivityA extends AbsWeexActivity implements IWXRenderListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        mContainer = (ViewGroup) findViewById(R.id.container);
        WXSDKInstance mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);
        String RenderPageUrl = "";//SharedPreferencesUtil.getSP(context, Ips.KEY, "ERROR");
        //LogUtil.e(RenderPageUrl);
        if (getIntent().getData() != null) {
            String navUrl = getIntent().getData().toString();
            if (null != navUrl) {
               // LogUtil.e(navUrl);
                RenderPageUrl = navUrl;
            } else {
              //  LogUtil.e("a is null");
            }
        } else {
            //LogUtil.e("get data is null");
        }
        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, RenderPageUrl);
        mWXSDKInstance.renderByUrl("WXSample", RenderPageUrl, options, null, WXRenderStrategy.APPEND_ONCE);
    }
}
