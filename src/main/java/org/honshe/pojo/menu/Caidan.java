package org.honshe.pojo.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class Caidan {
    private String type = null;
    private String name = null;
    private String key = null;
    private String url = null;
    private String media_id = null;
    private List<Caidan> sub_button = new ArrayList<Caidan>();

    public Caidan() {
    }

    public Caidan(String type, String name, String key, String url) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public List<Caidan> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Caidan> sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "Caidan{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", media_id='" + media_id + '\'' +
                ", sub_button=" + sub_button +
                '}';
    }
}
