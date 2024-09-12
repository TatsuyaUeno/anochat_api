package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.dto.MessageRequestDto;
import com.anochat_api.dto.MessageResponseDto;
import com.anochat_api.service.MessageService;


/**
 * メッセージ一覧取得
 */
@RestController  // このクラスがRESTfulなWebサービスのコントローラーであることを示すアノテーションです。
@RequestMapping("/api/chatList")  // このコントローラーが扱うエンドポイントのベースURIを"/api/chatList"に設定します。
public class MessageController {  // コントローラークラス。APIのエンドポイントを定義する場所です。
    
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);  
    // ログ出力用のLoggerを定義。エラーメッセージやデバッグ情報を出力するために使用します。

    @Autowired  // SpringがMessageServiceのインスタンスを自動的に注入（DI: Dependency Injection）します。
    private MessageService messageService;  // ビジネスロジックを実行するサービスクラスのインスタンスを取得します。

    @PostMapping("/getChatList")  // HTTP POSTリクエストを受け取るメソッドを指定します。エンドポイントは"/api/chatList/getChatList"です。
    public List<MessageResponseDto> getMessageList(@RequestBody MessageRequestDto messageResponseDto) {  
        // リクエストボディからMessageRequestDto型のデータを受け取り、そのデータを使用して処理を行います。
        List<MessageResponseDto> messages = new ArrayList<MessageResponseDto>();  
        // メッセージリストを格納するためのリストを初期化します。最終的にこのリストがレスポンスとして返されます。

        try {  
            Integer chatid = messageResponseDto.getChatid();  // リクエストから取得したDTOからチャットIDを抽出します。
            messages = messageService.getMessageList(chatid);  // 抽出したチャットIDを使って、メッセージサービスからメッセージリストを取得します。
        } catch (Exception e) {  
            log.error("予期せぬエラーが発生しました。ChatId: " + messageResponseDto.getChatid(), e);  
            // 例外が発生した場合にエラーメッセージをログに出力します。どのチャットIDでエラーが起きたかも記録します。
        }

        return messages;  // 処理が正常に完了した場合、メッセージリストをレスポンスとして返します。
    }
}
