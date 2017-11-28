package com.zhcw.analysisdata.model.api;


import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 *
 */
public interface ApiService {

    /**
     *  设备信息上传
     */
    @POST("client.do")
    Observable<String> login(@Query("encry") String encry, @Query("transMessage") Body transMessage );

//    @GET("client.do")
//    Observable<String> login (@Path("ip") String ip, @Query("encry") String encry, @Query("transMessage") String transMessage );
    @GET("client.do")
    Observable<String> login (@Query("encry") String encry, @Query("transMessage") String transMessage );
}
