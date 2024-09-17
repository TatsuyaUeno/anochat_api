package com.anochat_api.util;

import org.springframework.stereotype.Component;

@Component
public class SaveChatId {

  private Integer chatId;

  public Integer getChatId() {
    return this.chatId;
  }

  public void setChatId(Integer chatId) {
    this.chatId = chatId;
  }
}
