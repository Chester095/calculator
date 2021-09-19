package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView decimalNumberEditText;
    private StringBuilder numberText = new StringBuilder();
    private Button oneDigitButton, twoDigitButton, threeDigitButton, fourDigitButton, fiveDigitButton, sixDigitButton,
            sevenDigitButton, eightDigitButton, nineDigitButton, zeroDigitButton, pointButton, clearButton, backspaceButton,
            percentButton, divisionButton, multiplicationButton, subtractionButton, summationButton, equallyButton;
    private boolean checkPointFirstNumber = false;
    private boolean checkLastResult = false;
    private boolean checkPointSecondNumber = false;
    private boolean checkMathSymbol = false;
    private char mathSymbol;
    private int mathSymbolIndex = 0;


    private final View.OnClickListener numberClickListener = this::onClickNumber;
    private final View.OnClickListener funcButtonClickListener = this::onClickFunc;
    private final View.OnClickListener mathButtonClickListener = this::onClickMath;

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

    public void onClickNumber(View view) {
        if (checkLastResult) {
            clearTempVariable();
            numberText.delete(0, numberText.length());
            decimalNumberEditText.setText(numberText);
        }
        if (view == oneDigitButton)
            numberText.append(1);
        if (view == twoDigitButton)
            numberText.append(2);
        if (view == threeDigitButton)
            numberText.append(3);
        if (view == fourDigitButton)
            numberText.append(4);
        if (view == fiveDigitButton)
            numberText.append(5);
        if (view == sixDigitButton)
            numberText.append(6);
        if (view == sevenDigitButton)
            numberText.append(7);
        if (view == eightDigitButton)
            numberText.append(8);
        if (view == nineDigitButton)
            numberText.append(9);
        if (view == zeroDigitButton)
            numberText.append(0);
        if (view == pointButton) {
            if (!checkPointFirstNumber && !checkMathSymbol) {
                checkPointFirstNumber = true;
                numberText.append(".");
            } else if (!checkPointSecondNumber && checkMathSymbol) {
                checkPointSecondNumber = true;
                numberText.append(".");
            }
        }
        decimalNumberEditText.setText(numberText);
    }

    public void onClickFunc(View view) {
        if (view == clearButton) {
            numberText.delete(0, numberText.length());
            clearTempVariable();
        }

        if (view == backspaceButton && numberText.length() > 0) {
            if (mathSymbolIndex + 1 == numberText.length()) {
                checkMathSymbol = false;
                mathSymbol = 0;
            }
            if (numberText.charAt(numberText.length() - 1) == '.') {
                if (checkPointSecondNumber) {
                    checkPointSecondNumber = false;
                } else if (checkPointFirstNumber) {
                    checkPointFirstNumber = false;
                }
            }
            numberText.deleteCharAt(numberText.length() - 1);
            checkLastResult = false;
        }
        decimalNumberEditText.setText(numberText);
    }

    public void onClickMath(View view) {
        if (view == summationButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = '+';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = '+';
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = '+';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        }
        if (view == divisionButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = '/';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = '/';
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = '/';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        }
        if (view == multiplicationButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = '*';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = '*';
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = '*';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        }
        if (view == subtractionButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = '-';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = '-';
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = '-';
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        }

        if (view == percentButton) {
            if (checkMathSymbol && mathSymbolIndex + 1 != numberText.length()) {
                double firstNumber = Double.parseDouble(numberText.substring(0, mathSymbolIndex));
                double secondNumber = Double.parseDouble(numberText.substring(mathSymbolIndex + 1, numberText.length()));
                double tempSecondNumber = firstNumber / 100 * secondNumber;
                numberText.delete(mathSymbolIndex + 1, numberText.length());
                numberText.append(tempSecondNumber);
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkLastResult = true;
            }
        }

        if (view == equallyButton && checkMathSymbol) {
            numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
            checkLastResult = true;
        }


        decimalNumberEditText.setText(numberText);
    }

    private StringBuilder mathCalculation(StringBuilder numberText, char mathSymbol, int mathSymbolIndex) {
        StringBuilder result = new StringBuilder();
        double secondNumber;
        double firstNumber = Double.parseDouble(numberText.substring(0, mathSymbolIndex));
        if (mathSymbolIndex + 1 == numberText.length()) {
            secondNumber = firstNumber;
        } else {
            secondNumber = Double.parseDouble(numberText.substring(mathSymbolIndex + 1, numberText.length()));
        }
        if (mathSymbol == '+') {
            result.append(firstNumber + secondNumber);
        } else if (mathSymbol == '-') {
            result.append(firstNumber - secondNumber);
        } else if (mathSymbol == '*') {
            result.append(firstNumber * secondNumber);
        } else if (mathSymbol == '/') {
            result.append(firstNumber / secondNumber);
        }
        if (result.substring(result.length() - 2, result.length()).equals(".0")) {
            result.delete(result.length() - 2, result.length());
            checkPointFirstNumber = false;
        }

        clearTempVariable();
        return result;
    }

    private void clearTempVariable() {
        mathSymbol = 0;
        checkLastResult = false;
        checkMathSymbol = false;
        checkPointSecondNumber = false;
    }

}