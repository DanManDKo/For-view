package com.example.danman.mvpretrofit.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.model.Category;

import java.util.List;

/**
 * Created by DanMan on 11.10.2016.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private List<Category> mCategories;
    private OnCategoryClickCallBack mOnClickCallBack;

    public CategoriesAdapter(@NonNull List<Category> categories) {
        mCategories = categories;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_recycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mName.setText(mCategories.get(position).getLongName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickCallBack.onItemClick(mCategories.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public interface OnCategoryClickCallBack {
        void onItemClick(Category category);
    }

    public void setOnItemClick(OnCategoryClickCallBack onItemClick) {
        mOnClickCallBack = onItemClick;
    }

}
