package com.zhcw.analysisdata.base;


import android.app.Application;
import android.content.Context;

import com.zhcw.analysisdata.di.components.DaggerNetComponent;
import com.zhcw.analysisdata.di.components.NetComponent;
import com.zhcw.analysisdata.di.modules.NetModule;
import com.zhcw.analysisdata.utils.PathUtils;
import com.zhcw.analysisdata.utils.SharedPreferencesUtils;


/**
 * Created by yc on 2017/3/6.
 * app
 */

public class AnalysisApp extends Application {
    public static AnalysisApp instance;
    private NetComponent netComponent;
    public static AnalysisApp getInstance(){
        return instance;
    }
    public static AnalysisApp get(Context context) {
        return (AnalysisApp) context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initNet();
        initPath();
        initDadaBase();

    }

    private void initDadaBase() {
    }


    private void initPath() {
        SharedPreferencesUtils.init(this);
        PathUtils.getInstance(this, "analysis");
    }

    //net
    private void initNet() {
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(this))
                .build();
    }



    public NetComponent getNetComponent() {
        return netComponent;
    }
}
