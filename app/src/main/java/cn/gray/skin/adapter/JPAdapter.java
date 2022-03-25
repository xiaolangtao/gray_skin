package cn.gray.skin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.gray.skin.R;
import cn.gray.skin.entity.JiangPin;

public class JPAdapter extends RecyclerView.Adapter<JPAdapter.ViewHolder> {

    Context context;
    List<JiangPin> data = new ArrayList<>();
    JiangPin bean;

    public JPAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<JiangPin> beans) {
        if (beans == null) return;
        data.clear();
        data.addAll(beans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jiangpin, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bean = data.get(position);
        holder.content.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_jiangpin_content)
        TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
