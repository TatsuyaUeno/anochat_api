package com.anochat_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * GET/POSTの疎通確認用
 * @author tatsu
 *
 */
@Controller
@RequestMapping
public class StaticAccessController {
	
	/**
	 * 一部を除く全てのGETリクエストでindex.htmlを返す
	 * ↓正規表現で一部パスを除外している
	 * 　・パスに「static」が含まれる場合・・・static配下はjsや画像など直接アクセスできないようにするため
	 * 　・パスに「ws-connect」が含まれる場合・・・WebSocket通信の入口
	 * @return src/main/resource/template配下のindex.html
	 */
	@GetMapping("{path:^(?!.*(?:static|ws-connect)).*$}/**")
	public String getConnectAll() {
		return "index";
	}
	
}
