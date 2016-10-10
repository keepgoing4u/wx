package org.honshe.pojo.template;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class TemplateDataPojo {
    private String value;
    private String color;

    @Override
    public String toString() {
        return "TemplateDataPojo{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
