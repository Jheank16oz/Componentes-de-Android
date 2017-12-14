package com.jheank16oz.componentesdeandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jheank16oz.componentesdeandroid.R;

import java.util.ArrayList;

/**
 * Created by APPTITUD on 13/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public class ColorAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<Integer> colors;

    public ColorAdapter(Context c, ArrayList<Integer> colors) {
        mContext = c;
        this.colors = colors;
        mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    public int getCount() {
        return colors.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_color, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setBackgroundColor(colors.get(position));
        return convertView;
    }
    public static class ViewHolder {
        TextView textView;
    }


}