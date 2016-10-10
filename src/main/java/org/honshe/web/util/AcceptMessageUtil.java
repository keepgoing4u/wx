package org.honshe.web.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.honshe.pojo.dto.MessageDto;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class AcceptMessageUtil {

    public static Map<String,String> readMessage(HttpServletRequest request){
        InputStream is = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            is = request.getInputStream();
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(is);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for(Element o:list){
                map.put(o.getName(), o.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String messageToXml(MessageDto messageDto) {
        XStream xStream = new XStream();
        xStream.alias("xml",messageDto.getClass());
        return xStream.toXML(messageDto);
    }
}
