package org.honshe.pojo.service.text;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class ServiceTextContentPojo {
    private String content;

    public ServiceTextContentPojo() {
    }

    public ServiceTextContentPojo(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ServiceTextContentPojo{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
