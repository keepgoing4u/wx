package org.honshe.server.material;

import org.honshe.server.BaseServer;
import org.honshe.util.AccessTokenUtil;

/**
 * 素材管理
 * Created by Administrator on 2016/10/10 0010.
 */
public class MaterialManagerServer extends BaseServer {

    private String addPerpetualMaterialUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";

    private String addTemporaryMaterialUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";

    //新增永久素材
    public String addPerpetualMaterial() {

        return "";
    }

    //新增临时素材
    public String addTemporaryMaterial() {
        String url = addTemporaryMaterialUrl + AccessTokenUtil.getAccessToken().getAccess_token() + "&type=image";
        String responseMessage = super.uploadImagePost("F:\\IdeaProjects\\ymwx\\src\\main\\webapp\\file\\image\\small01.jpg", "small01.jpg", url);

        return responseMessage;
    }

    public static void main(String[] args) {
        MaterialManagerServer materialManagerServer = new MaterialManagerServer();
        System.out.println(materialManagerServer.addTemporaryMaterial());
    }


    //临时素材  图片  media_id = MhfEm8-BU2DrSFhgHS6ezXScjpKrm3CfDOhMev1ngskkUCREkv9Kgyt4zoK7wCgX
}
