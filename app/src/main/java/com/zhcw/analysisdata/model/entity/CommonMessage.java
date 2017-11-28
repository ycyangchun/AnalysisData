package com.zhcw.analysisdata.model.entity;

/**
 * Created by YangChun .
 * on 2017/3/13.
 */

public class CommonMessage<T> {


    /**
     * message : {"head":{"messageID":"99992017112315011163","timeStamp":"20171123150111","messengerID":"9999","transactionType":"10020102","sysType":"U","src":"0000100001|0301005020","imei":"868030024159483","ua":"MI 5","deviceId":"698FA81344678469562B64C623F38115"},"body":{"cell":"17600145229","userPwd":"123456"}}
     */

    private MessageBean message;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public class MessageBean<T>{
        /**
         * head : {"messageID":"99992017112315011163","timeStamp":"20171123150111","messengerID":"9999","transactionType":"10020102","sysType":"U","src":"0000100001|0301005020","imei":"868030024159483","ua":"MI 5","deviceId":"698FA81344678469562B64C623F38115"}
         * body : {"cell":"17600145229","userPwd":"123456"}
         */

        private HeadBean head;
        private T body;

        public MessageBean(HeadBean head, T body) {
            this.head = head;
            this.body = body;
        }

        public HeadBean getHead() {
            return head;
        }

        public void setHead(HeadBean head) {
            this.head = head;
        }

        public T getBody() {
            return body;
        }

        public void setBody(T body) {
            this.body = body;
        }

        public class HeadBean {
            public HeadBean(String messageID, String timeStamp, String messengerID, String transactionType, String sysType, String src, String imei, String ua, String deviceId) {
                this.messageID = messageID;
                this.timeStamp = timeStamp;
                this.messengerID = messengerID;
                this.transactionType = transactionType;
                this.sysType = sysType;
                this.src = src;
                this.imei = imei;
                this.ua = ua;
                this.deviceId = deviceId;
            }

            /**
             * messageID : 99992017112315011163
             * timeStamp : 20171123150111
             * messengerID : 9999
             * transactionType : 10020102
             * sysType : U
             * src : 0000100001|0301005020
             * imei : 868030024159483
             * ua : MI 5
             * deviceId : 698FA81344678469562B64C623F38115
             */


            private String messageID;
            private String timeStamp;
            private String messengerID;
            private String transactionType;
            private String sysType;
            private String src;
            private String imei;
            private String ua;
            private String deviceId;

            public String getMessageID() {
                return messageID;
            }

            public void setMessageID(String messageID) {
                this.messageID = messageID;
            }

            public String getTimeStamp() {
                return timeStamp;
            }

            public void setTimeStamp(String timeStamp) {
                this.timeStamp = timeStamp;
            }

            public String getMessengerID() {
                return messengerID;
            }

            public void setMessengerID(String messengerID) {
                this.messengerID = messengerID;
            }

            public String getTransactionType() {
                return transactionType;
            }

            public void setTransactionType(String transactionType) {
                this.transactionType = transactionType;
            }

            public String getSysType() {
                return sysType;
            }

            public void setSysType(String sysType) {
                this.sysType = sysType;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getImei() {
                return imei;
            }

            public void setImei(String imei) {
                this.imei = imei;
            }

            public String getUa() {
                return ua;
            }

            public void setUa(String ua) {
                this.ua = ua;
            }

            public String getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
            }
        }


    }
}
