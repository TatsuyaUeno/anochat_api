package com.anochat_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.anochat_api.handler.MessageHandler;

/**
 * WebSocketのハンドラー
 * Spring起動時に呼び出される
 * @author tatsu
 *
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer  {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(messageHandler(), "/ws-connect")	// 「通信ハンドラー」と「初回接続パス」の設定
                .setAllowedOrigins("localhost:8080")			// CORSの設定
                .withSockJS();									// SockJSを有効にする
    }

    /**
     * 実体は「MessageHandler」クラス
     * Beanは特定の規則に準じたクラス
     * @return
     */
    @Bean
    public WebSocketHandler messageHandler() {
        return new MessageHandler();
    }
}