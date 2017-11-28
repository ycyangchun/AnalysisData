package com.zhcw.analysisdata.di.components;
import com.zhcw.analysisdata.di.modules.NetModule;
import com.zhcw.analysisdata.model.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 *
 */
@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {
    ApiService getApiService();

    OkHttpClient getOkHttp();

    Retrofit getRetrofit();
}
