package com.example.yamuna.temperatureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    RadioButton cb;
    RadioButton fb;
    LinearLayout ll;
    double w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private double c2f(double c)
    {
        return (c*9)/5+32;
    }
    private double f2c(double f)
    {
        return (f-32)*5/9;
    }

    public void submit(View view) {

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        cb = (RadioButton) findViewById(R.id.cb);
        fb = (RadioButton) findViewById(R.id.fb);
        ll = (LinearLayout) findViewById(R.id.ll);

        double a = Double.parseDouble(editText.getText().toString());

        if(cb.isChecked())
        {
            w = f2c(a);
            fb.setChecked(true);
        }
        else
        {
            w = c2f(a);
            cb.setChecked(true);
        }
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("result",w);
        startActivity(intent);
    }
}
