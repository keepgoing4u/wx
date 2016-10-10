package org.honshe.pojo.service.video;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ServiceVideoContentPojo {
    private String media_id;
    private String thumb_media_id;
    private String title;
    private String description;

    @Override
    public String toString() {
        return "ServiceVideoContentPojo{" +
                "media_id='" + media_id + '\'' +
                ", thumb_media_id='" + thumb_media_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

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
}
