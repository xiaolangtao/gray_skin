package cn.gray.skin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import cn.gray.skin.R;

public class JiangPingAdapter extends PagerAdapter {

    Context context;
    ViewPager pager;
    int[] layouts = new int[]{R.layout.item_jiangpin, R.layout.item_jiangpin, R.layout.item_jiangpin};

    public JiangPingAdapter(Context context, ViewPager pager) {
        this.context = context;
        this.pager = pager;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int item = layouts[position];
        View view = LayoutInflater.from(context).inflate(item, pager, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
