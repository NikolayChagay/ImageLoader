package com.example.testgridlayout.deleteMe;

import com.example.testgridlayout.domain.model.GiphyImages;

import java.util.ArrayList;
import java.util.List;

public class MockTestData {
    private List<GiphyImages> lstSmall;
    private List<GiphyImages> lstBig;
    private ArrayList<GiphyImages> lstAll;
    private String url = "https://media3.giphy.com/media/RqbkeCZGgipSo/giphy.gif?rid=giphy.gif";
    private String url2 = "https://www.tokkoro.com/picsup/400212-animal-images-background.jpg";
    // private String url3 = "https://www.91-cdn.com/pricebaba-images/images/product/television/46350/tcl-l55p2us-55-inch-4k-ultra-hd-smart-led-raw-288802.jpg";
    private String url3 = "https://cache.kwork.ru/pics/t4/12/1452098-1558299012.jpg";
    private String txt = "Какой то текст";

    public MockTestData() {
        lstSmall = new ArrayList<>();
        lstBig = new ArrayList<>();
        lstAll = new ArrayList<>();
    }

    public List<GiphyImages> getSmallList() {
        lstSmall.clear();
        for (int i = 0; i < 10; i++) {
            GiphyImages item = new GiphyImages(url3, txt, null, "", "100", "100", 0);
            lstSmall.add(item);
        }

        return lstSmall;
    }

    public List<GiphyImages> getBigList() {
        lstBig.clear();
        for (int i = 0; i < 10; i++) {
            GiphyImages item = new GiphyImages(url3, txt, null, "user", "100", "100", 1);
            lstBig.add(item);
        }

        return lstBig;
    }

    public List<GiphyImages> getAll() {
        lstAll.clear();
        lstAll.addAll(getSmallList());
        lstAll.addAll(getBigList());

        return lstAll;
    }
}
