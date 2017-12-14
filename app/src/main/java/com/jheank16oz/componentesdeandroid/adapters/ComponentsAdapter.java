package com.jheank16oz.componentesdeandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.activities.BottomNavigationActivity;
import com.jheank16oz.componentesdeandroid.models.Component;

import java.util.ArrayList;

/**
 * Created by APPTITUD on 5/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public class ComponentsAdapter extends RecyclerView.Adapter<ComponentsAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private ArrayList<Component> data;

    public ComponentsAdapter(Context context, ArrayList<Component> data) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.grid_item_component, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Component item = data.get(position);
        holder.mTittleView.setText(item.name);
        holder.mContentView.setText(item.content);
        holder.mImageView.setImageResource(item.drawable);
        holder.view.setOnClickListener(onClick(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTittleView;
        TextView mContentView;
        ImageView mImageView;
        View view;

        ViewHolder(View itemView) {
            super(itemView);
            mTittleView =  itemView.findViewById(R.id.name);
            mContentView =  itemView.findViewById(R.id.content);
            mImageView =  itemView.findViewById(R.id.image);
            view = itemView;
        }

    }

    private Class[] classes = new Class[]{
            BottomNavigationActivity.class
    };
    private View.OnClickListener onClick(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, classes[position]));
            }
        };
    }

}