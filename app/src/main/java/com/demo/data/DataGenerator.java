package com.demo.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.activity.R;

public class DataGenerator {

    public static final int []mTabIcon = new int[]{R.drawable.tab1_gray, R.drawable.tab2_gray, R.drawable.tab3_gray, R.drawable.tab4_gray};
    public static final int []mTabIconPressed = new int[]{R.drawable.tab1_blue, R.drawable.tab2_blue, R.drawable.tab3_blue, R.drawable.tab4_blue};
    public static final int []mTabtext = new int[]{R.string.tab_text1, R.string.tab_text2, R.string.tab_text3, R.string.tab_text4};

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public View getTabView(Context context, int position){

        View view = LayoutInflater.from(context).inflate(R.layout.bottom_tab_item,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_image);
        TextView tabText = (TextView) view.findViewById(R.id.tab_text);
//        if(position == 0){//第一个tab默认选中
//            tabIcon.setImageResource(DataGenerator.mTabIconPressed[position]);
//            tabText.setTextColor(context.getColor(android.R.color.holo_blue_light));
//        }else{
//            tabIcon.setImageResource(DataGenerator.mTabIcon[position]);
//        }
        tabIcon.setImageResource(DataGenerator.mTabIcon[position]);
        tabText.setText(mTabtext[position]);

        return view;
    }

}