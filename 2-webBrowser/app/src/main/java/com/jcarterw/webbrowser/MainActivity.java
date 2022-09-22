package com.jcarterw.webbrowser;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jcarterw.webbrowser.databinding.ActivityMainBinding;
import com.jcarterw.webbrowser.History;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        History history = new History();
        // create layout
        LinearLayout layout = new LinearLayout(this);
        // BACK BUTTON -----------------------------------------------------------------------------
        AppCompatButton back = new AppCompatButton(this);
        back.setText("<");
        final LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        back.setLayoutParams(params0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.prevCurr(); // adjust history
                // TODO: take you to new site
            }
        });

        // FORWARD BUTTON --------------------------------------------------------------------------
        AppCompatButton forward = new AppCompatButton(this);
        forward.setText(">");
        final LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        forward.setLayoutParams(params1);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.nextCurr(); // adjust history
                // TODO: take you to new site
            }
        });
        // ADDRESS BAR -----------------------------------------------------------------------------
        // TODO: fix size
        final AppCompatEditText addressBar = new AppCompatEditText(this);
        final LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addressBar.setLayoutParams(params3);
        // GO BUTTON -------------------------------------------------------------------------------
        AppCompatButton go = new AppCompatButton(this);
        go.setText("G");
        final LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT);
        go.setLayoutParams(params2);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: set text in address bar when on new page
                // when pressed add to history
//                history.appendNode(**ADDRESS**);
                // TODO: move to next page
            }
        });

        // display content of webpage
        // TODO: this entire section

        // add everything to the view
        layout.addView(back);
        layout.addView(forward);
        layout.addView(addressBar);
        layout.addView(go);
//        layout.addView(); // webpage

        setContentView(layout);
    }

}