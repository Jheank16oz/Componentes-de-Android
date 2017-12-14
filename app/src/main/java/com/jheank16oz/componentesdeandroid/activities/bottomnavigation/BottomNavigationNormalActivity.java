package com.jheank16oz.componentesdeandroid.activities.bottomnavigation;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.activities.BaseActivity;
import com.jheank16oz.componentesdeandroid.activities.ColorActivity;

public class BottomNavigationNormalActivity extends BaseActivity {

    int[][] states = new int[][] {
            new int[] { android.R.attr.state_checked}, // checked
            new int[] {-android.R.attr.state_checked}, // unchecked
    };

    int[] colors = new int[] {0,0};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.store:
                    mContentTextView.setText(getString(R.string.store));
                    return true;
                case R.id.restaurant:
                    mContentTextView.setText(R.string.restaurants);
                    return true;
                case R.id.map:
                    mContentTextView.setText(R.string.map);
                    return true;
            }
            return false;
        }
    };
    private TextView mContentTextView;
    private int SELECT_COLOR = 1;
    private int SELECT_COLOR_ICON_AND_TEXT = 2;
    private int SELECT_COLOR_ICON_AND_TEXT_UNCHECKED = 3;
    private BottomNavigationView navigation;
    private TextView mColorTextView;
    private TextView mColor2TextView;

    private TextView mColor3TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_normal);

        colors[0] = getResources().getColor(R.color.white);
        colors[1] = getResources().getColor(R.color.transparent_white);

        mContentTextView = findViewById(R.id.content);
        mContentTextView.setText(getString(R.string.store));
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mColorTextView = findViewById(R.id.color);
        mColor2TextView = findViewById(R.id.color2);
        mColor3TextView = findViewById(R.id.color3);
        mColorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getBaseContext(),ColorActivity.class), SELECT_COLOR);
            }
        });
        mColor2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getBaseContext(),ColorActivity.class), SELECT_COLOR_ICON_AND_TEXT);
            }
        });
        mColor3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getBaseContext(),ColorActivity.class), SELECT_COLOR_ICON_AND_TEXT_UNCHECKED);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_COLOR) {
                Integer result = data.getIntExtra("color", 0);
                if (result != 0) {
                    navigation.setBackgroundColor(result);
                    mColorTextView.setBackgroundColor(result);
                }

            } else if (requestCode == SELECT_COLOR_ICON_AND_TEXT) {
                Integer result = data.getIntExtra("color", 0);
                if (result != 0) {
                    navigation.setItemIconTintList(makeSelector(0,result));
                    navigation.setItemTextColor(makeSelector(0,result));
                    mColor2TextView.setBackgroundColor(result);
                }
            } else if (requestCode == SELECT_COLOR_ICON_AND_TEXT_UNCHECKED) {
                Integer result = data.getIntExtra("color", 0);
                if (result != 0) {
                    navigation.setItemIconTintList(makeSelector(1,result));
                    navigation.setItemTextColor(makeSelector(1,result));
                    mColor3TextView.setBackgroundColor(result);
                }
            }
        }
    }

    public  ColorStateList makeSelector(int position, int color) {
        colors[position] = color;
        return new ColorStateList(states, colors);
    }
}
