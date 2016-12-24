package com.wajahatkarim3.dbflowmanager.demo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.wajahatkarim3.dbflowmanager.DBFlowManagerActivity;
import com.wajahatkarim3.dbflowmanager.demo.database.CompanyModel;
import com.wajahatkarim3.dbflowmanager.demo.database.DemoDatabase;
import com.wajahatkarim3.dbflowmanager.demo.database.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main) LinearLayout layoutMain;
    @BindView(R.id.txtRecordsCount) TextView txtRecordsCount;
    @BindView(R.id.radioGroupTable) RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        updateCountText();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                if (checkId == R.id.radioUser)
                {
                    txtRecordsCount.setText(SQLite.select().from(UserModel.class).queryList().size() + "");
                }
                else if (checkId == R.id.radioCompany)
                {
                    txtRecordsCount.setText(SQLite.select().from(CompanyModel.class).queryList().size() + "");
                }
            }
        });
    }

    @OnClick(R.id.btnDBManager)
    public void dbManagerClick()
    {
        DBFlowManagerActivity.launchDatabaseManager(this, DemoDatabase.class);
    }

    @OnClick(R.id.btnAddRecord)
    public void addRecord()
    {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioUser)
        {
            UserModel userModel = new UserModel();
            userModel.username = generateRandomString();
            userModel.email = userModel.username + "@mycompany.com";
            userModel.save();

            Snackbar.make(layoutMain, "User Record Added in Database!", Snackbar.LENGTH_SHORT).show();
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioCompany)
        {
            CompanyModel companyModel = new CompanyModel();
            companyModel.companyName = generateRandomString() + " Corporation";
            companyModel.phone = generateRandomPhone();
            companyModel.save();

            Snackbar.make(layoutMain, "Company Record Added in Database!", Snackbar.LENGTH_SHORT).show();
        }
        updateCountText();
    }

    @OnClick(R.id.btnRemoveRecord)
    public void deleteRecord()
    {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioUser)
        {
            List<UserModel> list = SQLite.select().from(UserModel.class).queryList();
            if (list.size() > 0) {
                list.get(0).delete();
                Snackbar.make(layoutMain, "User Record Deleted from Database!", Snackbar.LENGTH_SHORT).show();
            }
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioCompany)
        {
            List<CompanyModel> list = SQLite.select().from(CompanyModel.class).queryList();
            if (list.size() > 0) {
                list.get(0).delete();
                Snackbar.make(layoutMain, "Company Record Deleted in Database!", Snackbar.LENGTH_SHORT).show();
            }
        }
        updateCountText();
    }

    @OnClick(R.id.btnClearTable)
    public void clearTable()
    {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioUser)
        {
            Delete.table(UserModel.class);
            Snackbar.make(layoutMain, "User Table cleared in Database!", Snackbar.LENGTH_SHORT).show();
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioCompany)
        {
            Delete.table(CompanyModel.class);
            Snackbar.make(layoutMain, "Company Table Cleared in Database!", Snackbar.LENGTH_SHORT).show();
        }
        updateCountText();
    }

    public void updateCountText()
    {
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioUser)
        {
            txtRecordsCount.setText(SQLite.select().from(UserModel.class).queryList().size() + "");
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.radioCompany)
        {
            txtRecordsCount.setText(SQLite.select().from(CompanyModel.class).queryList().size() + "");
        }
    }

    public String generateRandomString()
    {
        String randStr = "";

        // class variable
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

        final java.util.Random rand = new java.util.Random();
        StringBuilder builder = new StringBuilder();
        //while(builder.toString().length() == 0)
        {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            randStr = builder.toString();
        }

        return randStr;
    }

    public String generateRandomPhone()
    {
        String randPhone = "+1 ";

        // class variable
        final String lexicon = "12345674890";
        final java.util.Random rand = new java.util.Random();
        StringBuilder builder = new StringBuilder();
        int length = rand.nextInt(5)+5;
        length = 8;
        for(int i = 0; i < length; i++) {
            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
        }
        randPhone = builder.toString();
        return randPhone;
    }
}
