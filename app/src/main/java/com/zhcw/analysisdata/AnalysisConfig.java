package com.zhcw.analysisdata;

/**
 *
 * 配置类
 */
public class AnalysisConfig {
    /**
     * true 为debug状态，打印日志;false为上线发布状态
     */
    public static boolean isLog = true;/// 控制打印信息
    public static boolean isCeShi = false;
    public static boolean isMultipleIp = true;// 应用多ip设置
    public final static int SERVER_CESHI = 0;
    public final static int SERVER_YUSHANGXIAN = 1;
    public final static int SERVER_ZHENGSHI = 2;
    public static String ry_kefu = "";
    public static String ry_appkey = "";
    public static String DEBUG_VERSION = "csv5020_1116_1";
    public static boolean isDes = true;// 是否Des加密传输协议

    public static String HOST_URL_Z = "http://c.zhcw.com/zhcwapp/serv.do";// 正式
    public static String HOST_URL = "http://ip";// 用户中心正式
    public static String HOST_URL_S = "http://172.16.110.106:1190/api/data/client";// 数据分析
    public static String HOST_URL_DS = "http://172.16.110.102:9080/client.do";// 数据分析快3

    public static void setServerType(int serverType) {

        switch (serverType) {
            case SERVER_CESHI:// 测试服
                isCeShi = true;
                isLog = true;// /控制打印信息
                HOST_URL_Z = "http://172.16.110.222:8080/zhcwapp/serv.do";// 测试
                HOST_URL = "http://172.16.110.102:9080/client.do";// 用户中心测试
                HOST_URL_S = "http://172.16.110.106:1190/api/data/client";// 数据分析测试
                HOST_URL_DS = HOST_URL;// 数据分析快3
                ry_kefu = "KEFU1436929973648";
                ry_appkey = "8w7jv4qb7kr9y";
                isDes = false;
                break;
            case SERVER_YUSHANGXIAN:// 预上线
                isCeShi = true;
                isLog = true;// /控制打印信息
                HOST_URL_Z = "http://c.zhcw.com/zhcwapp/serv.do";// 正式
                HOST_URL = "http://csu.zhcw.com/client.do";// 用户中心预上线
                HOST_URL_S = "http://dapi.zhcw.com/api/data/client";// 数据分析预上线
                HOST_URL_DS = HOST_URL;// 数据分析快3
                ry_kefu = "KEFU148764098956309";
                ry_appkey = "8w7jv4qb7kr9y";
                isDes = false;
                break;
            case SERVER_ZHENGSHI:// 正式服
                isCeShi = false;
                isLog = true;// /控制打印信息
                DEBUG_VERSION = "";
                HOST_URL_Z = "http://c.zhcw.com/zhcwapp/serv.do";// 正式
                HOST_URL = "http://u.zhcw.com/client.do";// 用户中心正式
                HOST_URL_S = "http://dapi.zhcw.com/api/data/client";// 数据分析正式
                HOST_URL_DS = HOST_URL;// 数据分析快3
                ry_kefu = "KEFU148764098956309";
                ry_appkey = "8w7jv4qb7kr9y";
                isDes = true;
                break;
        }
    }

}
