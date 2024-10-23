package com.example.tablecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textInput, textOutput, textInput2;
    int num, sz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonSubmit);
        textInput = findViewById(R.id.inputNumber);
        textInput2 = findViewById(R.id.inputNumber2);
        textOutput = findViewById(R.id.textView6);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputText = textInput.getText().toString();
        String inputText2 = textInput2.getText().toString();

        if (inputText.isEmpty() || inputText2.isEmpty()) {
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            num = Integer.parseInt(inputText);
            sz = Integer.parseInt(inputText2);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= sz; i++) {
            result.append(getString(R.string.multiplication_format, num, i, num * i));
        }

        textOutput.setText(result.toString());
    }

}