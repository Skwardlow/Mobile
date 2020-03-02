package ru.mobile.calc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button labCal;
    Button labKom;
    Button labTab;
    Button labDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        labCal = (Button) findViewById(R.id.buttonCalc);
        labCal.setOnClickListener(this);
        labKom = (Button) findViewById(R.id.buttonCompass);
        labKom.setOnClickListener(this);
        labTab = (Button) findViewById(R.id.buttonTabs);
        labTab.setOnClickListener(this);
        labDB = (Button) findViewById(R.id.buttonSQL);
        labDB.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCalc:
                Intent intent = new Intent(this, Calc.class);
                startActivity(intent);
                break;
            case R.id.buttonCompass:
                Intent intent1 = new Intent(this, Compass.class);
                startActivity(intent1);
                break;
            case R.id.buttonTabs:
                Intent intent2 = new Intent(this, Tabs.class);
                startActivity(intent2);
                break;
            case R.id.buttonSQL:
                Intent intent3 = new Intent(this, DB.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
