package com.example.danman.testapp.manager;

import com.example.danman.testapp.model.SomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 13.12.2016.
 */
public class ContentManager {
    private List<SomeModel> dataForFirstFragment;
    private List<SomeModel> dataForSecondFragment;

    public List<SomeModel> getDataForFirst() {
        List<SomeModel> models = new ArrayList<>();
        models.add(new SomeModel("https://static.pexels.com/photos/3247/nature-forest-industry-rails.jpg",
                "line 1", "line 2"));
        models.add(new SomeModel("https://static.pexels.com/photos/1826/wood-nature-sunny-forest.jpg",
                "line 3", "line 4"));
        return models;
    }

    public List<SomeModel> getDataForSecond() {
        List<SomeModel> models = new ArrayList<>();
        models.add(new SomeModel("https://static.pexels.com/photos/145939/pexels-photo-145939.jpeg",
                "line 1", "line 2"));
        models.add(new SomeModel("https://static.pexels.com/photos/26750/pexels-photo-26750.jpg",
                "line 3", "line 4"));
        models.add(new SomeModel("https://static.pexels.com/photos/2946/dawn-nature-sunset-trees.jpg",
                "line 5", "line 6"));

        return models;
    }
}
