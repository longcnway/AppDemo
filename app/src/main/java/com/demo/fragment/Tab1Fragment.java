package com.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.demo.activity.R;
import com.demo.data.DataGenerator;

public class Tab1Fragment extends Fragment {

    private TextView mTextView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TAG", "Tab1Fragment-->onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "Tab1Fragment-->onCreate()");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1_layout, null);

        mTextView = view.findViewById(R.id.tab1_TV);
        Bundle bundle = getArguments();
        bundle.getInt("tab_position");
        if(bundle != null){
            mTextView.setText("Tab1Fragment---" +getResources().getString(DataGenerator.mTabtext[bundle.getInt("tab_position")]).toString() );
        }

        Log.d("TAG", "Tab1Fragment-->onCreateView()");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG", "Tab1Fragment-->onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "Tab1Fragment-->onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Tab1Fragment-->onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "Tab1Fragment-->onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "Tab1Fragment-->onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG", "Tab1Fragment-->onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "Tab1Fragment-->onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG", "Tab1Fragment-->onDetach()");
    }
}
