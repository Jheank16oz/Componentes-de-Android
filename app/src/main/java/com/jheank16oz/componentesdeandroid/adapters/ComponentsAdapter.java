package com.jheank16oz.componentesdeandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jheank16oz.componentesdeandroid.R;
import com.jheank16oz.componentesdeandroid.models.Component;

import java.util.ArrayList;

/**
 * Created by APPTITUD on 5/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public class ComponentsAdapter extends RecyclerView.Adapter<ComponentsAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Component> data;

    public ComponentsAdapter(Context context, ArrayList<Component> data) {
        this.mInflater = LayoutInflater.from(context);
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTittleView;
        TextView mContentView;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mTittleView =  itemView.findViewById(R.id.name);
            mContentView =  itemView.findViewById(R.id.content);
            mImageView =  itemView.findViewById(R.id.image);
        }

    }


}