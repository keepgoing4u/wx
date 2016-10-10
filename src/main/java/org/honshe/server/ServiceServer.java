package org.honshe.server;

import com.alibaba.fastjson.JSON;
import org.honshe.pojo.service.imageText.ArticlesPojo;
import org.honshe.pojo.service.imageText.ServiceImageTextContentPojo;
import org.honshe.pojo.service.imageText.ServiceImageTextPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 客服消息
 * Created by Administrator on 2016/9/30 0030.
 */
public class ServiceServer extends BaseServer{

    public String sendServer(String content){
        this.urlStr = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
        String s = this.sendMessagePost(content);
        return s;
    }

    public static void main(String[] args) {

        //发送文本消息
        ServiceServer serviceServer = new ServiceServer();
//
//        ServiceTextPojo servicePojo = new ServiceTextPojo();
//        servicePojo.setMsgtype("text");
//        servicePojo.setTouser("o8c8gv2xIfwC52nKN3aGfUhNwq4E");
//        servicePojo.setText(new ServiceTextContentPojo("范德萨咖啡奥的斯"));
//
//        String returnMessage = serviceServer.sendServer(JSON.toJSONString(servicePojo));
//        System.out.println(returnMessage);

        //发送图片
        String media_id = "cZdJNARvqJWOBQYtG1iPfRK6-BXrLU6FLi1EDD2gqyfCJEQLc8Suku8SwjpnGktI";
//        ServiceImagePojo servicePojo = new ServiceImagePojo();
//        servicePojo.setTouser("o8c8gv2xIfwC52nKN3aGfUhNwq4E");
//        servicePojo.setMsgtype("image");
//        servicePojo.setImage(new ServiceImageIdPojo(media_id));
//        String returnMessage = serviceServer.sendServer(JSON.toJSONString(servicePojo));

        //发送音乐
//        ServiceMusicContentPojo serviceMusicContentPojo = new ServiceMusicContentPojo();
//        serviceMusicContentPojo.setDescription("好音乐");
//        serviceMusicContentPojo.setThumb_media_id(media_id);
//        serviceMusicContentPojo.setTitle("mami宝贝");
//        serviceMusicContentPojo.setMusicurl("http://yangmiweixin.ngrok.cc/file/motherBaby.mp3");
//        serviceMusicContentPojo.setHqmusicurl("http://yangmiweixin.ngrok.cc/file/motherBaby.mp3");
//
//        ServiceMusicPojo serviceMusicPojo = new ServiceMusicPojo();
//        serviceMusicPojo.setMusic(serviceMusicContentPojo);
//        serviceMusicPojo.setMsgtype("music");
//        serviceMusicPojo.setTouser("o8c8gv2xIfwC52nKN3aGfUhNwq4E");


        //发送视频
//        String videoId = "sjo55f18Axd0VW6TgPrO3BpKwTuVg7cBsHFhftIZtgMGVKXuHnfXL25LXbRzgOpo";
//
//        ServiceVideoPojo serviceVideoPojo = new ServiceVideoPojo();
//        serviceVideoPojo.setTouser("o8c8gv2xIfwC52nKN3aGfUhNwq4E");
//        serviceVideoPojo.setMsgtype("video");
//
//        ServiceVideoContentPojo serviceVideoContentPojo = new ServiceVideoContentPojo();
//        serviceVideoContentPojo.setTitle("张震岳：抱着你");
//        serviceVideoContentPojo.setThumb_media_id(media_id);
//        serviceVideoContentPojo.setDescription("好听");
//        serviceVideoContentPojo.setMedia_id(videoId);
//
//        serviceVideoPojo.setVideo(serviceVideoContentPojo);

        //发送图文

        ServiceImageTextPojo serviceImageTextPojo = new ServiceImageTextPojo();
        serviceImageTextPojo.setTouser("o8c8gv2xIfwC52nKN3aGfUhNwq4E");
        serviceImageTextPojo.setMsgtype("news");

        ArticlesPojo articlesPojo = new ArticlesPojo();
        List<ServiceImageTextContentPojo> list = new ArrayList<>();
        ServiceImageTextContentPojo serviceImageTextContentPojo1 = new ServiceImageTextContentPojo();
        serviceImageTextContentPojo1.setDescription("消息1");
        serviceImageTextContentPojo1.setPicurl("http://yangmiweixin.ngrok.cc/file/image/aaaa.jpg");
        serviceImageTextContentPojo1.setTitle("自定义文章页面");
        serviceImageTextContentPojo1.setUrl("http://yangmiweixin.ngrok.cc/get/index");

        ServiceImageTextContentPojo serviceImageTextContentPojo2 = new ServiceImageTextContentPojo();
        serviceImageTextContentPojo2.setDescription("消息2");
        serviceImageTextContentPojo2.setPicurl("http://yangmiweixin.ngrok.cc/file/image/aaaa.jpg");
        serviceImageTextContentPojo2.setTitle("别管我");
        serviceImageTextContentPojo2.setUrl("www.baidu.com");


        list.add(serviceImageTextContentPojo1);
        list.add(serviceImageTextContentPojo2);
        articlesPojo.setArticles(list);

        serviceImageTextPojo.setNews(articlesPojo);


        String returnMessage = serviceServer.sendServer(JSON.toJSONString(serviceImageTextPojo));
        System.out.println(returnMessage);
//        System.out.println(AccessTokenUtil.getAccessToken());

    }

}
