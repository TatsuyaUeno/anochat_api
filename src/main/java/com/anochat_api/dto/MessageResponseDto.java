package com.anochat_api.dto;

public class MessageResponseDto {
    private Integer chatid;
    private Integer messageid;
    private String message;

    public Integer getChatid() {
        return chatid;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public String getMessage() {
        return message;
    }

    public void setChatid(Integer chatid) {
        this.chatid = chatid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
