package org.honshe.server.templateMessage;

import net.sf.json.JSONObject;
import org.honshe.server.BaseServer;
import org.honshe.util.AccessTokenUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class SetIndustry extends BaseServer{

    private String setIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + AccessTokenUtil.getAccessToken().getAccess_token();

    //添加模板url
    private String addTemplateUrl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + AccessTokenUtil.getAccessToken().getAccess_token();


    public String addTemplateId() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"template_id_short\":\"NEGjw7MNArS1LRXfICr3vyr_mmFqwqvqzE0DJhefdvQ\"");
        sb.append("}");

        String responseMessage = sendPostRequstSb(sb,this.addTemplateUrl);

        return responseMessage;
    }

    public String sendPostRequstSb(StringBuffer sb,String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(mediaType);
        headers.add("Accpt", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(sb.toString(), headers);
        String responseMessage = restTemplate.postForObject(url, formEntity, String.class);
        return responseMessage;
    }


    public String setIndustryId(Object messagePojo){
        String responseMessage = super.sendMessagePost(JSONObject.fromObject(messagePojo).toString());
        return responseMessage;
    }

    public static void main(String[] args) {
        SetIndustry setIndustry = new SetIndustry();
//        IndustryPojo industryPojo = new IndustryPojo();
//        industryPojo.setIndustry_id1("1");
//        industryPojo.setIndustry_id2("10");
//        String message = setIndustry.setIndustryId(industryPojo);
//        System.out.println(message);

        System.out.println(setIndustry.addTemplateId());
    }
}
