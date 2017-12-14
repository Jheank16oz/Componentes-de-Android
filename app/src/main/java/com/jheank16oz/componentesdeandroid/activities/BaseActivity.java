package com.jheank16oz.componentesdeandroid.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by APPTITUD on 12/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
