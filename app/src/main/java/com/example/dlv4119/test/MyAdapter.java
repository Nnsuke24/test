package com.example.dlv4119.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dlv4119 on 2016/05/31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder>{

    ArrayList<String> mDataSet;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ItemViewHolder(View v){
            super(v);
            mTextView = (TextView)v.findViewById(R.id.textView);
        }
    }

    /**
     * コンストラクタ
     * @param mDataSet
     */
    public MyAdapter(ArrayList<String> mDataSet){
        this.mDataSet = mDataSet;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()) .inflate(R.layout.text_row, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final String data;
        data = mDataSet.get(position);
        holder.mTextView.setText(mDataSet.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFromDataset(data);
            }
        });
    }

    @Override public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * リストからデータを削除
     * @param data
     */
    protected void removeFromDataset(String data){
        for(int i = 0; i< mDataSet.size(); i++){
            if(mDataSet.get(i).equals(data)){
                mDataSet.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }
}
