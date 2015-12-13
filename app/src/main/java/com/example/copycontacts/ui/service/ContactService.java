package com.example.copycontacts.ui.service;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import com.example.copycontacts.base.Repository;

import java.util.ArrayList;

/**
 * Created by Михайлик on 13.12.2015.
 */
public class ContactService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    Repository repository;
    private ArrayList list;
    public ContactService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        repository = new Repository(this);
        list = (ArrayList) repository.getCalls();
        Toast.makeText(this,list.size(),Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
