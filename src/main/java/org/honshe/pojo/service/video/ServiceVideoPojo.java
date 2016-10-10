package org.honshe.pojo.service.video;

import org.honshe.pojo.service.ServiceBasePojo;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ServiceVideoPojo extends ServiceBasePojo{
    private ServiceVideoContentPojo video;

    @Override
    public String toString() {
        return "ServiceVideoPojo{" +
                "video=" + video +
                '}';
    }

    public ServiceVideoContentPojo getVideo() {
        return video;
    }

    public void setVideo(ServiceVideoContentPojo video) {
        this.video = video;
    }
}
