package com.anochat_api.dto;

public class MessageDto {
    private String chatid;

    private Integer messageid;

    private String message;

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatid() {
        return this.chatid;
    }

    public Integer getMessageid() {
        return this.messageid;
    }

    public String getMessage() {
        return this.message;
    }
}
