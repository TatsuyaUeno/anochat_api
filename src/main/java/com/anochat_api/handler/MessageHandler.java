package com.anochat_api.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocketに接続した際呼び出される
 * 各ブラウザのセッションから、双方向通信を実装
 * @author tatsu
 *
 */
public class MessageHandler extends TextWebSocketHandler  {
	
	/** 各ブラウザのセッションを保持 */
	private List<WebSocketSession> sessions = new ArrayList<>();

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
     * TODO:受信と送信を分けるべき
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("メッセージ受信:" + message.getPayload());
        for (WebSocketSession s : sessions) {
            try {
                s.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
