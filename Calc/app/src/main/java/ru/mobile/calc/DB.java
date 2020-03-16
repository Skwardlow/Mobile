package ru.mobile.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class DB extends AppCompatActivity {
    TableLayout tableLayout;
    EditText editText;

    SQLController sqlController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        //editText = findViewById(R.id.fistname_et_id);
        tableLayout = findViewById(R.id.tableLayout1);

        sqlController = new SQLController(this);
        sqlController.open();
        sqlController.clearTable();
        createAll();
        BuildTable();
    }

    private void BuildTable() {

        sqlController.open();
        Cursor c = sqlController.readEntryOrderby();

        int rows = c.getCount();
        int cols = c.getColumnCount();

        c.moveToFirst();

        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            row.setBackgroundResource(R.drawable.ic_launcher_foreground);

            for (int j = 0; j < cols; j++) {

                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
                //tv.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
                //tv.setBackgroundResource(R.drawable.);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                System.out.println(c.getString(j));

                row.addView(tv);
            }

            c.moveToNext();

            tableLayout.addView(row);

        }
        sqlController.close();
    }


    private void createAll(){
        String[] fnames = {"Bariczhan","Kazylbek","Mariczhan","Azerbaiczhan","Nazyrbay","Fatimbek","AbdulHamash","Fatichze"};
        String[] lnames = {"Hamayamov","Natichanov","Azerbaychzanov","Katamaranov","Suleymanov","Putanov","Afuralov","Durimanov"};
        Integer height, weight, age;
        for (int i = 0; i<10; i++){
            height = 130+ (int) (Math.random() * 70);
            weight = 40+(int) (Math.random() * 70);
            age =18+ (int) (Math.random() * 82);
            sqlController.insertData(fnames[(int) (Math.random()*8)],lnames[(int) (Math.random()*8)],height.toString(),weight.toString(),age.toString());
        }
    }
}
