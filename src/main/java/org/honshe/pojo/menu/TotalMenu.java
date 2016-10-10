package org.honshe.pojo.menu;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class TotalMenu {
    private List<Caidan> button;

    public List<Caidan> getButton() {
        return button;
    }

    public void setButton(List<Caidan> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "TotalMenu{" +
                "button=" + button +
                '}';
    }

    public static void main(String[] args) {
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
    }
}
