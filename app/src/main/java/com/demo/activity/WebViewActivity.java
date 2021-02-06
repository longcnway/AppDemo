package com.demo.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends BaseActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);//支持Javascript脚本
        webView.setWebViewClient(new WebViewClient());//当从一个网页跳转到另一个网页时，目标网页仍然在当前WebView中，而不是打开系统浏览器
        webView.loadUrl("https://www.baidu.com");

    }
}