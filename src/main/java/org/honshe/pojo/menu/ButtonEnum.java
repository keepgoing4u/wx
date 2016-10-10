package org.honshe.pojo.menu;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public enum ButtonEnum {
    click("click"),view("click"),scancode_push("scancode_push");

    private String value;

    private ButtonEnum(){}
    private ButtonEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
