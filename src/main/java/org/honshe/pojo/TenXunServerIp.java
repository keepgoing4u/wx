package org.honshe.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class TenXunServerIp {
    private List<String> ip_list = new ArrayList<String>();

    public List<String> getIp_list() {
        return ip_list;
    }

    public void setIp_list(List<String> ip_list) {
        this.ip_list = ip_list;
    }

    @Override
    public String toString() {
        return "TenXunServerIp{" +
                "ip_list=" + ip_list +
                '}';
    }
}
