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

public class Tab4Fragment extends Fragment {
    private TextView mTextView;
    private View view;
    /*private ITabFramentCallBack tabFramentCallBack;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        tabFramentCallBack.CallBackFun();
    }*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab4_layout, null);

        mTextView = view.findViewById(R.id.tab4_TV);
        Bundle bundle = getArguments();
        if(bundle != null){
            mTextView.setText("Tab4Fragment---" +getResources().getString(DataGenerator.mTabtext[bundle.getInt("tab_position")]).toString() );
        }
        return view;
    }

    /*public interface ITabFramentCallBack {
        void CallBackFun();
    }*/
}
