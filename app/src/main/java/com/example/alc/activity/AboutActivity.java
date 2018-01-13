package com.example.alc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.alc.R;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_acitivity);

        WebView webView = findViewById(R.id.webview);
        String url = getString(R.string.about_url);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript is required by web app
        webView.addJavascriptInterface(new WebAppInterface(this), "mobile");

        webView.setWebViewClient(new WebViewClient {
            @Override
            public void onPageFinished (WebView view, String url){
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl(url);
    }

    public WebAppInterface(Context context) {
        this.context = context;
    }
}