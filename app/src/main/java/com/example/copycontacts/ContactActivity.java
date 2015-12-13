package com.example.copycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.copycontacts.base.Repository;
import com.example.copycontacts.domain.ContactsName;
import com.example.copycontacts.domain.entities.Calls;
import com.example.copycontacts.ui.CallsView;
import com.example.copycontacts.ui.Presenter;
import com.example.copycontacts.ui.service.ContactService;

import java.util.List;

public class ContactActivity extends AppCompatActivity implements CallsView{
    ContactsName contactsName;
    Presenter presenter;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        contactsName = new ContactsName(this);
        contactsName.getContactsName(getContentResolver());

        textView = (TextView)findViewById(R.id.activity_contacts_name);
        textView.setText("");

        presenter = new Presenter(this,new Repository(this));
        presenter.showCalls();



    }
    @Override
    public void showCalls(List<Calls> list) {
        for (int i = 0; i < list.size(); i++) {
            Calls calls = list.get(i);
            String txt = calls.toString();
           textView.append(txt);
        }
    }
    public void startService(View view){

    }
}