package com.example.danman.mvpretrofit.contract;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.presenter.BaseMvpPresenter;
import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoritsContract {
    public  interface presentor extends BaseMvpPresenter<View>{
        void loadFavorites(String categoryName, int page);
    }
    public interface View {
        void onFavoritesLoaded(List<Product> products);
        void onError(String message);
    }
}
