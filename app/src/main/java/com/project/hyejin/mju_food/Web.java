package com.project.hyejin.mju_food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Web extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        web = findViewById(R.id.webView1);

        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");

        web.setWebViewClient(new WebViewClient());

        WebSettings webset = web.getSettings();
        webset.setBuiltInZoomControls(true);

        web.loadUrl(url);


    }

    class WebViewClient extends android.webkit.WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
