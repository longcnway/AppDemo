package com.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.activity.FruitActivity;
import com.demo.activity.R;
import com.demo.model.Fruit;

import java.util.List;

public class FruitCardViewAdapter extends RecyclerView.Adapter<FruitCardViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitCardViewAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    /**
     * 创建MyViewHolder内部类，当convertView为null时，对控件进行缓存
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View view) {
            super(view);
            cardView = (CardView) view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_cv_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_cv_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item_card_view, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME, fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID, fruit.getImageId());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
//        holder.fruitImage.setImageResource(fruit.getImageId());
        //图片压缩控件Glide
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
