package org.honshe.server.templateMessage;

import org.honshe.pojo.template.TemplateDataContentPojo;
import org.honshe.pojo.template.TemplateDataPojo;
import org.honshe.pojo.template.TemplatePojo;
import org.honshe.server.BaseServer;

import java.util.Date;

/**
 * 模板消息
 * Created by Administrator on 2016/10/9 0009.
 */
public class SendTemplateMessageServer extends BaseServer{
    //发送模板url
    private String sendMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    private String templateId = "C6w-NPAVTTYVCbTgmUlYIDGtYbnk3ECtAegeN6VjxPs";

    private String userId = "o8c8gv2xIfwC52nKN3aGfUhNwq4E";

    private String baiduUrl = "http://www.baidu.com";

    public String sendMessage(String name,String moneny_number,String date) {
        super.urlStr = this.sendMessageUrl;
        TemplateDataPojo templateDataPojo1 = new TemplateDataPojo();
        templateDataPojo1.setValue(name);
        templateDataPojo1.setColor("#173177");
        TemplateDataPojo templateDataPojo2 = new TemplateDataPojo();
        templateDataPojo2.setValue(moneny_number);
        templateDataPojo2.setColor("#173177");
        TemplateDataPojo templateDataPojo3 = new TemplateDataPojo();
        templateDataPojo3.setValue(date);
        templateDataPojo3.setColor("#173177");

        TemplateDataContentPojo templateDataContentPojo = new TemplateDataContentPojo();
        templateDataContentPojo.setName(templateDataPojo1);
        templateDataContentPojo.setMoney_number(templateDataPojo2);
        templateDataContentPojo.setDate(templateDataPojo3);

        TemplatePojo templatePojo = new TemplatePojo();
        templatePojo.setData(templateDataContentPojo);
        templatePojo.setTouser(userId);
        templatePojo.setTopcolor("#173177");
        templatePojo.setTemplate_id(templateId);
        templatePojo.setUrl(baiduUrl);
        String responseMessage = super.sendMessagePost(templatePojo);

        return responseMessage;
    }

    public static void main(String[] args) {
        SendTemplateMessageServer sendTemplateMessageServer = new SendTemplateMessageServer();
        String responseMessage = sendTemplateMessageServer.sendMessage("张三", "500万", new Date().toString());
        System.out.println(responseMessage);
    }

}
