package org.honshe.util;

import com.alibaba.fastjson.JSON;
import org.honshe.pojo.AccessToken;
import org.honshe.pojo.menu.Caidan;
import org.honshe.pojo.menu.TotalMenu;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class MenuUtil {
    public static void create(AccessToken accessToken){
        URL url = null;
        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            url = new URL("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken.getAccess_token());
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);//如果是post请求需要加上这句。
            outputStream = connection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

//            bufferedWriter.write(getStr(caidanList));
            bufferedWriter.write(getMenu2());
            System.out.println(getMenu2());
            bufferedWriter.flush();

            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);

            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb);
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //查询菜单
    public static String selectMenu(){
        StringBuffer sb = new StringBuffer();
        HttpURLConnection connection = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            AccessToken accessToken = AccessTokenUtil.getAccessToken();
            String accessTokenStr = accessToken.getAccess_token();
            URL url = new URL("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessTokenStr);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                bufferedReader.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return sb.toString();
    }

    private static String getMenu2() {
        TotalMenu totalMenu = new TotalMenu();
        List<Caidan> caidanList = new ArrayList<>();

        //01
        Caidan caidan_1 = new Caidan();
        List<Caidan> list_1 = new ArrayList<>();
        caidan_1.setName("扫码");

        //0101
        Caidan caidan_1_1 = new Caidan();
        caidan_1_1.setType("scancode_waitmsg");
        caidan_1_1.setName("扫码带提示");
        caidan_1_1.setKey("rselfmenu_0_0");

        list_1.add(caidan_1_1);

        //0102
        Caidan caidan_1_2 = new Caidan();
        caidan_1_2.setType("scancode_push");
        caidan_1_2.setName("扫码推事件");
        caidan_1_2.setKey("rselfmenu_0_1");

        list_1.add(caidan_1_2);
        caidan_1.setSub_button(list_1);

        //02
        Caidan caidan_2 = new Caidan();
        caidan_2.setName("发图");
        List<Caidan> list_2 = new ArrayList<>();

        //0201
        Caidan caidan_2_1 = new Caidan();
        caidan_2_1.setType("pic_sysphoto");
        caidan_2_1.setName("系统拍照发图");
        caidan_2_1.setKey("rselfmenu_1_0");
        list_2.add(caidan_2_1);

        //0202
        Caidan caidan_2_2 = new Caidan();
        caidan_2_2.setType("pic_photo_or_album");
        caidan_2_2.setName("拍照或者相册发图");
        caidan_2_2.setKey("rselfmenu_1_1");
        list_2.add(caidan_2_2);

        //0203
        Caidan caidan_2_3 = new Caidan();
        caidan_2_3.setType("pic_weixin");
        caidan_2_3.setName("微信相册发图");
        caidan_2_3.setKey("rselfmenu_1_2");
        list_2.add(caidan_2_3);
        caidan_2.setSub_button(list_2);

        //03
        Caidan caidan_3 = new Caidan();
        caidan_3.setName("文章列表");
        caidan_3.setType("view");
        caidan_3.setUrl("http://yangmiweixin.ngrok.cc/get/index");


        caidanList.add(caidan_1);
        caidanList.add(caidan_2);
        caidanList.add(caidan_3);

        totalMenu.setButton(caidanList);
        return JSON.toJSONString(totalMenu);
    }

    private static String getStr(List<Caidan> caidanList){
        TotalMenu totalMenu = new TotalMenu();
        List button = new ArrayList();

        Caidan fCaidan1 = new Caidan();
        fCaidan1.setType("click");
        fCaidan1.setName("今日歌曲");
        fCaidan1.setKey("V1001_TODAY_MUSIC");

        Caidan fCaidan2 = new Caidan();
        fCaidan2.setName("菜单");
        List<Caidan> CaidanList2 = new ArrayList<Caidan>();

        Caidan cCaidan2_1 = new Caidan();
        cCaidan2_1.setType("view");
        cCaidan2_1.setName("搜索");
        cCaidan2_1.setUrl("http://www.soso.com");

        Caidan cCaidan2_2 = new Caidan();
        cCaidan2_2.setType("view");
        cCaidan2_2.setName("视频");
        cCaidan2_2.setUrl("http://v.qq.com");

        Caidan cCaidan2_3 = new Caidan();
        cCaidan2_3.setType("click");
        cCaidan2_3.setName("赞我们一下");
        cCaidan2_3.setKey("V1001_GOOD");

        CaidanList2.add(cCaidan2_1);
        CaidanList2.add(cCaidan2_2);
        CaidanList2.add(cCaidan2_3);

        fCaidan2.setSub_button(CaidanList2);
        button.add(fCaidan1);
        button.add(fCaidan2);

        totalMenu.setButton(button);

        String str = JSON.toJSONString(totalMenu);
        return str;
    }

    public static void main(String[] args) {
        MenuUtil.create(AccessTokenUtil.getAccessToken());
//        System.out.println(selectMenu());
    }
}
