package org.honshe.pojo.service.music;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class ServiceMusicContentPojo {
    private String title;
    private String description;
    //音乐链接
    private String musicurl;
    //高品质音乐链接，wifi环境优先使用该链接播放音乐
    private String hqmusicurl;
    //缩略图的媒体ID
    private String thumb_media_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getHqmusicurl() {
        return hqmusicurl;
    }

    public void setHqmusicurl(String hqmusicurl) {
        this.hqmusicurl = hqmusicurl;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
