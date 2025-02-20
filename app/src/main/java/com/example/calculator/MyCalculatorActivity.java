package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.calculator.util.Utility;

public class MyCalculatorActivity extends Activity {
    EditText etInput;
    EditText etOutput;
    Button btnClear;
    Button btnOpenBracket;
    Button btnCloseBracket;
    Button btnDivide;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnMultiply;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnSubtract;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnAddition;
    Button btn0;
    Button btnDecimal;
    Button btnPercentage;
    Button btnEqual;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_main);
        etInput = findViewById(R.id.input_field);
        etOutput = findViewById(R.id.output_field);
        btnClear = findViewById(R.id.buttonForClear);
        btnOpenBracket = findViewById(R.id.buttonOpenBracket);
        btnCloseBracket = findViewById(R.id.buttonCloseBracket);
        btnDivide = findViewById(R.id.buttonDivide);
        btn7 = findViewById(R.id.buttonNum7);
        btn8 = findViewById(R.id.buttonNum8);
        btn9 = findViewById(R.id.buttonNum9);
        btnMultiply = findViewById(R.id.buttonMultiply);
        btn4 = findViewById(R.id.buttonNum4);
        btn5 = findViewById(R.id.buttonNum5);
        btn6 = findViewById(R.id.buttonNum6);
        btnSubtract = findViewById(R.id.buttonSubtract);
        btn1 = findViewById(R.id.buttonNum1);
        btn2 = findViewById(R.id.buttonNum2);
        btn3 = findViewById(R.id.buttonNum3);
        btnAddition = findViewById(R.id.buttonAddition);
        btn0 = findViewById(R.id.buttonNum0);
        btnDecimal = findViewById(R.id.buttonDecimal);
        btnPercentage= findViewById(R.id.buttonPercentage);
        btnEqual = findViewById(R.id.buttonEqual);

        btn0.setOnClickListener(v -> {
           // etInput.getText(); // this is for adding text one by one
            etInput.setText(String.format("%s0", etInput.getText()));
        });

        btn1.setOnClickListener(v -> etInput.setText(String.format("%s1", etInput.getText().toString())));

        btn2.setOnClickListener(v -> {
            //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            etInput.setText(String.format("%s2", etInput.getText().toString()));
        });

        btn3.setOnClickListener(view -> etInput.setText(String.format("%s3", etInput.getText().toString())));

        btn4.setOnClickListener(v -> {
            //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            // etInput.getText();
            etInput.setText(String.format("%s4", etInput.getText().toString()));
        });

        btn5.setOnClickListener(v -> {
            //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            etInput.setText(String.format("%s5", etInput.getText().toString()));
        });

        btn6.setOnClickListener(v -> {
            //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            etInput.setText(String.format("%s6", etInput.getText().toString()));
        });

        btn7.setOnClickListener(view -> etInput.setText(String.format("%s7", etInput.getText().toString())));

        btn8.setOnClickListener(v -> {
            //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            // etInput.getText();
            etInput.setText(String.format("%s8", etInput.getText().toString()));
        });

        btn9.setOnClickListener(v -> {
              Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
            etInput.setText(String.format("%s9", etInput.getText().toString()));
        });

        btnPercentage.setOnClickListener(v -> etInput.setText(String.format("%s%%", etInput.getText())));

        btnAddition.setOnClickListener(view -> etInput.setText(String.format("%s+", etInput.getText())));

        btnSubtract.setOnClickListener(v -> etInput.setText(String.format("%s-", etInput.getText())));

        btnMultiply.setOnClickListener(v -> etInput.setText(String.format("%sX", etInput.getText())));

        btnDivide.setOnClickListener(view -> etInput.setText(String.format("%s÷", etInput.getText())));

        btnDecimal.setOnClickListener(v -> {
            String inputText = etInput.getText().toString();
            char lastCharacter = !inputText.isEmpty() ? inputText.charAt(inputText.length() - 1) : ' ';

            if (lastCharacter != 'C' &&  lastCharacter != '=' && lastCharacter != '.') {

                if (inputText.isEmpty() || lastCharacter == '+' || lastCharacter == '-' || lastCharacter == 'x'
                        || lastCharacter == '÷'){
                    etInput.setText(String.format("%s0.", inputText));

                } else {
                    etInput.setText(String.format("%s.", inputText));
                }
            }
        });

        btnOpenBracket.setOnClickListener(view -> {
            String currentText = etInput.getText().toString(); // Get the current text as a String

            if (!currentText.isEmpty()) {
                etInput.setText(String.format("%s", currentText));
            }
                etInput.setText(String.format("%s(", currentText));
        });

        btnClear.setOnClickListener(view -> {
            Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
           if(etInput.getText().length() > 0 || etOutput.getText().length() > 0){
               etInput.setText("");
               etOutput.setText("");
           }
        });

        btnDivide.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();
            char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

            if(etInput.getText().toString().isEmpty() || etInput.getText().charAt(sizeOfInputText - 1) == '(')
                etInput.setText(String.format("%s", etInput.getText()));
            else {
                if (lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-' && lastCharacter != 'x' && lastCharacter != '%' &&
                        lastCharacter != '÷' && lastCharacter != '(' && lastCharacter != 'C' && lastCharacter != '.' &&
                        lastCharacter != '=') {
                    etInput.setText(String.format("%s÷", etInput.getText()));
                } else {
                    etInput.setText(etInput.getText());
                }

                if (lastCharacter == '-' || lastCharacter == 'x' || lastCharacter == '+' || lastCharacter == '%') {
                    String text = etInput.getText().toString();
                    text = text.substring(0, text.length() - 1) + "÷";
                    etInput.setText(text);
                }
            }
        });

        btnMultiply.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();
            char lastCharacter = etInput.getText().toString().charAt(sizeOfInputText-1);

            if(etInput.getText().toString().isEmpty() || etInput.getText().charAt(sizeOfInputText - 1) == '(')
                etInput.setText(String.format("%s", etInput.getText()));
            else {
                if (lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'
                        && lastCharacter != 'x' && lastCharacter != '%' && lastCharacter != '÷'
                        && lastCharacter != '(' && lastCharacter != 'C' && lastCharacter != '=') {
                    etInput.setText(String.format("%sx", etInput.getText()));
                } else {
                    etInput.setText(etInput.getText());
                }

                if (lastCharacter == '+' || lastCharacter == '÷' || lastCharacter == '%' || lastCharacter == '-') {
                    String text = etInput.getText().toString();
                    text = text.substring(0, text.length() - 1) + "x";
                    etInput.setText(text);
                }
            }
        });

        btnAddition.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();
            char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

            if(etInput.getText().toString().isEmpty() || etInput.getText().charAt(sizeOfInputText - 1) == '(')
                etInput.setText(String.format("%s", etInput.getText()));
            else {
            if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                    lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                    lastCharacter != '='){
                etInput.setText(String.format("%s+", etInput.getText()));
            }else{
                etInput.setText(etInput.getText());
            }

                if (lastCharacter == '-' || lastCharacter == 'x' || lastCharacter == '÷' || lastCharacter == '%') {
                    String text = etInput.getText().toString();
                    text = text.substring(0, text.length() - 1) + "+";
                    etInput.setText(text);
                 }
            }
        });

        btnSubtract.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();
            char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

            if(lastCharacter != '+' && lastCharacter != '-' && lastCharacter != '%'
            && lastCharacter != '('  && lastCharacter != 'C'  &&
                    lastCharacter != '='){
                etInput.setText(String.format("%s-", etInput.getText()));
            }else{
                etInput.setText(etInput.getText());
            }

                if (lastCharacter == 'x' || lastCharacter == '÷' || lastCharacter == '%') {
                    String text = etInput.getText().toString();
                    text = text.substring(0, text.length() - 1) + "-";
                    etInput. setText(text);

            }

        });

        btnPercentage.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();
            char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

            if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                    lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                    lastCharacter != '='){
                etInput.setText(String.format("%s%%", etInput.getText()));
            }else{
                etInput.setText(etInput.getText());
            }

            if(lastCharacter == '+' || lastCharacter == 'x'
                    || lastCharacter == '÷' || lastCharacter == '%'){
                if (lastCharacter == '+' || lastCharacter == 'x' || lastCharacter == '÷') {
                    String text = etInput.getText().toString();
                    text = text.substring(0, text.length() - 1) + "%";
                    etInput. setText(text);
                }

            }

        });

        btnOpenBracket.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();

            if(etInput.getText().toString().isEmpty() || etInput.getText().charAt(sizeOfInputText - 1) == '(')
                etInput.setText(String.format("%s", etInput.getText()));
            else {
                    char lastCharacter = etInput.getText().toString().charAt(sizeOfInputText - 1);
                if(lastCharacter == '1' || lastCharacter == '2' || lastCharacter == '7' || lastCharacter == '8' || lastCharacter == '9' || lastCharacter == '0'
                        || lastCharacter == '3' || lastCharacter == '4' || lastCharacter == '5' || lastCharacter == '6'){
                    etInput.setText(String.format("%sx(", etInput.getText()));
                } else if ( lastCharacter != '(' && lastCharacter != 'C' &&
                            lastCharacter != '=') {
                        etInput.setText(String.format("%sx(", etInput.getText()));
                    }
                }
        });

        btnCloseBracket.setOnClickListener(view -> {
            int sizeOfInputText = etInput.getText().toString().length();

            if (sizeOfInputText == 0) {
                etInput.setText(String.format("%s", etInput.getText()));
            } else {
                char lastCharacter = etInput.getText().toString().charAt(sizeOfInputText - 1);
                if (lastCharacter != '+' && lastCharacter != '-' && lastCharacter != 'x' && lastCharacter != '%' &&
                        lastCharacter != '÷' && lastCharacter != '(' && lastCharacter != 'C' &&
                        lastCharacter != '=') {
                    etInput.setText(String.format("%s)", etInput.getText()));
                }
            }
        });

         btnEqual.setOnClickListener(view -> {
             String arrayOfNum = etInput.getText().toString();
             Double result = Utility.calculate(arrayOfNum);
             System.out.println(result.intValue());
             if (result % 1  == 0){
                 etOutput.setText(String.format("%d", result.intValue()));
             }else{
                 etOutput.setText(String.format("%s", result));
             }

         });

    }
}
