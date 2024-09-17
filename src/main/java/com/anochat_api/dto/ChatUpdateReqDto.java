package com.anochat_api.dto;

import java.time.LocalDateTime;

// チャット一覧情報登録更新時のリクエストボディ
public class ChatUpdateReqDto {
    private Integer chatId;

    private String chatName;

    private LocalDateTime chatDate;

    public Integer getChatId() {
        return chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public LocalDateTime getChatDate() {
        return chatDate;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setChatDate(LocalDateTime chatDate) {
        this.chatDate = chatDate;
    }
}
