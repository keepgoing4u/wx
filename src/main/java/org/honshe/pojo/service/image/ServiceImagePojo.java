package org.honshe.pojo.service.image;

import org.honshe.pojo.service.ServiceBasePojo;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class ServiceImagePojo extends ServiceBasePojo{
    private ServiceImageIdPojo image;

    @Override
    public String toString() {
        return "ServiceImagePojo{" +
                "image=" + image +
                '}';
    }

    public ServiceImageIdPojo getImage() {
        return image;
    }

    public void setImage(ServiceImageIdPojo image) {
        this.image = image;
    }
}
