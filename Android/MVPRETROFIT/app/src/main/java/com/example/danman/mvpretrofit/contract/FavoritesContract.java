package com.example.danman.mvpretrofit.contract;

import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.presenter.BaseMvpPresenter;

import java.util.List;

/**
 * Created by DanMan on 09.11.2016.
 */
public class FavoritesContract {
    public  interface presenter extends BaseMvpPresenter<View> {
        void loadProducts();
    }
    public interface View {
        void onProductsLoaded(List<Product> products);
        void onError(String message);
    }
}
