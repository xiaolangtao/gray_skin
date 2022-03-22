package cn.gray.skin.fragment;

import android.media.DrmInitData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

import cn.gray.skin.R;
import cn.gray.skin.adapter.GridAdapter;
import cn.gray.skin.adapter.TaskAdapter;
import cn.gray.skin.constant.IConstant;
import cn.gray.skin.entity.Function;
import cn.gray.skin.entity.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GridView gridView;
    private WebView webView;
    private RecyclerView recyclerView;
    private List<Function> functions;
    private List<Task> tasks;

    public ShoppingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingFragment newInstance(String param1, String param2) {
        ShoppingFragment fragment = new ShoppingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        gridView = view.findViewById(R.id.gv_function);
        webView = view.findViewById(R.id.web_view);
        recyclerView = view.findViewById(R.id.recycler_view);
        initData();
        initUI();
        return view;
    }

    private void initData() {
        functions = new ArrayList<>();
        Function fuli = new Function("福利", R.mipmap.wode_icon_fuli, true);
        functions.add(fuli);
        Function jiangpin = new Function("奖品记录", R.mipmap.mine_icon_jiangpin, false);
        functions.add(jiangpin);
        Function yaoqing = new Function("邀请好友", R.mipmap.wode_icon_yaoqinghaoyou, false);
        functions.add(yaoqing);
        Function fankui = new Function("反馈", R.mipmap.wode_icon_fankui, false);
        functions.add(fankui);
        Function shoucang = new Function("我的收藏", R.mipmap.wode_icon_shoucang, false);
        functions.add(shoucang);
        Function kefu = new Function("联系客服", R.mipmap.wode_icon_lianxikefu, false);
        functions.add(kefu);

        webView.loadUrl("http://i3.sinaimg.cn/blog/2014/1029/S129809T1414550868715.jpg");

        tasks = new ArrayList<>();
        Task qiandao = new Task(R.mipmap.mine_icon_bj_chaofan, "每日签到(0/1)", "获得XXX道具名", R.mipmap.mine_icon_qian_dao, IConstant.TASK_HAS_FINISH);
        tasks.add(qiandao);
        Task shipin = new Task(R.mipmap.mine_icon_bj_zhengui,"观看激励视频(0/10)", "获得XXX道具名", R.mipmap.mine_icon_shiping, IConstant.TASK_TO_FINISH);
        tasks.add(shipin);
        Task huodong = new Task(R.mipmap.mine_icon_bj_xiyou,"参与活动", "获得XXX道具名", R.mipmap.mine_icon_huodong, IConstant.TASK_CAN_RECEIVE);
        tasks.add(huodong);
        Task goumai = new Task(R.mipmap.mine_icon_bj_putong,"神秘商人购买", "获得XXX道具名", R.mipmap.mine_icon_goumai, IConstant.TASK_CAN_RECEIVE);
        tasks.add(goumai);
        Task xingyun = new Task(R.mipmap.mine_icon_bj_jinbi,"参与幸运奖池", "获得XXX道具名", R.mipmap.mine_icon_dazhuanpan, IConstant.TASK_CAN_RECEIVE);
        tasks.add(xingyun);
    }

    private void initUI() {
        GridAdapter gridAdapter = new GridAdapter(getActivity(), functions);
        gridView.setAdapter(gridAdapter);

        TaskAdapter taskAdapter = new TaskAdapter(getActivity(), tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(taskAdapter);
    }
}