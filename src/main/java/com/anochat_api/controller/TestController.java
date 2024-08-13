package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.dto.TestResponseDto;
import com.anochat_api.service.TestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 【サンプルクラス】
 * ・コントローラーと呼ばる
 * ・責務：Webとアプリケーションの仲介
 * ・行うこと
 * 　・エンドポイント定義
 * 　・レスポンスを返す
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /* ログ */
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    
    @PostMapping("/sample")
    public List<TestResponseDto> postMethodName(@RequestBody String entity) {
        // レスポンスを初期化
        List<TestResponseDto> res = new ArrayList<TestResponseDto>();
        
        try {
            System.out.println("接続に成功しました");
            log.info("接続に成功しました");
            res = testService.getUserInfo();
        } catch (Exception e) {
            System.out.println("予期せぬエラー");
            log.error("予期せぬエラーが発生しました。");
        }
        return res;
    }

    @GetMapping("/test")
    public String hello() {
        return "Hello!";
    }
}
