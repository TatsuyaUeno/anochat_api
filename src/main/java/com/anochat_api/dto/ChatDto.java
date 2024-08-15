package com.anochat_api.dto;

import java.time.LocalDateTime;

public class ChatDto {
    private Integer chatid;

    private String chatName;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    // デフォルトコンストラクタ
    public ChatDto() {}

    // すべてのフィールドを初期化するコンストラクタ
    public ChatDto(Integer chatid, String chatName, LocalDateTime createDate, LocalDateTime updateDate) {
        this.chatid = chatid;
        this.chatName = chatName;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void setChatid(Integer chatid) {
        this.chatid = chatid;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getChatid() {
        return this.chatid;
    }

    public String getChatName() {
        return this.chatName;
    }

    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

}
