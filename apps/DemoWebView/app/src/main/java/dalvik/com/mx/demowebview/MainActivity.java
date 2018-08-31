package dalvik.com.mx.demowebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById( R.id.webView );
//        web.loadUrl("http://www.google.com");
        web.loadUrl("http://dcb5ea99.ngrok.io/app/");
        web.getSettings().setJavaScriptEnabled( true );
        web.setWebViewClient( new WebViewClient() );
    }
}
