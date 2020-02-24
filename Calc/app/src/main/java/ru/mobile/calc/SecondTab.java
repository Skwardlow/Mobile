package ru.mobile.calc;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondTab extends AppCompatActivity {
    int[] iconIds ={R.drawable.catmeme1,R.drawable.catmeme2,R.drawable.catmeme3,R.drawable.catmeme4,R.drawable.catmeme5};
    String[] cats = {"Не очень довольный кот","Деловой кот","Грустный кот1","Грустный кот2","Грустный кот3"};
    ListView lView;
    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_tab);
        lView = (ListView) findViewById(R.id.catsListT);
        lAdapter = new ListAdapter(this, cats, iconIds);
        lView.setAdapter(lAdapter);
    }

}


