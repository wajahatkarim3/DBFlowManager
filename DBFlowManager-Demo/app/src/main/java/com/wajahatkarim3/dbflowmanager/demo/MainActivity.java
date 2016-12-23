package com.wajahatkarim3.dbflowmanager.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.wajahatkarim3.dbflowmanager.AndroidDatabaseManager;
import com.wajahatkarim3.dbflowmanager.demo.database.DemoDatabase;
import com.wajahatkarim3.dbflowmanager.demo.database.UserModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserModel um = new UserModel();
        um.email = "sasd@gmail.com";
        um.save();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (BuildConfig.DEBUG) {
            if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
                //Do something
                Intent ii = new Intent(this, AndroidDatabaseManager.class);
                ii.putExtra("className", DemoDatabase.class);
                startActivity(ii);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
