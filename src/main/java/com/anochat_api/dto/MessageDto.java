package com.anochat_api.dto;

import java.time.LocalDateTime;

public class MessageDto {
    private Integer msg_id;

    private Integer chat_id;

    private String msg_content;

    private LocalDateTime send_time;

    // デフォルトコンストラクタ
    public MessageDto() {}

    // すべてのフィールドを初期化するコンストラクタ
    public MessageDto(Integer chatid, Integer messageid, String message, LocalDateTime date) {
        this.chat_id = chatid;
        this.msg_id = messageid;
        this.msg_content = message;
        this.send_time = date;
    }

    public void setChatid(Integer chatid) {
        this.chat_id = chatid;
    }

    public void setMessageid(Integer messageid) {
        this.msg_id = messageid;
    }

    public void setMessage(String message) {
        this.msg_content = message;
    }

    public void setDate(LocalDateTime date) {
        this.send_time = date;
    }

    public Integer getChatid() {
        return this.chat_id;
    }

    public Integer getMessageid() {
        return this.msg_id;
    }

    public String getMessage() {
        return this.msg_content;
    }

    public LocalDateTime getDate() {
        return this.send_time;
    }
}
