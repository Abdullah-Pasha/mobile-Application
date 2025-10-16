package com.example.calculatorn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView inputText, resultText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input);
        resultText = findViewById(R.id.result);

        // Numbers
        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"0");
        });

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"1");
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"2");
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"3");
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"4");
        });

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"5");
        });

        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"6");
        });

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"7");
        });

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"8");
        });

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"9");
        });

        Button decimal = findViewById(R.id.decimal);
        decimal.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+".");
        });

        Button add = findViewById(R.id.add);
        add.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"+");
        });

        Button subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"-");
        });

        Button multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"*");
        });

        Button divide = findViewById(R.id.divide);
        divide.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"/");
        });

        Button percentage = findViewById(R.id.percentage);
        percentage.setOnClickListener(v -> {
            inputText.setText(inputText.getText()+"%");
        });

        Button clearAll = findViewById(R.id.clear_all);
        clearAll.setOnClickListener(v -> {
            inputText.setText("");
            resultText.setText("0");
        });

        Button remove = findViewById(R.id.remove);
        remove.setOnClickListener(v -> {
            String current = inputText.getText().toString();
            if (!current.isEmpty()) {
                inputText.setText(current.substring(0, current.length() - 1));
            }
        });

        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(v -> {
            String input = inputText.getText().toString();
            if (input.isEmpty()) {
                resultText.setText("0");
                return;
            }

            double result = 0;
            String currentNumber = "";
            char currentOp = 0;
            boolean firstNumber = true;
            boolean valid = false;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (Character.isDigit(ch) || ch == '.') {
                    currentNumber += ch;
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                    if (currentNumber.isEmpty()) {
                        resultText.setText("Syntax Error");
                        return;
                    }

                    if (firstNumber) {
                        result = Double.parseDouble(currentNumber);
                        firstNumber = false;
                    } else {
                        double second = Double.parseDouble(currentNumber);
                        if (currentOp == '+') result += second;
                        else if (currentOp == '-') result -= second;
                        else if (currentOp == '*') result *= second;
                        else if (currentOp == '/') result /= second;
                        else if (currentOp == '%')  {
                            double per = second / 100 * second;
                            result += per;
                        }
                    }

                    currentOp = ch;
                    currentNumber = "";
                }
            }

            if (!currentNumber.isEmpty()) {
                valid = true;
                double second = Double.parseDouble(currentNumber);
                if (currentOp == '+') result += second;
                else if (currentOp == '-') result -= second;
                else if (currentOp == '*') result *= second;
                else if (currentOp == '/') result /= second;
                else if (currentOp == '%') result %= second;
            }

            if (valid) {
                resultText.setText(String.valueOf(result));
            } else {
                resultText.setText("Syntax Error");
            }
        });
    }
}