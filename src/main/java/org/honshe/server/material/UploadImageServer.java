package org.honshe.server.material;

import net.sf.json.JSONObject;
import org.honshe.pojo.massImageAndText.ImageAndTextContentPojo;
import org.honshe.pojo.massImageAndText.ImageAndTextPojo;
import org.honshe.util.AccessTokenUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class UploadImageServer {

    private String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="+ AccessTokenUtil.getAccessToken().getAccess_token();
    private String filePath = "F:\\IdeaProjects\\ymwx\\src\\main\\webapp\\file\\image\\small01.jpg";

    private String responsImageUrl = "http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/lcnMYJosa7IIzuoqCVCWjic1yiateNnmxF8O0I1IroOb6YXwnY17Obx0bts4IEFAOI8ZNVcYDAdOT6ZcUrt5BD2w\\/0";
    private String responsImageUrl2 = "lcnMYJosa7IIzuoqCVCWjic1yiateNnmxF8O0I1IroOb6YXwnY17Obx0bts4IEFAOI8ZNVcYDAdOT6ZcUrt5BD2w";

    private String uploadImageAndTextUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + AccessTokenUtil.getAccessToken().getAccess_token();

    //在web项目中获取 class目录
//    public String getFilePath(){
//        return this.getClass().getClassLoader().getResource("/").getPath();
//    }

    public String uploadImageAndText(){
        ImageAndTextPojo imageAndTextPojo = new ImageAndTextPojo();
        ImageAndTextContentPojo imageAndTextContentPojo1 = new ImageAndTextContentPojo();
        imageAndTextContentPojo1.setAuthor("张三");
        imageAndTextContentPojo1.setThumb_media_id("MhfEm8-BU2DrSFhgHS6ezXScjpKrm3CfDOhMev1ngskkUCREkv9Kgyt4zoK7wCgX");
        imageAndTextContentPojo1.setTitle("做个测试");
        imageAndTextContentPojo1.setContent_source_url("http://www.baidu.com");
        imageAndTextContentPojo1.setContent("<div>是我</div>");
        imageAndTextContentPojo1.setDigest("我是描述");
        imageAndTextContentPojo1.setShow_cover_pic("1");
        ImageAndTextContentPojo imageAndTextContentPojo2 = new ImageAndTextContentPojo();
        imageAndTextContentPojo2.setAuthor("张三2");
        imageAndTextContentPojo2.setThumb_media_id("MhfEm8-BU2DrSFhgHS6ezXScjpKrm3CfDOhMev1ngskkUCREkv9Kgyt4zoK7wCgX");
        imageAndTextContentPojo2.setTitle("做个测试2");
        imageAndTextContentPojo2.setContent_source_url("http://www.baidu.com");
        imageAndTextContentPojo2.setContent("<div>是我2</div>");
        imageAndTextContentPojo2.setDigest("我是描述2");
        imageAndTextContentPojo2.setShow_cover_pic("0");

        List list = new ArrayList();
        list.add(imageAndTextContentPojo1);
        list.add(imageAndTextContentPojo2);
        imageAndTextPojo.setArticles(list);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObj = JSONObject.fromObject(imageAndTextPojo);

        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        String responseMessage = restTemplate.postForObject(uploadImageAndTextUrl, formEntity, String.class);

        return responseMessage;
    }
    //上传图文消息素材 media_id=NkN_NCq4SBbWod_mK4n88ZQDDBylBcM0o1RdhwDmtmY2cZmdpGqGeqbhfl5Ga9Im

    public String uoloadImage() {
        RestTemplate restTemplate = new RestTemplate();
        File file = new File(filePath);
        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("jarFile", resource);
        param.add("fileName", "small01.jpg");
        String responseMessage = restTemplate.postForObject(url, param, String.class);

        return responseMessage;
    }

    public static void main(String[] args) {
        UploadImageServer uploadImageServer = new UploadImageServer();

        System.out.println(uploadImageServer.uploadImageAndText());
//        System.out.println(uploadImageServer.uoloadImage());
    }
}
