package org.honshe.server.advancedMassInterface;

import org.honshe.util.AccessTokenUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * 高级群发接口
 * Created by Administrator on 2016/10/10 0010.
 */
public class AMIServer {
    //根据OpenID列表群发
    private String sendByOpenIdUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";

    private String sendByGroupUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";

    /**
     * 根据分组进行群发
     * 测试号是没有群发图文消息权限的
     * @return
     */
    public String sendByGroup() {
        //准备数据
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"filter\":{");
        sb.append("\"is_to_all\":false");
        sb.append("\"group_id\":\"1\"");
        sb.append("},");
        sb.append("\"mpnews\":{");
        sb.append("\"media_id\":\"NkN_NCq4SBbWod_mK4n88ZQDDBylBcM0o1RdhwDmtmY2cZmdpGqGeqbhfl5Ga9Im\"");
        sb.append("},");
        sb.append("\"msgtype\":\"mpnews\"");
        sb.append("}");


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=utf-8");
        httpHeaders.setContentType(mediaType);
        httpHeaders.add("Accpt", MediaType.APPLICATION_JSON_VALUE.toString());
        HttpEntity<String> formEntity = new HttpEntity(sb.toString(), httpHeaders);

        String responseMessage = restTemplate.postForObject(sendByGroupUrl + AccessTokenUtil.getAccessToken().getAccess_token()
                , formEntity, String.class);
        return responseMessage;
    }

    /**
     * 根据OpenID列表群发
     */
    public String sendByOpenId() {
        RestTemplate restTemplate = new RestTemplate();

        //准备数据
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":[");
        sb.append("\"o8c8gv2xIfwC52nKN3aGfUhNwq4E\",");
        sb.append("\"o8c8gv14160Erladaoqt9DHbs1OQ\"");
        sb.append("],");
        sb.append("\"mpnews\":{");
        sb.append("\"media_id\":\"NkN_NCq4SBbWod_mK4n88ZQDDBylBcM0o1RdhwDmtmY2cZmdpGqGeqbhfl5Ga9Im\"");
        sb.append("},");
        sb.append("\"msgtype\":\"mpnews\"");
        sb.append("}");


        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=utf-8");
        httpHeaders.setContentType(mediaType);
        httpHeaders.add("Accpt", mediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(sb.toString(), httpHeaders);

        String responseMessage = restTemplate.postForObject(sendByOpenIdUrl + AccessTokenUtil.getAccessToken().getAccess_token()
                , formEntity, String.class);

        return responseMessage;
    }

    public static void main(String[] args) {
        AMIServer amiServer = new AMIServer();
        //根据openId群发
//        System.out.println(amiServer.sendByOpenId());
        //全体群发
        System.out.println(amiServer.sendByGroup());
    }
}
