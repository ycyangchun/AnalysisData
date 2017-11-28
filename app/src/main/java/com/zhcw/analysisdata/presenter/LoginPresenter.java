package com.zhcw.analysisdata.presenter;


import com.zhcw.analysisdata.model.api.ApiService;
import com.zhcw.analysisdata.utils.DesUtil;

import javax.inject.Inject;

import retrofit2.http.Body;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by YangChun .
 * on 2017/3/14.
 */

public class LoginPresenter extends LoginContract.Presenter {
    private LoginContract.AView view;
    private ApiService apiService;

    @Inject
    public LoginPresenter(LoginContract.AView view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public LoginContract.AView getView() {
        return super.getView();
    }

    @Override
    public void attachView(LoginContract.AView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void login(String e, Body s) {
        super.login(e, s);
        apiService.login(e,s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s1) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });

    }

    @Override
    public void login(String ip ,String encry, String s) {
        super.login(ip ,encry, s);
        apiService.login(encry,s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s1) {
                        System.out.println("------------->\n"+DesUtil.decryptDES(s1,"12345678"));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }
}
