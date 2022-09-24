package com.jcarterw.a2_webbrowser;

import android.os.Bundle;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init
        History history = new History();
        final WebView webView = new WebView(this);
        LinearLayout topLayout = new LinearLayout(this);
        LinearLayout webLayout = new LinearLayout(this);
        LinearLayout mainLayout = new LinearLayout(this);

        final LinearLayout.LayoutParams topParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.HORIZONTAL
        );
        topLayout.setLayoutParams(topParams);

        final LinearLayout.LayoutParams webParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.VERTICAL
        );
        webLayout.setLayoutParams(webParams);

        final LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
                );
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(mainParams);

        // ADDRESS BAR -----------------------------------------------------------------------------
        final AppCompatEditText addressBar = new AppCompatEditText(this);
        final LinearLayout.LayoutParams params3 =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1);
        addressBar.setLayoutParams(params3);

        // BACK BUTTON -----------------------------------------------------------------------------
        AppCompatButton back = new AppCompatButton(this);
        back.setText("<");
        final LinearLayout.LayoutParams params0 =
                new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        back.setLayoutParams(params0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.prevCurr();
                addressBar.setText(history.getData());
                webView.loadUrl(history.getData());
            }
        });

        // FORWARD BUTTON --------------------------------------------------------------------------
        AppCompatButton forward = new AppCompatButton(this);
        forward.setText(">");
        final LinearLayout.LayoutParams params1 =
                new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        forward.setLayoutParams(params1);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.nextCurr();
                addressBar.setText(history.getData());
                webView.loadUrl(history.getData());
            }
        });

        // GO BUTTON -------------------------------------------------------------------------------
        AppCompatButton go = new AppCompatButton(this);
        go.setText("G");
        final LinearLayout.LayoutParams params2 =
                new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        go.setLayoutParams(params2);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.appendNode(addressBar.getText().toString());
                addressBar.setText(addressBar.getText().toString());
                webView.loadUrl(addressBar.getText().toString());
                webView.setWebViewClient(new WebViewClient());
            }
        });

        // add everything to the view
        topLayout.addView(back);
        topLayout.addView(forward);
        topLayout.addView(addressBar);
        topLayout.addView(go);
        webLayout.addView(webView);
        mainLayout.addView(topLayout);
        mainLayout.addView(webLayout);

        setContentView(mainLayout);
    }

}