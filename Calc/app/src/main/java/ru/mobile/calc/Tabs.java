package ru.mobile.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Tabs extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("О себе");
        tabSpec.setContent(new Intent(this, FirstTab.class));
        tabSpec.setIndicator("О себе");
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("Ровы");
        tabSpec.setIndicator("Ровы");
        tabSpec.setContent(new Intent(this, SecondTab.class));
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("Колумны");
        tabSpec.setIndicator("Колумны");
        tabSpec.setContent(new Intent(this, ThirdTab.class));
        tabHost.addTab(tabSpec);
    }
}
