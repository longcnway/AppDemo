package com.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.demo.adapter.FruitAdapter;
import com.demo.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    private Button mBT_Line;
    private Button mBT_Gray;
    private Button mBT_Stag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //初始化水果数据
        intiFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
        mBT_Line = (Button) findViewById(R.id.bt_line);
        mBT_Gray = (Button) findViewById(R.id.bt_grid);
        mBT_Stag = (Button) findViewById(R.id.bt_stag);
        mBT_Line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置横向排列
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });
        mBT_Gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(RecyclerViewActivity.this, 4);
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
        mBT_Stag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
            }
        });
    }

    private void intiFruits(){
        for(int i=0;i<3;i++){
            Fruit fruit1 = new Fruit("fruit1111111111", R.drawable.fruit_imge1);
            fruitList.add(fruit1);
            Fruit fruit2 = new Fruit("fruit2", R.drawable.fruit_imge2);
            fruitList.add(fruit2);
            Fruit fruit3 = new Fruit("fruit3333333333", R.drawable.fruit_imge3);
            fruitList.add(fruit3);
            Fruit fruit4 = new Fruit("fruit4", R.drawable.fruit_imge4);
            fruitList.add(fruit4);
            Fruit fruit5 = new Fruit("fruit5555555555", R.drawable.fruit_imge5);
            fruitList.add(fruit5);
            Fruit fruit6 = new Fruit("fruit6", R.drawable.fruit_imge6);
            fruitList.add(fruit6);
            Fruit fruit7 = new Fruit("fruit7777777777", R.drawable.fruit_imge7);
            fruitList.add(fruit7);
            Fruit fruit8 = new Fruit("fruit8", R.drawable.fruit_imge8);
            fruitList.add(fruit8);
            Fruit fruit9 = new Fruit("fruit9999999999", R.drawable.fruit_imge9);
            fruitList.add(fruit9);
            Fruit fruit10 = new Fruit("fruit10", R.drawable.fruit_imge10);
            fruitList.add(fruit10);
        }
    }
}