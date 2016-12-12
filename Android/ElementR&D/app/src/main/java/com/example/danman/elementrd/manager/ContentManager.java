package com.example.danman.elementrd.manager;

import com.example.danman.elementrd.model.SomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 11.12.2016.
 */
public class ContentManager {
    private List<SomeModel> dataForFirstFragment;
    private List<SomeModel> dataForSecondFragment;

    public List<SomeModel> getDataForFirst() {
        List<SomeModel> models = new ArrayList<>();
        models.add(new SomeModel("https://www.google.com.ua/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwjstqXB-evQAhWEjywKHTQFBRMQjRwIBw&url=https%3A%2F%2Fpixabay.com%2Fen%2Fphotos%2Fcat%2F&psig=AFQjCNH9omwhof6biC6lgI2jCr87ISm1yg&ust=1481539136304268",
                "line 1", "line 2"));
        models.add(new SomeModel("https://www.google.com.ua/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwi3nqbB-evQAhVBpiwKHfJKDkQQjRwIBw&url=http%3A%2F%2Fwww.freedigitalphotos.net%2F&psig=AFQjCNHzrdRDCmpU90C7Nb8Mte18M6JMQQ&ust=1481539137038234",
                "some text 1", "some text 2"));
        return models;
    }

    public List<SomeModel> getDataForSecond() {
        List<SomeModel> models = new ArrayList<>();
        models.add(new SomeModel("https://www.google.com.ua/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwjkouHB-evQAhWC1SwKHXzeD4wQjRwIBw&url=http%3A%2F%2Fwww.planwallpaper.com%2Fimages&psig=AFQjCNEk7Btb2NO8WUOhZOwyNDHnJs40Mw&ust=1481539138013915",
                "some text 1", "some text 2"));
        models.add(new SomeModel("https://www.google.com.ua/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwiYtZ7C-evQAhXEWCwKHQ5dDQ0QjRwIBw&url=http%3A%2F%2Falldubai.ae%2Fdubai-photos-images%2F&psig=AFQjCNEAUtkd-FCPo98O_XnBl5F-n_j2ug&ust=1481539138639701",
                "some text 1", "some text 2"));
        models.add(new SomeModel("https://www.google.com.ua/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiF7O6q-uvQAhXKkiwKHQigBQ0QjRwIBw&url=http%3A%2F%2Fshushi168.com%2Fimage-nature.html&psig=AFQjCNFcEJqh1mddkgpZ7mlBW43QbHTp6A&ust=1481539141648672",
                "some text 1", "some text 2"));

        return models;
    }
}
