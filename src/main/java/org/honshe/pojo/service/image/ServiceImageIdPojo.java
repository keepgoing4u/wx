package org.honshe.pojo.service.image;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class ServiceImageIdPojo  {

    private String media_id;

    public ServiceImageIdPojo() {
    }

    public ServiceImageIdPojo(String media_id) {
        this.media_id = media_id;
    }

    @Override
    public String toString() {
        return "ServiceImageIdPojo{" +
                "media_id='" + media_id + '\'' +
                '}';
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
