package com.wajahatkarim3.dbflowmanager.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.wajahatkarim3.dbflowmanager.AndroidDatabaseManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (BuildConfig.DEBUG) {
            if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
                //Do something
                Intent ii = new Intent(this, DatabaseActivity.class);
                ii.putExtra("className", MyDatabase.class);
                startActivity(ii);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
