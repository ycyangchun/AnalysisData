package com.zhcw.analysisdata.model.entity;

/**
 * Created by Yore on 2017/11/23.
 */

public class LoginBody {

    /**
     * cell : 17600145229
     * userPwd : 123456
     */

    private String cell;
    private String userPwd;

    public LoginBody(String cell, String userPwd) {
        this.cell = cell;
        this.userPwd = userPwd;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
