package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    protected TextView decimalNumberEditText;
    protected StringBuilder numberText = new StringBuilder();
    protected Button oneDigitButton, twoDigitButton, threeDigitButton, fourDigitButton, fiveDigitButton, sixDigitButton,
            sevenDigitButton, eightDigitButton, nineDigitButton, zeroDigitButton, pointButton, clearButton, backspaceButton,
            percentButton, divisionButton, multiplicationButton, subtractionButton, summationButton, equallyButton;
    protected boolean checkPointFirstNumber = false;
    protected boolean checkLastResult = false;
    protected boolean checkPointSecondNumber = false;
    protected boolean checkMathSymbol = false;
    protected char mathSymbol;
    protected int mathSymbolIndex = 0;



    private final View.OnClickListener numberClickListener;

    {
        numberClickListener = this::onClickNumber;
    }

    private final View.OnClickListener funcButtonClickListener = this::onClickFunc;
    private final View.OnClickListener mathButtonClickListener = this::onClickMath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        setOnClickListener();
    }

    private void findViewById() {
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
        zeroDigitButton = findViewById(R.id.digit_zero_button);
        pointButton = findViewById(R.id.point_button);
        clearButton = findViewById(R.id.clear_button);
        backspaceButton = findViewById(R.id.backspace_button);
        percentButton = findViewById(R.id.percent_button);
        divisionButton = findViewById(R.id.division_button);                // деление
        multiplicationButton = findViewById(R.id.multiplication_button);    // умножение
        subtractionButton = findViewById(R.id.subtraction_button);          // вычитание
        summationButton = findViewById(R.id.summation_button);              // сумма
        equallyButton = findViewById(R.id.equally_button);                  // равно
    }

    private void setOnClickListener() {
        oneDigitButton.setOnClickListener(numberClickListener);
        twoDigitButton.setOnClickListener(numberClickListener);
        threeDigitButton.setOnClickListener(numberClickListener);
        fourDigitButton.setOnClickListener(numberClickListener);
        fiveDigitButton.setOnClickListener(numberClickListener);
        sixDigitButton.setOnClickListener(numberClickListener);
        sevenDigitButton.setOnClickListener(numberClickListener);
        eightDigitButton.setOnClickListener(numberClickListener);
        nineDigitButton.setOnClickListener(numberClickListener);
        zeroDigitButton.setOnClickListener(numberClickListener);
        pointButton.setOnClickListener(numberClickListener);
        clearButton.setOnClickListener(funcButtonClickListener);
        backspaceButton.setOnClickListener(funcButtonClickListener);
        percentButton.setOnClickListener(mathButtonClickListener);
        divisionButton.setOnClickListener(mathButtonClickListener);
        multiplicationButton.setOnClickListener(mathButtonClickListener);
        subtractionButton.setOnClickListener(mathButtonClickListener);
        summationButton.setOnClickListener(mathButtonClickListener);
        equallyButton.setOnClickListener(mathButtonClickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("checkPointFirstNumber", checkPointFirstNumber);
        outState.putBoolean("checkLastResult", checkLastResult);
        outState.putBoolean("checkPointSecondNumber", checkPointSecondNumber);
        outState.putBoolean("checkMathSymbol", checkPointFirstNumber);
        outState.putInt("mathSymbolIndex", mathSymbolIndex);
        outState.putChar("mathSymbol", mathSymbol);
        outState.putString("numberText", String.valueOf(numberText));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        checkPointFirstNumber = savedInstanceState.getBoolean("checkPointFirstNumber");
        checkLastResult = savedInstanceState.getBoolean("checkLastResult");
        checkPointSecondNumber = savedInstanceState.getBoolean("checkPointSecondNumber");
        checkMathSymbol = savedInstanceState.getBoolean("checkMathSymbol");
        mathSymbolIndex = savedInstanceState.getInt("mathSymbolIndex");
        mathSymbol = savedInstanceState.getChar("mathSymbol");
        numberText.append(savedInstanceState.getString("numberText"));
    }



}