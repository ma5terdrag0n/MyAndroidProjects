package com.example.pritish.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button one, two, three, four, five, six, seven,eight,nine, zero, equal, plus, minus, divide, c, mul;
    private TextView input, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "1";
                input.setText(s);
            }
        });

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "2";
                input.setText(s);
            }
        });

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "3";
                input.setText(s);

            }
        });

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "4";
                input.setText(s);
            }
        });

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "5";
                input.setText(s);
            }
        });

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "6";
                input.setText(s);
            }
        });

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "7";
                input.setText(s);
            }
        });

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "8";
                input.setText(s);
            }
        });

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "9";
                input.setText(s);
            }
        });

        c = (Button) findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + "0";
                input.setText(s);
            }
        });

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + " + ";
                input.setText(s);
            }
        });

        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + " - ";
                input.setText(s);
            }
        });

        mul = (Button) findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + " * ";
                input.setText(s);
            }
        });

        divide = (Button) findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                s = s + " / ";
                input.setText(s);
            }
        });

        equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(input.getText());
                String result = computeExpression(s);
                input.setText(result);
                if(s.length() > 30){
                    s = s.substring(0, 30);
                    s = s + "...";
                }
                output.setText(s);
            }
        });

    }

    String computeExpression(String s){
        String ret = "Invalid Input!";
        if(validate(s)){
            ret = compute(s);
        }
        return ret;
    }



    String compute(String s){
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '/' || s.charAt(i) == '*'){
                int foo = i - 2;
                while(foo >= 0 && s.charAt(foo) != ' ')foo--;
                int pos1 = foo+1;
                foo++;
                int num1 = 0;
                while(foo < i-1){
                    num1 = num1 * 10 + (s.charAt(foo) - '0');
                    foo++;
                }
                foo = i + 2;
                int num2 = 0;
                while(foo < s.length() && s.charAt(foo) != ' '){
                    num2 = num2 * 10 + (s.charAt(foo) - '0');
                    foo++;
                }
                int ans;
                if(s.charAt(i)== '/'){
                    if(num2 == 0)return "Division By Zero Error!";
                    ans = num1 / num2;
                }
                else {
                    ans = num1 * num2;
                }
                String f = s.substring(0, pos1);
                if(pos1 == 0)
                    f = Integer.toString(ans);
                else
                    f = f + Integer.toString(ans);
                while(foo < s.length()){
                    f += s.charAt(foo++);
                }
                return compute(f);
            }
        }
        int num1 = 0;
        int foo = 0;
        while(foo < s.length()){
            if(s.charAt(foo) == ' ')break;
            num1 = num1*10 + (s.charAt(foo++) - '0');
        }
        int num2 = 0;
        foo++;
        while(foo < s.length()){
            char opera = s.charAt(foo);
            foo+=2;
            num2 = 0;
            while(foo < s.length() && s.charAt(foo) != ' '){
                num2 = num2*10 + (s.charAt(foo++) - '0');
            }
            foo++;
            if(opera == '+'){
                num1 += num2;
            }else{
                num1 -= num2;
            }
        }
        return Integer.toString(num1);
    }

    Boolean validate(String s){
        int last = 0;
        int op = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ') {
                i++;
                if(i == s.length())return false;
                if (s.charAt(i) == '*' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '+'){
                    op++;
                    if (last == 1){
                        return false;
                    }
                    last = 1;
                }else{
                    last = 0;
                }
            }
        }
        if(op == 0)return false;
        return true;
    }
}
