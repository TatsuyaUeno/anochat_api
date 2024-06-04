package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anochat_api.dto.TestResponseDto;
import com.anochat_api.service.TestService;

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
@Controller
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
            res = testService.getUserInfo();
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました。");
        }

        return res;
    }
}
