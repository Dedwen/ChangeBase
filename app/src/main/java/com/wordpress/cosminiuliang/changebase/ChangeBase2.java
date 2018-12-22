package com.wordpress.cosminiuliang.changebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeBase2 extends AppCompatActivity {

    private Button button;
    private EditText numberEditText;
    private EditText baseEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_base2);


        button = (Button) findViewById(R.id.button);
        numberEditText = (EditText) findViewById(R.id.editText1);
        baseEditText = (EditText) findViewById(R.id.editText2);
        resultTextView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation1 = AnimationUtils.loadAnimation(ChangeBase2.this, R.anim.fadein);
                button.startAnimation(animation1);

                try {
                    int number = Integer.parseInt(numberEditText.getText().toString());
                    int base = Integer.parseInt(baseEditText.getText().toString());
                    if(number < base ) Toast.makeText(getApplicationContext(), "Baza nu trebuie sa fie mai mare decat numarul!", Toast.LENGTH_LONG).show();
                        else{

                        char[] res = new char[100];
                        char[] result = fromDeci(res, base, number);
                        String showResult = new String();
                        showResult = showString(result, showResult);

                        Animation animation2 = AnimationUtils.loadAnimation(ChangeBase2.this, R.anim.bounce );
                        resultTextView.startAnimation(animation2);

                        resultTextView.setText(number + "(10)= " + showResult + "(" + base + ")");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Completeaza toate spatiile!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public String showString(char[] chars, String string){

        for(int i = 0 ; i <= strlen(chars); i++)
            string += chars[i];

        return string;
    }

    public static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char) (num + '0');
        else
            return (char) (num - 10 + 'A');
    }


    public static int strlen(char[] string) {
        int i = 0, nr = 0;

        while (string[i] != '\0') {
            nr++;
            i++;
        }

        return nr;
    }


    // Utility function to reverse a string
    public static void strev(char[] str) {
        int len = strlen(str);
        int i;
        for (i = 0; i < len / 2; i++) {
            char temp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = temp;
        }
    }

    // Function to convert a given decimal number
    // to a base 'base' and
    public static char[] fromDeci(char res[], int base, int inputNum) {
        int index = 0;  // Initialize index of result

        // Convert input number is given base by repeatedly
        // dividing it by base and taking remainder
        while (inputNum > 0) {
            res[index++] = reVal(inputNum % base);
            inputNum /= base;
        }
        res[index] = '\0';

        // Reverse the result
        strev(res);

        return res;
    }
}


