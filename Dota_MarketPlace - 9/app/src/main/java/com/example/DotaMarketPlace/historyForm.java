package com.example.DotaMarketPlace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class historyForm  extends  AppCompatActivity  {

/*    ArrayList<Item> arrItem;
    RecyclerView rvItems;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    void initData(){

        arrItem = new ArrayList<>();

        arrItem.add(new Item("Chitin Shoulder Guard" , 54 ,35022, 100000 ));
        arrItem.add(new Item("Chestplate of the Hierophant" , 43 ,50000, 100000 ));
        arrItem.add(new Item("Foliage of Eldritch Gnarl" , 108 ,234351, 100000 ));
        arrItem.add(new Item("Mantle of the Blood " , 120 ,74232, 100000 ));
        arrItem.add(new Item("Tahlin Occult Dagger" , 200 ,84322, 100000 ));

    }

    void init(){
        rvItems = findViewById(R.id.rv_items);
        mAdapter = new MyAdapter(arrItem, this);
        layoutManager = new LinearLayoutManager(this);

        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(mAdapter);
    } */



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }

}
