package com.anochat_api.dto;

import java.time.LocalDateTime;

public class MessageResponseDto {
    private Integer chatListId;
    private String content;
    private LocalDateTime date;

    public Integer getChatListId() {
        return chatListId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setChatListId(Integer chatListId) {
        this.chatListId = chatListId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
