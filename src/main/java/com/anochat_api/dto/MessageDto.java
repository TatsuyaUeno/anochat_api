package com.anochat_api.dto;

public class MessageDto {
    private Integer msgId;

    private Integer chatId;

    private String msgContent;

    private String sendTime;

    // デフォルトコンストラクタ
    public MessageDto() {}

    // すべてのフィールドを初期化するコンストラクタ
    public MessageDto(Integer chatid, Integer messageid, String message, String date) {
        this.chatId = chatid;
        this.msgId = messageid;
        this.msgContent = message;
        this.sendTime = date;
    }

    public void setChatid(Integer chatid) {
        this.chatId = chatid;
    }

    public void setMessageid(Integer messageid) {
        this.msgId = messageid;
    }

    public void setMessage(String message) {
        this.msgContent = message;
    }

    public void setDate(String date) {
        this.sendTime = date;
    }

    public Integer getChatid() {
        return this.chatId;
    }

    public Integer getMessageid() {
        return this.msgId;
    }

    public String getMessage() {
        return this.msgContent;
    }

    public String getDate() {
        return this.sendTime;
    }
}
