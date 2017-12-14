package com.jheank16oz.componentesdeandroid.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.adapters.SimpleListAdapter;

import java.util.ArrayList;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class BottomNavigationActivity extends BaseActivity {

    private ArrayList<String> bottomNavigationList = new ArrayList<>();
    private SimpleListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.bottom_navigation));
        setContentView(R.layout.activity_bottom_navigation);

        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeComponents();
    }

    /**
     * metodo encargado de inicializar los componentes,
     * esto para desalojar el oncreate
     */
    private void initializeComponents() {
        RecyclerView mBottomList = findViewById(R.id.list);
        mAdapter= new SimpleListAdapter(this, bottomNavigationList);
        mBottomList.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        mBottomList.setAdapter(mAdapter);

        getBottomNavigationList();
    }

    private void getBottomNavigationList() {
        bottomNavigationList.clear();
        bottomNavigationList.add(getString(R.string.normal));
        bottomNavigationList.add(getString(R.string.cambio_de_colores));
        bottomNavigationList.add(getString(R.string.comportamiento_en_listas));

        mAdapter.notifyDataSetChanged();

    }
}
