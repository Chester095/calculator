package com.example.calculator;

import static com.example.calculator.MainActivity.backspaceButton;
import static com.example.calculator.MainActivity.checkLastResult;
import static com.example.calculator.MainActivity.checkMathSymbol;
import static com.example.calculator.MainActivity.checkPointFirstNumber;
import static com.example.calculator.MainActivity.checkPointSecondNumber;
import static com.example.calculator.MainActivity.clearButton;
import static com.example.calculator.MainActivity.decimalNumberEditText;
import static com.example.calculator.MainActivity.divisionButton;
import static com.example.calculator.MainActivity.eightDigitButton;
import static com.example.calculator.MainActivity.equallyButton;
import static com.example.calculator.MainActivity.fiveDigitButton;
import static com.example.calculator.MainActivity.fourDigitButton;
import static com.example.calculator.MainActivity.mathSymbol;
import static com.example.calculator.MainActivity.mathSymbolIndex;
import static com.example.calculator.MainActivity.multiplicationButton;
import static com.example.calculator.MainActivity.nineDigitButton;
import static com.example.calculator.MainActivity.numberText;
import static com.example.calculator.MainActivity.oneDigitButton;
import static com.example.calculator.MainActivity.percentButton;
import static com.example.calculator.MainActivity.pointButton;
import static com.example.calculator.MainActivity.sevenDigitButton;
import static com.example.calculator.MainActivity.sixDigitButton;
import static com.example.calculator.MainActivity.subtractionButton;
import static com.example.calculator.MainActivity.summationButton;
import static com.example.calculator.MainActivity.threeDigitButton;
import static com.example.calculator.MainActivity.twoDigitButton;
import static com.example.calculator.MainActivity.zeroDigitButton;

import android.view.View;

public class Calculate {
    private static char multiplication = 'x', division = '/', subtraction = '-', summation = '+', equally = '=', point = '.';

    public static void onClickNumber(View view) {
        if (MainActivity.checkLastResult) {
            clearTempVariable();
            numberText.delete(0, numberText.length());
            decimalNumberEditText.setText(numberText);
        }
        if (view == oneDigitButton)
            numberText.append(1);
        else if (view == twoDigitButton)
            numberText.append(2);
        else if (view == threeDigitButton)
            numberText.append(3);
        else if (view == fourDigitButton)
            numberText.append(4);
        else if (view == fiveDigitButton)
            numberText.append(5);
        else if (view == sixDigitButton)
            numberText.append(6);
        else if (view == sevenDigitButton)
            numberText.append(7);
        else if (view == eightDigitButton)
            numberText.append(8);
        else if (view == nineDigitButton)
            numberText.append(9);
        else if (view == zeroDigitButton)
            numberText.append(0);
        else if (view == pointButton) {
            if (!checkPointFirstNumber && !checkMathSymbol) {
                checkPointFirstNumber = true;
                numberText.append(point);
            } else if (!checkPointSecondNumber && checkMathSymbol) {
                checkPointSecondNumber = true;
                numberText.append(point);
            }
        }
        decimalNumberEditText.setText(numberText);
    }

    public static void onClickFunc(View view) {
        if (view == clearButton) {
            numberText.delete(0, numberText.length());
            clearTempVariable();
        } else if (view == backspaceButton && numberText.length() > 0) {
            if (mathSymbolIndex + 1 == numberText.length()) {
                checkMathSymbol = false;
                mathSymbol = 0;
            }
            if (numberText.charAt(numberText.length() - 1) == point) {
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

    public static void onClickMath(View view) {
        if (view == summationButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = summation;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = summation;
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = summation;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        } else if (view == divisionButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = division;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = division;
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = division;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        } else if (view == multiplicationButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = multiplication;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = multiplication;
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = multiplication;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        } else if (view == subtractionButton) {
            if (!checkMathSymbol) {
                checkMathSymbol = true;
                mathSymbol = subtraction;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            } else if (mathSymbolIndex + 1 == numberText.length()) {
                mathSymbol = subtraction;
                numberText.setCharAt(mathSymbolIndex, mathSymbol);
            } else {
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkMathSymbol = true;
                mathSymbol = subtraction;
                mathSymbolIndex = numberText.length();
                numberText.append(mathSymbol);
            }
            checkLastResult = false;
        } else if (view == percentButton) {
            if (checkMathSymbol && mathSymbolIndex + 1 != numberText.length()) {
                double firstNumber = Double.parseDouble(numberText.substring(0, mathSymbolIndex));
                double secondNumber = Double.parseDouble(numberText.substring(mathSymbolIndex + 1, numberText.length()));
                double tempSecondNumber = firstNumber / 100 * secondNumber;
                numberText.delete(mathSymbolIndex + 1, numberText.length());
                numberText.append(tempSecondNumber);
                numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
                checkLastResult = true;
            }
        } else if (view == equallyButton && checkMathSymbol) {
            numberText = mathCalculation(numberText, mathSymbol, mathSymbolIndex);
            checkLastResult = true;
        }


        decimalNumberEditText.setText(numberText);
    }

    private static StringBuilder mathCalculation(StringBuilder numberText, char mathSymbol, int mathSymbolIndex) {
        StringBuilder result = new StringBuilder();
        double firstNumber = 0, secondNumber = 0;
        if (numberText.length() > 1) {
            if (mathSymbolIndex != 0) {
                firstNumber = Double.parseDouble(numberText.substring(0, mathSymbolIndex));
            } else {
                firstNumber = Double.parseDouble(numberText.substring(mathSymbolIndex + 1, numberText.length()));
            }
            if (mathSymbolIndex + 1 != numberText.length()) {
                secondNumber = Double.parseDouble(numberText.substring(mathSymbolIndex + 1, numberText.length()));
            } else {
                secondNumber = firstNumber;
            }
        }

        if (mathSymbol == summation) {
            result.append(firstNumber + secondNumber);
        } else if (mathSymbol == subtraction) {
            result.append(firstNumber - secondNumber);
        } else if (mathSymbol == multiplication) {
            result.append(firstNumber * secondNumber);
        } else if (mathSymbol == division) {
            result.append(firstNumber / secondNumber);
        }
        if (result.substring(result.length() - 2, result.length()).equals(".0")) {
            result.delete(result.length() - 2, result.length());
            checkPointFirstNumber = false;
        }

        clearTempVariable();
        return result;
    }

    private static void clearTempVariable() {
        mathSymbol = 0;
        checkLastResult = false;
        checkMathSymbol = false;
        checkPointSecondNumber = false;
    }
}
