package cn.gray.skin.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import cn.gray.skin.R;
import cn.gray.skin.adapter.DakaAdapter;
import cn.gray.skin.adapter.JPAdapter;
import cn.gray.skin.constant.IConstant;
import cn.gray.skin.entity.Daka;
import cn.gray.skin.entity.JiangPin;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrawFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GridView gridView;
    private List<Daka> dakaList = new ArrayList<>();
    private List<JiangPin> jiangPinList = new ArrayList<>();
    private RecyclerView recyclerView;

    public DrawFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrawFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrawFragment newInstance(String param1, String param2) {
        DrawFragment fragment = new DrawFragment();
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
        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        gridView = view.findViewById(R.id.gv_daka);
        recyclerView = view.findViewById(R.id.re_choujiang);
        initGridView();
        initViewPager();
        return view;
    }

    private void initViewPager() {
        JiangPin jiangPin1 = new JiangPin("iPhone13碎片");
        jiangPinList.add(jiangPin1);
        JiangPin jiangPin2 = new JiangPin("iPhone14碎片");
        jiangPinList.add(jiangPin2);
        JiangPin jiangPin3 = new JiangPin("iPhone15碎片");
        jiangPinList.add(jiangPin3);
        JiangPin jiangPin4 = new JiangPin("iPhone16碎片");
        jiangPinList.add(jiangPin4);

        Log.d("GGG","re="+recyclerView);
        Log.d("GGG","JIANGPINS="+jiangPinList);
        JPAdapter adapter = new JPAdapter(getActivity());
        adapter.setData(jiangPinList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(adapter);
    }

    private void initGridView() {
        Daka daka1 = new Daka(R.mipmap.icon_kuang_hui, R.mipmap.icon_dqm_111, "第1天", IConstant.DAKA_YIQIANDAO);
        dakaList.add(daka1);
        Daka daka2 = new Daka(R.mipmap.icon_kuang, R.mipmap.icon_dqm_222, "第2天", IConstant.DAKA_LINGQU);
        dakaList.add(daka2);
        Daka daka3 = new Daka(R.mipmap.icon_kuang, R.mipmap.icon_dqm_333, "第3天", IConstant.DAKA_LINGQU);
        dakaList.add(daka3);

        DakaAdapter adapter = new DakaAdapter(getActivity(), dakaList);
        gridView.setAdapter(adapter);
    }
}