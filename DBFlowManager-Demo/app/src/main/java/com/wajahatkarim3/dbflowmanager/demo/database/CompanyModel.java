package com.wajahatkarim3.dbflowmanager.demo.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Wajahat Karim on 12/23/2016.
 */

@Table(database = DemoDatabase.class)
public class CompanyModel extends BaseModel {

    @Column @PrimaryKey(autoincrement = true) public int companyId;
    @Column public String companyName;
    @Column public String phone;

}
