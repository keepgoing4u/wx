package org.honshe.pojo.template;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class TemplatePojo {
    private String touser;
    private String template_id;
    private String topcolor;
    private TemplateDataContentPojo data;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public TemplateDataContentPojo getData() {
        return data;
    }

    public void setData(TemplateDataContentPojo data) {
        this.data = data;
    }
}
