package com.zhcw.analysisdata.di.components;



import com.zhcw.analysisdata.di.modules.LoginModule;
import com.zhcw.analysisdata.di.scopes.UserScope;
import com.zhcw.analysisdata.view.ui.MainActivity;

import dagger.Component;

/**
 * Created by YangChun .
 * on 2017/3/9.
 */
@UserScope
@Component(modules = LoginModule.class, dependencies = NetComponent.class)
public interface LoginComponent {
    void inject(MainActivity loginActivity);
}
