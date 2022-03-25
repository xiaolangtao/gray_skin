package cn.gray.skin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.gray.skin.R;
import cn.gray.skin.constant.IConstant;
import cn.gray.skin.entity.Daka;

public class DakaAdapter extends BaseAdapter implements IConstant {

    Context context;
    List<Daka> data;
    Daka bean;

    public DakaAdapter(Context context, List<Daka> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Daka getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        bean = getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_daka, null);
            holder.icon = convertView.findViewById(R.id.iv_daka_icon);
            holder.day = convertView.findViewById(R.id.tv_daka_day);
            holder.yiqiandao = convertView.findViewById(R.id.iv_daka_yiqiandao);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(bean.getIcon());
        holder.day.setText(bean.getDay());
        switch (bean.getState()) {
            case IConstant.DAKA_YIQIANDAO:
                convertView.setBackground(context.getDrawable(bean.getBg()));
                holder.yiqiandao.setVisibility(View.VISIBLE);
                break;
            case IConstant.DAKA_LINGQU:
                convertView.setBackground(context.getDrawable(bean.getBg()));
                holder.yiqiandao.setVisibility(View.GONE);
                break;
            case IConstant.DAKA_QITA:
                break;
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView day;
        ImageView yiqiandao;
    }
}
