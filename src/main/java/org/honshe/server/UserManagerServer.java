package org.honshe.server;

import org.honshe.util.AccessTokenUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class UserManagerServer {

    private String createGroupUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?" +
            "access_token=";

    private String getUserListUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

    private String groupForUserUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";

    /**
     * 移动用户分组
     */
    public String groupForUser(int groupId,String openid){
        StringBuffer sb = new StringBuffer();
        sb.append("{\"openid\":\""+openid+"\",\"to_groupid\":"+groupId+"}");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=utf-8");
        headers.setContentType(mediaType);
        headers.add("Accpt", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(sb.toString(), headers);

        return restTemplate.postForObject(groupForUserUrl + AccessTokenUtil.getAccessToken().getAccess_token(),
                formEntity, String.class);
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    public String getUserList() {
        RestTemplate restTemplate = new RestTemplate();

        return String.valueOf(restTemplate.getForEntity(getUserListUrl + AccessTokenUtil.getAccessToken().getAccess_token(), String.class));
    }


    /**
     * 创建分组
     *
     * @return
     */
    public String createGroup() {
        RestTemplate restTemplate = new RestTemplate();
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append(" \"group\": {");
        sb.append("\"id\": 107, ");
        sb.append("\"name\": \"第一组\"");
        sb.append("}");
        sb.append("}");

        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=utf-8");
        headers.setContentType(mediaType);
        headers.add("Accpt", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(sb.toString(), headers);

        String responseMessage = restTemplate.postForObject(createGroupUrl + AccessTokenUtil.getAccessToken().getAccess_token()
                , formEntity, String.class);

        return responseMessage;
    }

    public static void main(String[] args) {
        UserManagerServer userManagerServer = new UserManagerServer();
//        System.out.println(userManagerServer.createGroup());

//        System.out.println(userManagerServer.getUserList());

        System.out.println(userManagerServer.groupForUser(1,"o8c8gv2xIfwC52nKN3aGfUhNwq4E"));
    }

}
