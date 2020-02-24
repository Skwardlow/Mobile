package ru.mobile.calc;


import android.app.ListActivity;
import android.os.Bundle;


public class SecondTab extends ListActivity {
    int[] iconIds ={R.drawable.catmeme1,R.drawable.catmeme2,R.drawable.catmeme3,R.drawable.catmeme4,R.drawable.catmeme5};
    String[] cats = {"Не очень довольный кот","Деловой кот","Грустный кот1","Грустный кот2","Грустный кот3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_tab);
    }

}


