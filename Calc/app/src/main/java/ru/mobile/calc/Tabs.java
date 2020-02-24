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
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Android");
        tabSpec.setContent(new Intent(this, FirstTab.class));
        tabSpec.setIndicator("Android");
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("Lunux's");
        tabSpec.setIndicator("Linux systems");
        tabSpec.setContent(new Intent(this, SecondTab.class));
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("Chrome");
        tabSpec.setIndicator("Weather");
        tabSpec.setContent(new Intent(this, ThirdTab.class));
        tabHost.addTab(tabSpec);
    }
}
