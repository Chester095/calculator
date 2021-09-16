package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@@@";
    private TextView decimalNumberEditText;
    private String number = "";
    private Button oneDigitButton, twoDigitButton, threeDigitButton, fourDigitButton, fiveDigitButton, sixDigitButton,
            sevenDigitButton, eightDigitButton, nineDigitButton, pointButton;
    private boolean checkPoint=true;


    private View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickNumber(view);
//            Log.d(TAG, "onClick() - " + numberClickListener);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalNumberEditText = findViewById(R.id.decimal_number_edit_text);

        oneDigitButton = findViewById(R.id.digit_one_button);
        twoDigitButton = findViewById(R.id.digit_two_button);
        threeDigitButton = findViewById(R.id.digit_three_button);
        fourDigitButton = findViewById(R.id.digit_four_button);
        fiveDigitButton = findViewById(R.id.digit_five_button);
        sixDigitButton = findViewById(R.id.digit_six_button);
        sevenDigitButton = findViewById(R.id.digit_seven_button);
        eightDigitButton = findViewById(R.id.digit_eight_button);
        nineDigitButton = findViewById(R.id.digit_nine_button);
        pointButton = findViewById(R.id.point_button);

        oneDigitButton.setOnClickListener(numberClickListener);
        twoDigitButton.setOnClickListener(numberClickListener);
        threeDigitButton.setOnClickListener(numberClickListener);
        fourDigitButton.setOnClickListener(numberClickListener);
        fiveDigitButton.setOnClickListener(numberClickListener);
        sixDigitButton.setOnClickListener(numberClickListener);
        sevenDigitButton.setOnClickListener(numberClickListener);
        eightDigitButton.setOnClickListener(numberClickListener);
        nineDigitButton.setOnClickListener(numberClickListener);
        pointButton.setOnClickListener(numberClickListener);


    }

    public void onClickNumber(View view){
//        Log.d(TAG, "onClick() - " + view);

        if (view == oneDigitButton) number+="1";
        if (view == twoDigitButton) number+="2";
        if (view == threeDigitButton) number+="3";
        if (view == fourDigitButton) number+="4";
        if (view == fiveDigitButton) number+="5";
        if (view == sixDigitButton) number+="6";
        if (view == sevenDigitButton) number+="7";
        if (view == eightDigitButton) number+="8";
        if (view == nineDigitButton) number+="9";
        if (view == pointButton && checkPoint) {checkPoint=false; number+=".";}
        decimalNumberEditText.setText(number);
    }

}