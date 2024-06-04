package com.anochat_api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anochat_api.dao.TestDao;
import com.anochat_api.dto.TestResponseDto;
import com.anochat_api.logic.ChatLogic;;

/**
 * 【サンプルクラス】
 * ・サービスと呼ばれる
 * ・責務：ビジネスロジックを担当
 * ・行うこと
 * 　・一連のビジネスロジックを定義
 */
@Service
public class TestService {

    /* ログ */
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private TestDao testDao;
    
    public List<TestResponseDto> getUserInfo() {
        log.info("テスト処理を開始します。");
        // 戻り値を初期化
        List<TestResponseDto> res = new ArrayList<TestResponseDto>();

        // ↓↓↓ビジネスロジックを定義↓↓↓
        try {
            // データベースから値を取得
            res = testDao.getUserInfo();
        } catch (Exception e) {
            // サービスクラスの例外はthrow
            log.error("データベース接続でエラーが発生しました。");
        }


        log.info("テスト処理を終了します。");
        
        return res;
    }
}
