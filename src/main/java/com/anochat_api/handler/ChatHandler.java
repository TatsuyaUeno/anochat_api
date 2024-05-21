package com.anochat_api.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.anochat_api.logic.ChatLogic;

/**
 * WebSocketに接続した際呼び出される
 * 各ブラウザのセッションから、双方向通信を実装
 * @author tatsu
 *
 */
public class ChatHandler extends TextWebSocketHandler  {
	
	/** 各ブラウザのセッションを保持 */
	private List<WebSocketSession> sessions = new ArrayList<>();

    /** チャットLogic */
    @Autowired
    private ChatLogic chatLogic;

    /** ログ */
    private static final Logger log = LoggerFactory.getLogger(ChatHandler.class);

    /**
     * 接続確立
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	sessions.add(session);
        System.out.println("WebSocketの接続が確立しました。");
    }
    /**
     * メッセージの送受信
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
            log.info("メッセージが送信されました");
            chatLogic.sendChat(message, sessions);
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました", e);;
        }
    }
    /**
     * 接続終了
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	sessions.remove(session);
        System.out.println("WebSocketの接続が終了しました。");
    }

}
