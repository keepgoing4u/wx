package org.honshe.pojo.template;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class TemplateDataContentPojo {
    private TemplateDataPojo name;
    private TemplateDataPojo money_number;
    private TemplateDataPojo date;

    @Override
    public String toString() {
        return "TemplateDataContentPojo{" +
                "name=" + name +
                ", money_number=" + money_number +
                ", date=" + date +
                '}';
    }

    public TemplateDataPojo getName() {
        return name;
    }

    public void setName(TemplateDataPojo name) {
        this.name = name;
    }

    public TemplateDataPojo getMoney_number() {
        return money_number;
    }

    public void setMoney_number(TemplateDataPojo money_number) {
        this.money_number = money_number;
    }

    public TemplateDataPojo getDate() {
        return date;
    }

    public void setDate(TemplateDataPojo date) {
        this.date = date;
    }
}
