package com.zhcw.analysisdata.presenter;

import com.zhcw.analysisdata.base.BasePresenter;
import com.zhcw.analysisdata.base.BaseView;

import retrofit2.http.Body;

/**
 * Created by YangChun .
 * on 2017/3/14.
 * 登录
 */

public interface LoginContract {
    class Presenter extends BasePresenter <AView>{
        public void login(String encry, Body s){

        }
        public void login(String ip ,String encry, String s){

        }
    }
    interface AView extends BaseView{

    }
}
