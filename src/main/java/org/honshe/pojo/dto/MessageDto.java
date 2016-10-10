package org.honshe.pojo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
@XmlRootElement
public class MessageDto {
    private String ToUserName;
    private String MsgType;
    private Long CreateTime;
    private String FromUserName;
    private String Content;
    private String MsgId;
    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "ToUserName='" + ToUserName + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", CreateTime=" + CreateTime +
                ", FromUserName='" + FromUserName + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId='" + MsgId + '\'' +
                ", Event='" + Event + '\'' +
                '}';
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
