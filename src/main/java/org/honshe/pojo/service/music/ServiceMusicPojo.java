package org.honshe.pojo.service.music;

import org.honshe.pojo.service.ServiceBasePojo;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class ServiceMusicPojo extends ServiceBasePojo {
    private ServiceMusicContentPojo music;

    @Override
    public String toString() {
        return "ServiceMusicPojo{" +
                "music=" + music +
                '}';
    }

    public ServiceMusicContentPojo getMusic() {
        return music;
    }

    public void setMusic(ServiceMusicContentPojo music) {
        this.music = music;
    }
}
