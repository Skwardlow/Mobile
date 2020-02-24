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
                R.id.buttonClear,
                R.id.buttonRightBracket,
                R.id.buttonLeftBracket,
                R.id.buttonRemove

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
                String fieldText = field.getText().toString();
                fieldText+="0";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonOne:{
                String fieldText = field.getText().toString();
                fieldText+="1";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonTwo:{
                String fieldText = field.getText().toString();
                fieldText+="2";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonThree:{
                String fieldText = field.getText().toString();
                fieldText+="3";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonFour:{
                String fieldText = field.getText().toString();
                fieldText+="4";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonFive:{
                String fieldText = field.getText().toString();
                fieldText+="5";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonSix:{
                String fieldText = field.getText().toString();
                fieldText+="6";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonRightBracket:{
                String fieldText = field.getText().toString();

                if(!fieldText.matches(".*[\\.\\)]$") && fieldText.matches(".*[\\+\\-\\×\\÷]$")){
                    fieldText+="(";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonSeven:{
                String fieldText = field.getText().toString();
                fieldText+="7";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonEight:{
                String fieldText = field.getText().toString();
                fieldText+="8";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonNine:{
                String fieldText = field.getText().toString();
                fieldText+="9";
                field.setText(fieldText);
                break;
            }
            case R.id.buttonLeftBracket:{
                String fieldText = field.getText().toString();

                if (fieldText.length() == 0) {
                    break;
                }
                if(!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")){
                    fieldText+=")";
                }
                field.setText(fieldText);
                break;
            }

            case R.id.buttonDivision:{
                String fieldText = field.getText().toString();
                if (fieldText.length() == 0) {
                    break;
                }
                if(!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")){
                    fieldText+="÷";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonMultiply:{
                String fieldText = field.getText().toString();
                if (fieldText.length() == 0) {
                    break;
                }
                if(!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")){
                    fieldText+="×";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonPlus:{
                String fieldText = field.getText().toString();

                if (fieldText.length() == 0) {
                    break;
                }
                if(!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")){
                    fieldText+="+";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonMinus:{
                String fieldText = field.getText().toString();

                if (fieldText.length() == 0) {
                    break;
                }
                if(!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")){
                    fieldText+="-";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonDot: {
                String fieldText = field.getText().toString();
                if (fieldText.length() == 0) {
                    break;
                }
                if (!fieldText.matches(".*[\\+\\-\\×\\.\\÷\\.\\(]$")) {
                    fieldText+=".";
                }
                field.setText(fieldText);
                break;
            }
            case R.id.buttonClear: {
                field.setText("");
                break;
            }
            case R.id.buttonEquals: {
                    String fieldText = field.getText().toString();
                    String s = fieldText.replace("÷","/").replace("×","*");
                    List<String> expression = Polska.parse(s);
                    boolean flag = Polska.flag;

                    if (flag) {
                        double answer = calc(expression);
                        String a = String.valueOf(answer);
                        field.setText(a);
                    }
                break;
            }
            case R.id.buttonRemove:{
                String fieldText = field.getText().toString();

                if (fieldText.length() == 0) {
                    break;
                }
                fieldText = fieldText.substring(0,fieldText.length()-1);
                field.setText(fieldText);
                break;
            }



            default:{
                break;
                }
        }
    }


}
