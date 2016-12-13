package com.example.danman.testapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.danman.testapp.R;
import com.example.danman.testapp.model.SomeModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by DanMan on 12.12.2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<SomeModel> items;
    private OnItemClickCallBack mOnItemClickListener;

    public RecyclerViewAdapter(@NonNull List<SomeModel> models) {
        items = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final SomeModel someModel = items.get(position);
        Glide.with(holder.itemView.getContext())
                .load(someModel.getImage())
                .into(holder.mImageView);
        holder.mFirstLine.setText(someModel.getTextOne());
        holder.mSecondLine.setText(someModel.getTextTwo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mOnItemClickListener.onItemClick(items.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mImageView;
        private TextView mFirstLine;
        private TextView mSecondLine;

        public ViewHolder(View view) {
            super(view);
            mImageView = (CircleImageView) view.findViewById(R.id.image_view);
            mFirstLine = (TextView) view.findViewById(R.id.line_1_tv);
            mSecondLine = (TextView) view.findViewById(R.id.line_2_tv);
        }
    }

    public void setFilter(List<SomeModel> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickCallBack listener) {
        mOnItemClickListener = listener;
    }

    public interface OnItemClickCallBack {
        void onItemClick(SomeModel someModel);
    }

}
