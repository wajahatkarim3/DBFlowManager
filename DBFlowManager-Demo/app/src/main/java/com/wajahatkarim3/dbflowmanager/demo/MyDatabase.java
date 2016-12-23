package com.wajahatkarim3.dbflowmanager.demo;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Wajahat on 12/23/2016.
 */

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "MyDataBase";

    public static final int VERSION = 1;
}
