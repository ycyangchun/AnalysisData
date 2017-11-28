package com.zhcw.analysisdata.di.modules;


import com.zhcw.analysisdata.presenter.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YangChun .
 * on 2017/3/15.
 */
@Module
public class LoginModule {
    LoginContract.AView view;

    public LoginModule(LoginContract.AView view) {
        this.view = view;
    }
    @Provides
    public LoginContract.AView provideView(){
        return view;
    }
}
