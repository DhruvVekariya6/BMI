package com.example.bmicalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight,edtheight,edtheightin;
        Button btnbmi;
        TextView txt;
        LinearLayout main;


        edtheight=findViewById(R.id.edtheight);
        edtweight=findViewById(R.id.edtweight);
        edtheightin=findViewById(R.id.edtheightin);
        btnbmi=findViewById(R.id.btnbmi);
        txt = findViewById(R.id.txt);
        main = findViewById(R.id.main);

        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ft = Integer.parseInt(edtheight.getText().toString());
                int wt = Integer.parseInt(edtweight.getText().toString());
                int in = Integer.parseInt(edtheightin.getText().toString());

                int totalIn    = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM  = totalCm/100;
                double bmi     = wt/(totalM*totalM);

                if(bmi>25)
                {
                    txt.setText("You're Overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.over));
                }
                else if(bmi<18)
                {
                    txt.setText("You're Underweight");
                    main.setBackgroundColor(getResources().getColor(R.color.under));
                    txt.setTextColor(getResources().getColor(R.color.white));
                }
                else
                {
                    txt.setText("You're Helthy!");
                    main.setBackgroundColor(getResources().getColor(R.color.helthy));
                }
            }
        });

    }
}