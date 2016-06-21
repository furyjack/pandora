package com.example.test.lecture4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebAcitivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_acitivy);
        try {


            Intent coming = getIntent();
            WebView webView = (WebView) findViewById(R.id.web_view);
            webView.getSettings().getJavaScriptEnabled();
            String action=coming.getAction();
            if(!action.equals(Intent.ACTION_VIEW)) {


                webView.loadUrl("http://beta.html5test.com/");
                return;
            }

            String add = coming.getDataString();
            Uri url = Uri.parse(add);
            webView.loadUrl(add);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }



    }
}
