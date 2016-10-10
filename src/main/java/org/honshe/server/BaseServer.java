package org.honshe.server;

import net.sf.json.JSONObject;
import org.honshe.util.AccessTokenUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class BaseServer {
    protected String urlStr = "";

    public String sendMessagePost(Object sendMessage) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObj = JSONObject.fromObject(sendMessage);

        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
        String url = urlStr + AccessTokenUtil.getAccessToken().getAccess_token();
        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }

    /**
     * 上传文件
     * @param absoluteFilePath 文件绝对路径
     * @param fileName 文件名称
     * @return 结果
     */
    public String uploadImagePost(String absoluteFilePath,String fileName,String url) {
        RestTemplate restTemplate = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(absoluteFilePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("jarFile",resource);
        param.add("fileName",fileName);

        return restTemplate.postForObject(url, param, String.class);
    }

}
