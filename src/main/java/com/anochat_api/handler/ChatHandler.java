package com.anochat_api.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.anochat_api.logic.ChatLogic;
import com.anochat_api.util.SaveChatId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * WebSocketに接続した際呼び出される
 * WebSocket通信の処理はこのクラス
 * 各ブラウザのセッションから、双方向通信を実装
 * @author tatsu
 *
 */
public class ChatHandler extends TextWebSocketHandler  {
	
	/** 各ブラウザのセッションを保持 */
	private List<WebSocketSession> sessions = new ArrayList<>();

        // クライアントのWebSocketセッションを管理するマップ（chat_idごとにセッションを保持）
    private Map<Integer, Set<WebSocketSession>> chatRooms = new ConcurrentHashMap<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    // クライアントごとの chatId を管理するマップ
    private Map<WebSocketSession, Integer> sessionChatIdMap = new ConcurrentHashMap<>();

    /** チャットLogic */
    @Autowired
    private ChatLogic chatLogic;
    @Autowired
    private SaveChatId saveChatId;

    /** ログ */
    private static final Logger log = LoggerFactory.getLogger(ChatHandler.class);

    /**
     * 接続確立
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // クエリパラメータからchatIdを取得
        Integer chatId = getChatIdFromSession(session);
        if (chatId == null) {
            session.close(CloseStatus.BAD_DATA);
            return;
        }
        sessionChatIdMap.put(session, chatId);
        chatRooms.putIfAbsent(chatId, new HashSet<>());
        chatRooms.get(chatId).add(session);
    	// sessions.add(session);
        System.out.println("WebSocketの接続が確立しました。" + chatId);
    }
    /**
     * メッセージの送受信
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Integer chatId = saveChatId.getChatId();
        Integer chatId = sessionChatIdMap.get(session);

        if (chatId == null) {
            session.close(CloseStatus.BAD_DATA);
            return;
        }

        // JSONメッセージをJavaオブジェクトに変換
        Map<String, Object> messageData = objectMapper.readValue(message.getPayload(), Map.class);
        String action = (String) messageData.get("message"); // リクエストはすでにStringで受け取っているため、この処理は不要。ただ下のコードは
        try {
            log.info("メッセージが送信されました");
            chatLogic.sendChat(chatId, message, sessions);
    
            // String action = message;
    
            // if ("join".equals(action)) {
            //     // チャットルームにクライアントを追加
            //     chatRooms.putIfAbsent(chatId, new HashSet<>());
            //     chatRooms.get(chatId).add(session);
            // } else if ("message".equals(action)) {
            //     // メッセージ送信
                String chatMessage = (String) messageData.get("message");
                broadcastToChatRoom(chatId, chatMessage);
            // }
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました", e);;
        }
    }

    private Integer getChatIdFromSession(WebSocketSession session) {
        // クエリパラメータからchatIdを取得
        String query = session.getUri().getQuery();
        if (query != null && query.contains("chatId")) {
            String[] params = query.split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if ("chatId".equals(keyValue[0])) {
                    return Integer.valueOf(keyValue[1]);
                }
            }
        }
        return null;
    }

    // 特定のチャットルームにメッセージをブロードキャスト
    private void broadcastToChatRoom(Integer chatId, String message) throws Exception {
        Set<WebSocketSession> sessions = chatRooms.get(chatId);
        if (sessions != null) {
            for (WebSocketSession session : sessions) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }

    /**
     * 接続終了
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	// sessions.remove(session);
        // // クライアントが切断されたときにチャットルームから削除
        // for (Set<WebSocketSession> sessions : chatRooms.values()) {
        //     sessions.remove(session);
        // }
        Integer chatId = sessionChatIdMap.remove(session);
        if (chatId != null) {
            chatRooms.get(chatId).remove(session);
            if (chatRooms.get(chatId).isEmpty()) {
                chatRooms.remove(chatId);
            }
        }
        System.out.println("WebSocketの接続が終了しました。");
    }

}
