package com.jheank16oz.componentesdeandroid.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.fragments.AboutFragment;
import com.jheank16oz.componentesdeandroid.fragments.ComponentsFragment;

public class PagerActivity extends BaseActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_components:
                    setFragment(mComponentsFragment);
                    return true;
                case R.id.navigation_info:
                    setFragment(mAboutFragment);
                    return true;
            }
            return false;
        }
    };

    private AboutFragment mAboutFragment;
    private ComponentsFragment mComponentsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        mAboutFragment = new AboutFragment();
        mComponentsFragment = new ComponentsFragment();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(mComponentsFragment);
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment).commit();
    }

}
