package org.honshe.util;

import com.alibaba.fastjson.JSON;
import org.honshe.pojo.AccessToken;
import org.honshe.pojo.TenXunServerIp;
import org.honshe.pojo.Wx_ARG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class AccessTokenUtil {

    /**
     * 获取access_token
     * @return
     */
    public static AccessToken getAccessToken() {
        AccessToken accessToken = null;
        URL url = null;
        URLConnection connection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Wx_ARG.appid +
                    "&secret=" + Wx_ARG.secret);
            connection = url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            accessToken = JSON.parseObject(sb.toString(), AccessToken.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return accessToken;
    }

    /**
     * 获取微信服务器ip
     *
     * @return
     */
    public static TenXunServerIp getIp() {
        URL url = null;
        URLConnection connection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        TenXunServerIp tenXunServerIp = new TenXunServerIp();
        try {
            url = new URL("https://api.weixin.qq.com/cgi-bin/getcallbackip?" +
                    "access_token=elE6Hn0YgPZpzQoS3b111hvrkDvPElXBcLOuELq1KhAzB_mNQMF4dGJ8irTv3ikCt1OJ2Nf_VFEWtrxOL-cDvembPzenMsUiGLBk0qZD02SlRZvV3zlVby8d59ymK8g_QIUaAGAXPB");
            connection = url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            tenXunServerIp = JSON.parseObject(sb.toString(), TenXunServerIp.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tenXunServerIp;
    }

    public static void main(String[] args) {
//        System.out.println(AccessTokenUtil.getAccessToken());
        AccessTokenUtil.getIp();
    }
}
