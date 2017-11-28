package com.zhcw.analysisdata.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhcw.analysisdata.R;
import com.zhcw.analysisdata.base.AnalysisApp;
import com.zhcw.analysisdata.di.components.DaggerLoginComponent;
import com.zhcw.analysisdata.di.modules.LoginModule;
import com.zhcw.analysisdata.model.entity.CommonMessage;
import com.zhcw.analysisdata.model.entity.LoginBody;
import com.zhcw.analysisdata.presenter.LoginContract;
import com.zhcw.analysisdata.presenter.LoginPresenter;
import com.zhcw.analysisdata.utils.DesUtil;

import org.json.JSONObject;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements LoginContract.AView{

    @Inject
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        final String param = "{\"message\":{\"head\":{\"messageID\":\"99992017112315011163\",\"timeStamp\":\"20171123150111\",\"messengerID\":\"9999\",\"transactionType\":\"10020102\",\"sysType\":\"U\",\"src\":\"0000100001|0301005020\",\"imei\":\"868030024159483\",\"ua\":\"MI 5\",\"deviceId\":\"698FA81344678469562B64C623F38115\"},\"body\":{\"cell\":\"17600145229\",\"userPwd\":\"123456\"}}}";


        DaggerLoginComponent.builder()
                .netComponent(AnalysisApp.get(this).getNetComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    loginPresenter.login("0", param);
//                    loginPresenter.login("1", DesUtil.encryptDES(param, "12345678"));
                    loginPresenter.login("u.zhcw.com","1", DesUtil.encryptDES(param, "12345678"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
