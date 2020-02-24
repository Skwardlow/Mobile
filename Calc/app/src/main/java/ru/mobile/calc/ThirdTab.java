package ru.mobile.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ThirdTab extends AppCompatActivity {
    String[] cat = new String[]{"Не очень довольный кот","Деловой кот","Грустный кот1","Грустный кот2","Грустный кот3"};
    int[] png = new int[]{R.drawable.catmeme1,R.drawable.catmeme2,R.drawable.catmeme3,R.drawable.catmeme4,R.drawable.catmeme5};


    private TextView makerow(String s) {
        TextView txt = new TextView(this);
        txt.setText(s);
        txt.setTypeface(Typeface.SERIF, Typeface.BOLD);
        txt.setGravity(17);
        return txt;
    }
    private ImageView makepng(int res) {
        ImageView png = new ImageView(this);
        png.setImageResource(res);
        return png;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TableLayout table = new TableLayout(this);
        TableRow[] rows = new TableRow[5];
        table.setShrinkAllColumns(true);
        table.setStretchAllColumns(true);
        rows[0] = new TableRow(this);
        rows[0].setGravity(17);
        rows[0].addView(makerow("Описание кота"));
        TableRow.LayoutParams p = new TableRow.LayoutParams();
        p.span = 2;
        rows[0].addView(makerow("Фотография кота"), p);
        table.addView(rows[0]);
        for (int i = 0; i < 5; i++) {
            rows[i] = new TableRow(this);
            rows[i].setGravity(17);
            rows[i].addView(makerow(this.cat[i]));
            ImageView image = makepng(png[i]);
            image.setMaxWidth(1);
            image.setMaxHeight(1);
            rows[i].addView(image);
            table.addView(rows[i]);
        }
        setContentView(table);
    }
}
