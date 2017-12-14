package com.jheank16oz.componentesdeandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.adapters.ColorAdapter;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private ArrayList<Integer> listColors = new ArrayList<>();
    private ColorAdapter mColorAdapter;
    private boolean areSecondaryColors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        GridView gridview = findViewById(R.id.gridview);
        mColorAdapter = new ColorAdapter(this,listColors);
        gridview.setAdapter(mColorAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (!areSecondaryColors) {
                    listColors.clear();
                    listColors.addAll(getColors(getResources().getIntArray(colors[position])));
                    mColorAdapter.notifyDataSetChanged();
                    areSecondaryColors = true;
                }else{
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("color",listColors.get(position));
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            }
        });

        listColors.addAll(getColors(getResources().getIntArray(R.array.colors)));
        mColorAdapter.notifyDataSetChanged();
    }

    int[] colors = new int[]{
            R.array.reds,
            R.array.pinks,
            R.array.purples,
            R.array.dark_purples,
            R.array.indigos,
            R.array.blues,
            R.array.light_blues,
            R.array.cyans,
            R.array.teals,
            R.array.greens,
            R.array.light_greens,
            R.array.limes,
            R.array.yellows,
            R.array.ambers,
            R.array.oranges,
            R.array.deep_oranges,
            R.array.browns,
            R.array.greys,
            R.array.blue_greys};

    private ArrayList<Integer> getColors(int[] colors){
        ArrayList<Integer> intList = new ArrayList<>();
        for (int color : colors) {
            intList.add(color);
        }
        return intList;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        if (areSecondaryColors){
            listColors.clear();
            listColors.addAll(getColors(getResources().getIntArray(R.array.colors)));
            mColorAdapter.notifyDataSetChanged();
            areSecondaryColors = false;
        }else {
            finish();
        }
    }
}
