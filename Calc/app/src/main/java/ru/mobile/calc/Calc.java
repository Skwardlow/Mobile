package ru.mobile.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static ru.mobile.calc.Ideone.calc;

public class Calc extends AppCompatActivity implements View.OnClickListener {
    private TextView field;
    private Button btnZero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field = findViewById(R.id.editText);
        int [] ids = {
                R.id.buttonZero,
                R.id.buttonOne,
                R.id.buttonTwo,
                R.id.buttonThree,
                R.id.buttonFour,
                R.id.buttonFive,
                R.id.buttonSix,
                R.id.buttonSeven,
                R.id.buttonEight,
                R.id.buttonNine,
                R.id.buttonPlus,
                R.id.buttonMinus,
                R.id.buttonMultiply,
                R.id.buttonDivision,
                R.id.buttonDot,
                R.id.buttonEquals,
                R.id.buttonClear
        };
        for (int i:ids){
            ((Button)findViewById(i)).setOnClickListener(this);
        }
//        btnZero = findViewById(R.id.buttonZero);
//        btnZero.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonZero:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "0";
                field.setText(tmp);
                break;
            }
            case R.id.buttonOne:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "1";
                field.setText(tmp);
                break;
            }
            case R.id.buttonTwo:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "2";
                field.setText(tmp);
                break;
            }
            case R.id.buttonThree:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "3";
                field.setText(tmp);
                break;
            }
            case R.id.buttonFour:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "4";
                field.setText(tmp);
                break;
            }
            case R.id.buttonFive:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "5";
                field.setText(tmp);
                break;
            }
            case R.id.buttonSix:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "6";
                field.setText(tmp);
                break;
            }
            case R.id.buttonSeven:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "7";
                field.setText(tmp);
                break;
            }
            case R.id.buttonEight:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "8";
                field.setText(tmp);
                break;
            }
            case R.id.buttonNine:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                tmp = tmp + "9";
                field.setText(tmp);
                break;
            }
            case R.id.buttonDivision:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                String lastSym = charSequence.toString();
                if (charSequence.length() == 0) {
                    break;
                }

                if(!lastSym.matches(".*[\\+\\-\\×\\.\\÷\\.]$")){
                    tmp = tmp + "÷";
                }
                field.setText(tmp);
                break;
            }
            case R.id.buttonMultiply:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                String lastSym = charSequence.toString();
                if (charSequence.length() == 0) {
                    break;
                }

                if(!lastSym.matches(".*[\\+\\-\\×\\.\\÷\\.]$")){
                    tmp = tmp + "×";
                }
                field.setText(tmp);
                break;
            }
            case R.id.buttonPlus:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                String lastSym = charSequence.toString();
                if (charSequence.length() == 0) {
                    break;
                }

                if(!lastSym.matches(".*[\\+\\-\\×\\.\\÷\\.]$")){
                    tmp = tmp + "+";
                }
                field.setText(tmp);
                break;
            }
            case R.id.buttonMinus:{
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                String lastSym = charSequence.toString();
                if (charSequence.length() == 0) {
                    break;
                }

                if(!lastSym.matches(".*[\\+\\-\\×\\.\\÷\\.]$")){
                    tmp = tmp + "-";
                }
                field.setText(tmp);
                break;
            }
            case R.id.buttonDot: {
                CharSequence charSequence = field.getText();
                String tmp = charSequence.toString();
                String lastSym = charSequence.toString();
                if (charSequence.length() == 0) {
                    break;
                }

                if (!lastSym.matches(".*[\\+\\-\\×\\.\\÷\\.]$")) {
                    tmp = tmp + ".";
                }
                field.setText(tmp);
                break;
            }
            case R.id.buttonClear: {
                field.setText("");
                break;
            }

            case R.id.buttonEquals: {
                    CharSequence charSequence = field.getText();
                    String s = charSequence.toString().replace("÷","/").replace("×","*");
                    List<String> expression = Polska.parse(s);
                    boolean flag = Polska.flag;

                    if (flag) {
                        double answer = calc(expression);
                        String a = String.valueOf(answer);
                        field.setText(a);
                    }
                break;
            }


            default:{
                break;
                }
        }
    }


}
