package com.wajahatkarim3.dbflowmanager.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wajahatkarim3.dbflowmanager.AndroidDatabaseManager;

public class DatabaseActivity extends AndroidDatabaseManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myClass = MyDatabase.class;
    }
}
