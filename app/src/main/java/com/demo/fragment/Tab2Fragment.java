package com.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.demo.activity.R;
import com.demo.data.DataGenerator;

public class Tab2Fragment extends Fragment {
    private TextView mTextView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab2_layout, null);

        mTextView = view.findViewById(R.id.tab2_TV);
        Bundle bundle = getArguments();
        if(bundle != null){
            mTextView.setText("Tab2Fragment---" +getResources().getString(DataGenerator.mTabtext[bundle.getInt("tab_position")]).toString() );
        }
        return view;
    }
}
