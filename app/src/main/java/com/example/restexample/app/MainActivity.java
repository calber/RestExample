package com.example.restexample.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.rest.RestService;

import java.sql.SQLException;


@EActivity
public class MainActivity extends Activity {

    @RestService
    JsonApi japi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OrmHelper orm = OrmHelper.getInstance(this);
        (new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Response g = japi.getResponse();

                try {
                    orm.getResponseDao().createOrUpdate(g);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
