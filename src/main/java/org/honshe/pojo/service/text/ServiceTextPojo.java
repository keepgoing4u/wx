package org.honshe.pojo.service.text;

import org.honshe.pojo.service.ServiceBasePojo;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class ServiceTextPojo extends ServiceBasePojo {

    private ServiceTextContentPojo text;

    @Override
    public String toString() {
        return "ServiceTextPojo{" +
                "text=" + text +
                '}';
    }

    public ServiceTextContentPojo getText() {
        return text;
    }

    public void setText(ServiceTextContentPojo text) {
        this.text = text;
    }
}
