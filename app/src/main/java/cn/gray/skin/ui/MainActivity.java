package cn.gray.skin.ui;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import cn.gray.skin.R;
import cn.gray.skin.fragment.DrawFragment;
import cn.gray.skin.fragment.MyFragment;
import cn.gray.skin.fragment.PartyFragment;
import cn.gray.skin.fragment.ShoppingFragment;

public class MainActivity extends AppCompatActivity {

    private int mIndex;
    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initRadioGroup();
        initFragment();
    }

    private void initRadioGroup() {
        RadioGroup radioGroup = findViewById(R.id.main_radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_rb_shopping:
                        setIndexSelected(0);
                        break;
                    case R.id.main_rb_draw:
                        setIndexSelected(1);
                        break;
                    case R.id.main_rb_party:
                        setIndexSelected(2);
                        break;
                    case R.id.main_rb_my:
                        setIndexSelected(3);
                        break;
                }
            }
        });
    }

    private void initFragment() {
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        DrawFragment drawFragment = new DrawFragment();
        PartyFragment partyFragment = new PartyFragment();
        MyFragment myFragment = new MyFragment();
        mFragments = new Fragment[]{shoppingFragment, drawFragment, partyFragment, myFragment};
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frame, shoppingFragment).commit();
        setIndexSelected(0);
    }

    private void setIndexSelected(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mFragments[mIndex]);//隐藏
        //判断是否添加
        if (!mFragments[index].isAdded()) {
            transaction.add(R.id.main_frame, mFragments[index]).show(mFragments[index]);
        } else {
            transaction.show(mFragments[index]);
        }
        transaction.commit();
        mIndex = index;//再次赋值
    }

}