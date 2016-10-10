package org.honshe.pojo.service;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class ServiceBasePojo {
    private String touser;
    private String msgtype;

    @Override
    public String toString() {
        return "ServiceBasePojo{" +
                "touser='" + touser + '\'' +
                ", msgtype='" + msgtype + '\'' +
                '}';
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

}
