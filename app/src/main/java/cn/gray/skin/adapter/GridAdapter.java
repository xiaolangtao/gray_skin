package cn.gray.skin.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.gray.skin.R;
import cn.gray.skin.entity.Function;
import q.rorbin.badgeview.QBadgeView;

/**
 * Description:
 * Date:2022-03-21
 * Author:xiaolangtao
 */
public class GridAdapter extends BaseAdapter {

    Context context;
    List<Function> data;
    Function function;

    public GridAdapter(Context context, List<Function> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Function getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        function = getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_layout, null);
            holder.picture = convertView.findViewById(R.id.iv_item_grid);
            holder.name = convertView.findViewById(R.id.tv_item_grid);
            holder.point = convertView.findViewById(R.id.iv_item_point);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.picture.setImageResource(function.getResource());
        holder.name.setText(function.getName());
        if (!function.isState()) {
            holder.point.setVisibility(View.GONE);
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView picture;
        TextView name;
        ImageView point;
    }
}
