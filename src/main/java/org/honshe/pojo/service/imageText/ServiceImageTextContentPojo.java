package org.honshe.pojo.service.imageText;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ServiceImageTextContentPojo {
    private String title;
    private String description;
    private String url;
    private String picurl;

    @Override
    public String toString() {
        return "ServiceImageTextContentPojo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", picurl='" + picurl + '\'' +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
