package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.calculator.util.Utility;

import java.text.BreakIterator;
import java.util.Scanner;
import java.util.logging.Logger;

// import com.google.android.filament.Vie
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_main);
        etInput = (EditText) findViewById(R.id.input_field);
        etOutput = (EditText) findViewById(R.id.output_field);
        btnClear = (Button) findViewById(R.id.buttonForClear);
        btnOpenBracket = (Button) findViewById(R.id.buttonOpenBracket);
        btnCloseBracket = (Button) findViewById(R.id.buttonCloseBracket);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btn7 = (Button) findViewById(R.id.buttonNum7);
        btn8 = (Button) findViewById(R.id.buttonNum8);
        btn9 = (Button) findViewById(R.id.buttonNum9);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btn4 = (Button) findViewById(R.id.buttonNum4);
        btn5 = (Button) findViewById(R.id.buttonNum5);
        btn6 = (Button) findViewById(R.id.buttonNum6);
        btnSubtract = (Button) findViewById(R.id.buttonSubtract);
        btn1 = (Button) findViewById(R.id.buttonNum1);
        btn2 = (Button) findViewById(R.id.buttonNum2);
        btn3 = (Button) findViewById(R.id.buttonNum3);
        btnAddition = (Button) findViewById(R.id.buttonAddition);
        btn0 = (Button) findViewById(R.id.buttonNum0);
        btnDecimal = (Button) findViewById(R.id.buttonDecimal);
        btnPercentage= (Button) findViewById(R.id.buttonPercentage);
        btnEqual = (Button) findViewById(R.id.buttonEqual);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // etInput.getText(); // this is for adding text one by one
                etInput.setText(etInput.getText()+"0" );
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                etInput.setText(etInput.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                // etInput.getText();
                etInput.setText(etInput.getText().toString()+"4" );
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                etInput.setText(etInput.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                etInput.setText(etInput.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                // etInput.getText();
                etInput.setText(etInput.getText().toString()+"8" );
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
                etInput.setText(etInput.getText().toString()+"9");
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText()+"%");
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.setText(etInput.getText()+"-" );
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               etInput.setText(etInput.getText()+"X");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "÷");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInput.getText().toString();
                char lastCharacter = inputText.length() > 0 ? inputText.charAt(inputText.length() - 1) : ' ';

                if (lastCharacter != 'C' &&  lastCharacter != '=' && lastCharacter != '.') {

                    if (inputText.length() == 0 || lastCharacter == '+' || lastCharacter == '-' || lastCharacter == 'x'
                            || lastCharacter == '÷'){
                        etInput.setText(inputText + "0.");

                    } else {
                        etInput.setText(inputText + ".");
                    }
                }
            }
        });

        btnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "(");
            }
        });

        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + ")");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyCalculatorActivity.this, "Now number is clear !", Toast.LENGTH_LONG).show();
               if(etInput.getText().length() > 0 || etOutput.getText().length() > 0){
                   etInput.setText("");
                   etOutput.setText("");
               }
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText(etInput.getText() + "x");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                        lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&  lastCharacter != '.' &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + "÷");
                }else{
                    etInput.setText(etInput.getText());
                }

                    if (lastCharacter == '-' || lastCharacter == 'x' || lastCharacter == '+' || lastCharacter == '%') {
                        String text = etInput.getText().toString();
                        text = text.substring(0, text.length() - 1) + "÷";
                        etInput. setText(text);
                    }

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter = etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'
                        && lastCharacter != 'x'  && lastCharacter != '%'  && lastCharacter != '÷'
                        && lastCharacter != '('  && lastCharacter != 'C'  && lastCharacter != '='){
                    etInput.setText(etInput.getText() + "x");
                }else{
                    etInput.setText(etInput.getText());
                }

                    if ( lastCharacter == '+' || lastCharacter == '÷' || lastCharacter == '%'  || lastCharacter == '-') {
                        String text = etInput.getText().toString();
                        text = text.substring(0, text.length() - 1) + "x";
                        etInput. setText(text);
                    }

            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                        lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + "+");
                }else{
                    etInput.setText(etInput.getText());
                }

                if(lastCharacter == '-' || lastCharacter == 'x'
                        || lastCharacter == '÷' || lastCharacter == '%') {
                    if (lastCharacter == '-' || lastCharacter == 'x' || lastCharacter == '÷' || lastCharacter == '%') {
                        String text = etInput.getText().toString();
                        text = text.substring(0, text.length() - 1) + "+";
                        etInput.setText(text);
                    }
                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != '+' && lastCharacter != '-' && lastCharacter != '%'
                && lastCharacter != '('  && lastCharacter != 'C'  &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + "-");
                }else{
                    etInput.setText(etInput.getText());
                }

                if(lastCharacter == '+' || lastCharacter == 'x'
                        || lastCharacter == '÷' || lastCharacter == '%'){
                    if (lastCharacter == '+' || lastCharacter == 'x' || lastCharacter == '÷' || lastCharacter == '%') {
                        String text = etInput.getText().toString();
                        text = text.substring(0, text.length() - 1) + "-";
                        etInput. setText(text);
                    }

                }

            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                        lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + "%");
                }else{
                    etInput.setText(etInput.getText());
                }

                if(lastCharacter == '+' || lastCharacter == 'x'
                        || lastCharacter == '÷' || lastCharacter == '%'){
                    if (lastCharacter == '+' || lastCharacter == 'x' || lastCharacter == '÷' || lastCharacter == '-') {
                        String text = etInput.getText().toString();
                        text = text.substring(0, text.length() - 1) + "%";
                        etInput. setText(text);
                    }

                }

            }
        });

        btnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                        lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + "(");
                }else{
                    etInput.setText(etInput.getText());
                }

            }
        });

        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfInputText = etInput.getText().toString().length();
                char lastCharacter =etInput.getText().toString().charAt(sizeOfInputText-1);

                if(lastCharacter != ' ' && lastCharacter != '+' && lastCharacter != '-'  && lastCharacter != 'x'  && lastCharacter != '%'  &&
                        lastCharacter != '÷'  && lastCharacter != '('  && lastCharacter != 'C'  &&
                        lastCharacter != '='){
                    etInput.setText(etInput.getText() + ")");
                }else{
                    etInput.setText(etInput.getText());
                }

            }
        });

         btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String arrayOfNum = etInput.getText().toString();
                Double result = Double.valueOf(Utility.calculate(arrayOfNum));
                System.out.println(result.intValue());
                if (result % 1  == 0){
                    etOutput.setText("" + result.intValue());
                }else{
                    etOutput.setText("" + result);
                }



            }
        });

    }
}
