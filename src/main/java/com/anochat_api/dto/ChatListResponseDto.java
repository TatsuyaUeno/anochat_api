package com.anochat_api.dto;

public class ChatListResponseDto {
    private Integer chatListId;
    private String content;
    private String date;

    public Integer getChatListId() {
        return chatListId;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void setChatListId(Integer chatListId) {
        this.chatListId = chatListId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
