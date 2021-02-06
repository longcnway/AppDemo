package com.demo.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.demo.data.DataGenerator;
import com.demo.fragment.Tab1Fragment;
import com.demo.fragment.Tab2Fragment;
import com.demo.fragment.Tab3Fragment;
import com.demo.fragment.Tab4Fragment;
import com.google.android.material.tabs.TabLayout;

public class BottomTabLayoutActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private Fragment mFragmensts[] = new Fragment[4];
    private View view;
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_layout);

        mFragmensts[0] = new Tab1Fragment();
        mFragmensts[1] = new Tab2Fragment();
        mFragmensts[2] = new Tab3Fragment();
        mFragmensts[3] = new Tab4Fragment();

        //fragment管理器
        FragmentManager manager = getSupportFragmentManager();
        //fragment
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.home_container, mFragmensts[0]);
        transaction.commit();

        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);
        // 提供自定义的布局添加Tab
        for(int i=0; i<4; i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(new DataGenerator().getTabView(this, i)));
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabItemSelected(tab.getPosition());
                // Tab 选中之后，改变各个Tab的状态
                for (int i=0;i<mTabLayout.getTabCount();i++){
                    view = mTabLayout.getTabAt(i).getCustomView();
                    mImageView = (ImageView) view.findViewById(R.id.tab_image);
                    mTextView = (TextView) view.findViewById(R.id.tab_text);
                    if(i == tab.getPosition()){ // 选中状态
                        mImageView.setImageResource(DataGenerator.mTabIconPressed[i]);
                        mTextView.setTextColor(getColor(android.R.color.holo_blue_light));
                    }else{// 未选中状态
                        mImageView.setImageResource(DataGenerator.mTabIcon[i]);
                        mTextView.setTextColor(getColor(android.R.color.black));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void tabItemSelected(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = mFragmensts[0];
                break;
            case 1:
                fragment = mFragmensts[1];
                break;
            case 2:
                fragment = mFragmensts[2];
                break;
            case 3:
                fragment = mFragmensts[3];
                break;
        }
        if(fragment != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_position", position);
            fragment.setArguments(bundle);
            //replace()重新创建fragment，add()不会重新创建fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
            //getSupportFragmentManager().beginTransaction().add(R.id.home_container, fragment).commit();
        }
    }
}