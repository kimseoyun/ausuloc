package sy_317_mirim.ausuloc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = new WebView(MainActivity.this);// webview in mainactivity
        setContentView(webView);// set the webview as the layout
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebClient());//정의한 클래스 사용
        webView.loadUrl("https://ausuloc-1ef9b.firebaseapp.com/Main.html");

    }
    class WebClient extends WebViewClient {
        /*
        * 웹뷰 내 링크 터치 시 새로운 창이 뜨지 않고
        * 해당 웹뷰 안에서 새로운 페이지가 로딩되도록 함
           */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); return true;
        } return super.onKeyDown(keyCode, event);
    }
}

