package cn.gray.skin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.gray.skin.R;
import cn.gray.skin.constant.IConstant;
import cn.gray.skin.entity.Task;

/**
 * Description:
 * Date:2022-03-21
 * Author:xiaolangtao
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> implements IConstant {

    Context context;
    List<Task> data;
    Task task;

    public TaskAdapter(Context context, List<Task> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        task = data.get(position);
        if (position!=0) {
            holder.ry_title.setVisibility(View.GONE);
        }
        holder.ivTaskCard.setImageResource(task.getCard());
        holder.tvTaskTitle.setText(task.getTitle());
        holder.tvTaskDesc.setText(task.getDesc());
        holder.btnIcon.setImageResource(task.getIcon());
        switch (task.getState()) {
            case IConstant.TASK_CAN_RECEIVE:
                holder.btnState.setBackground(context.getDrawable(R.mipmap.mine_bth_quwancheng));
                holder.btnState.setText("可领取");
                holder.btnState.setTextColor(Color.parseColor("#913A0D"));
                break;
            case IConstant.TASK_TO_FINISH:
                holder.btnState.setBackground(context.getDrawable(R.mipmap.mine_bth_quwancheng));
                holder.btnState.setText("去完成");
                holder.btnState.setTextColor(Color.parseColor("#913A0D"));
                break;
            case IConstant.TASK_HAS_FINISH:
                holder.btnState.setBackground(context.getDrawable(R.mipmap.mine_bth_kewancheng));
                holder.btnState.setText("已完成");
                holder.btnState.setTextColor(Color.parseColor("#585757"));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler_title)
        TextView ry_title;
        @BindView(R.id.iv_task_card)
        ImageView ivTaskCard;
        @BindView(R.id.tv_task_title)
        TextView tvTaskTitle;
        @BindView(R.id.tv_task_desc)
        TextView tvTaskDesc;
        @BindView(R.id.btn_icon)
        ImageButton btnIcon;
        @BindView(R.id.btn_state)
        Button btnState;

        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
