package com.anochat_api.dto;

public class ChatDto {
    private Integer chatId;

    private String chatName;

    private String chatDate;

    private String updateDate;

    // デフォルトコンストラクタ
    public ChatDto() {}

    // すべてのフィールドを初期化するコンストラクタ
    public ChatDto(Integer chatId, String chatName, String chatDate, String updateDate) {
        this.chatId = chatId;
        this.chatName = chatName;
        this.chatDate = chatDate;
        this.updateDate = updateDate;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getChatId() {
        return this.chatId;
    }

    public String getChatName() {
        return this.chatName;
    }

    public String getChatDate() {
        return this.chatDate;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

}
