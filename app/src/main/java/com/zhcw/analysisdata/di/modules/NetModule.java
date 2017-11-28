package com.zhcw.analysisdata.di.modules;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.zhcw.analysisdata.AnalysisConfig;
import com.zhcw.analysisdata.model.api.ApiService;
import com.zhcw.analysisdata.model.api.JsonConverterFactory;
import com.zhcw.analysisdata.model.api.NoNetworkException;
import com.zhcw.analysisdata.model.api.StringConverterFactory;
import com.zhcw.analysisdata.model.api.LiveNetworkMonitor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by YangChun .
 * on 2017/3/6.
 */
@Module
public class NetModule {
    private Context context;

    public NetModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public LiveNetworkMonitor provideLiveNetworkMonitor(){
        return new LiveNetworkMonitor(context);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(final LiveNetworkMonitor networkMonitor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(AnalysisConfig.isLog ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                boolean connected = networkMonitor.isConnected();
                if (connected) {
                    return chain.proceed(chain.request());
                } else {
                    throw new NoNetworkException("网络未连接，请查看网络设置");
                }
            }
        };
        // 多ip 设置拦截
        Interceptor multipleIPInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (!AnalysisConfig.isMultipleIp) {
                    return chain.proceed(chain.request());
                } else {
                    return chain.proceed(processRequest(chain.request()));
                }
            }
        };
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(multipleIPInterceptor)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(networkInterceptor)
                .build();
        return okhttpClient;
    }
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okhttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl(AnalysisConfig.HOST_URL)
                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    /**
     * 对 {@link Request} 进行一些必要的加工
     *
     * @param request
     * @return
     */
    public Request processRequest(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        HttpUrl oldUrl  = request.url();
        if (null != oldUrl) {
            HttpUrl newUrl = oldUrl.newBuilder()
                    .scheme(oldUrl.scheme())
                    .host("u.zhcw.com")
                    .port(oldUrl.port())
                    .build();

            return newBuilder
                    .url(newUrl)
                    .build();
        }

        return newBuilder.build();

    }
}
