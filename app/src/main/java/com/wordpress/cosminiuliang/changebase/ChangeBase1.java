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


public class ChangeBase1 extends AppCompatActivity {

    private Button button;
    private EditText numberEditText;
    private EditText baseEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_base1);

        button = (Button) findViewById(R.id.button);
        numberEditText = (EditText) findViewById(R.id.editText1);
        baseEditText = (EditText) findViewById(R.id.editText2);
        resultTextView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation1 = AnimationUtils.loadAnimation(ChangeBase1.this, R.anim.fadein);
                button.startAnimation(animation1);

                try {
                    String number = (numberEditText.getText().toString());
                    int base = Integer.parseInt(baseEditText.getText().toString());
                    int result = toDecimal(number, base);

                    if(result < 0) Toast.makeText(getApplicationContext(), "Numarul introdus este invalid!", Toast.LENGTH_LONG).show();
                    else {
                        Animation animation2 = AnimationUtils.loadAnimation(ChangeBase1.this, R.anim.bounce );
                        resultTextView.startAnimation(animation2);

                        resultTextView.setText(number + "(" + base + ")= " + result + "(10)");
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Completeaza toate spatiile!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // To return value of a char.
    // For example, 2 is returned
    // for '2'. 10 is returned
    // for 'A', 11 for 'B'
    public int val(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }


    // Function to convert a
    // number from given base
    // 'b' to decimal
    public int toDecimal(String str,
                         int base) {
        int len = str.length();
        int power = 1; // Initialize
        // power of base
        int num = 0; // Initialize result
        int i;

        // Decimal equivalent is
        // str[len-1]*1 + str[len-1] *
        // base + str[len-1]*(base^2) + ...
        for (i = len - 1; i >= 0; i--) {
            // A digit in input number
            // must be less than
            // number's base
            if (val(str.charAt(i)) >= base) {
                System.out.println("Invalid Number");
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }
}
