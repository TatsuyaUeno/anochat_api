package com.anochat_api.dto;

import java.time.LocalDateTime;

// 新規チャット登録時のリクエストボディ
public class CreateChatRequest {
    private String chatName;

    private LocalDateTime createDate;

    public String getChatName() {
        return chatName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
