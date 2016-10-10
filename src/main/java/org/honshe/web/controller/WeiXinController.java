package org.honshe.web.controller;

import org.honshe.pojo.dto.MessageDto;
import org.honshe.pojo.validata.Signature;
import org.honshe.web.util.AcceptMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
@Controller
@RequestMapping(value = "test")
@PropertySources(value = {@PropertySource("classpath:config.properties")})
public class WeiXinController {

    @Autowired
    Environment environment;

    @ResponseBody
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Signature signature) {

//        String[] strArray = new String[]{"ymweixin",signature.getTimestamp(),signature.getNonce()};
//
//        Arrays.sort(strArray);
//
//        StringBuffer sb = new StringBuffer();
//
//        for(String o:strArray){
//            sb.append(o);
//        }
//
//        String s=DigestUtils.shaHex(sb.toString());

        return signature.getEchostr();
    }


    @ResponseBody
//    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = {"application/xml;charset=UTF-8"})
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index2(HttpServletRequest request) {
        Map<String, String> map = AcceptMessageUtil.readMessage(request);
        String responseStr = null;
        String type = map.get("MsgType");
        System.out.println(map);
        MessageDto messageDto = new MessageDto();
        messageDto.setCreateTime(new Date().getTime());
        messageDto.setFromUserName(map.get("ToUserName"));
        messageDto.setToUserName(map.get("FromUserName"));
        messageDto.setMsgId(map.get("MsgId"));
        switch (type) {
            case "text":
                messageDto.setMsgType("text");
                messageDto.setContent("您发送的消息为：" + map.get("Content"));
                break;
            case "event":
                String eventype = map.get("Event");
                System.err.println(eventype);
                switch (eventype){
                    case "subscribe":
                        System.out.println("我是来订阅的！");
                        messageDto.setMsgType("text");
                        messageDto.setContent("欢迎来到杨米空间！");
                        break;
                    case "unsubscribe":
                        System.out.println("我退订了");
                        break;
                }
                break;
            default :
        }
        responseStr=AcceptMessageUtil.messageToXml(messageDto);
        System.out.println(responseStr+"--------------");
        return responseStr;
    }

}
