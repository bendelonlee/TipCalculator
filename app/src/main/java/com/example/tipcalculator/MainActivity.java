package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int tipPercentage;
    final int INITIAL_TIP_PERCENTAGE = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipPercentage = INITIAL_TIP_PERCENTAGE;

        // setup text change listener
        EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
        edtMeal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                displayTotal();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void displayTotal() {
        double mealCostNumber = 0;
        EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
        String mealCostText = edtMeal.getText().toString();

        if(!mealCostText.isEmpty()){
            mealCostNumber = Double.parseDouble(mealCostText);

        }

        double totalCost = mealCostNumber * (tipPercentage / 100.0 + 1);

        TextView txtResult =  (TextView) findViewById(R.id.txtResult);
        String messageTotal = String.format(Locale.getDefault(), "$ %.2f", totalCost);
        txtResult.setText(messageTotal);
    }
}