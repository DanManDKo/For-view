package com.example.danman.mvpretrofit.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.model.Image;
import com.example.danman.mvpretrofit.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DanMan on 13.10.2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> mProducts;

    private OnProductClickCallBack mOnClickCallBack;

    public ProductsAdapter(@NonNull List<Product> products) {
        mProducts = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Product product = mProducts.get(position);
        holder.mTitle.setText(product.getTitle());
        List<Image> imageList = product.getImages();

        if (imageList != null && !imageList.isEmpty()) {
            Picasso.with(holder.itemView.getContext()).load(product.getImages().get(0).getUrlFullxFull()).into(holder.mPreview);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickCallBack.onItemClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private ImageView mPreview;

        public ViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.tv_title);
            mPreview = (ImageView) view.findViewById(R.id.iv_preview);
        }
    }

    public interface OnProductClickCallBack {
        void onItemClick(Product product);
    }

    public void setOnItemClick(OnProductClickCallBack onItemClick) {
        mOnClickCallBack = onItemClick;
    }


}
