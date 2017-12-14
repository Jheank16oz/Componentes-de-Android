package com.jheank16oz.componentesdeandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.activities.bottomnavigation.BottomNavigationNormalActivity;

import java.util.ArrayList;

/**
 * Created by APPTITUD on 5/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.ViewHolder>{

    private final Context context;
    private LayoutInflater mInflater;
    private ArrayList<String> data;

    public SimpleListAdapter(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.simple_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = data.get(position);
        holder.mTittleView.setText(item);
        holder.view.setOnClickListener(onClick(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private Class[] classes = new Class[]{
            BottomNavigationNormalActivity.class
    };
    private View.OnClickListener onClick(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, classes[position]));
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTittleView;
        View view;

        ViewHolder(View itemView) {
            super(itemView);
            mTittleView =  itemView.findViewById(R.id.text);
            view = itemView;
        }

    }


}