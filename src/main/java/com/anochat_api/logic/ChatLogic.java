package com.anochat_api.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import java.util.List;
import com.anochat_api.dao.ChatDao;

@Component
public class ChatLogic {

    /** チャットDao */
    @Autowired
    private ChatDao chatDao;

    /** ログ */
    private static final Logger log = LoggerFactory.getLogger(ChatLogic.class);

    public void sendChat(TextMessage message, List<WebSocketSession> sessions) {
        String messageString = message.getPayload();
        log.info("start regist chat!!");
        try {
            // DB登録
            chatDao.resistChat(messageString);

            // 全員にメッセージを返却
            for (WebSocketSession s: sessions) {
                s.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
