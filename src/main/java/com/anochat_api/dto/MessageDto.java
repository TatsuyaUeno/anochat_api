package com.anochat_api.dto;

public class MessageDto {
    private Integer chatid;

    private Integer messageid;

    private String message;

    // デフォルトコンストラクタ
    public MessageDto() {}

    // すべてのフィールドを初期化するコンストラクタ
    public MessageDto(Integer chatid, Integer messageid, String message) {
        this.chatid = chatid;
        this.messageid = messageid;
        this.message = message;
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

    public Integer getChatid() {
        return this.chatid;
    }

    public Integer getMessageid() {
        return this.messageid;
    }

    public String getMessage() {
        return this.message;
    }
}
