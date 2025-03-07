package com.example.financefit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MyIncomeActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText etAmount;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_income);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyIncomeData", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        etAmount = findViewById(R.id.et_amount);
        radioGroup = findViewById(R.id.radioGroup);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        // Get selected income source
        RadioButton selectedSourceButton = findViewById(radioGroup.getCheckedRadioButtonId());
        String incomeSource = selectedSourceButton.getText().toString();

        // Get selected frequency
        RadioButton selectedFrequencyButton = findViewById(radioGroup.getCheckedRadioButtonId());
        String incomeFrequency = selectedFrequencyButton.getText().toString();

        // Get entered amount
        String amount = etAmount.getText().toString().trim();
        if (amount.isEmpty()) {
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save data to SharedPreferences
        editor.putString("incomeSource", incomeSource);
        editor.putString("incomeFrequency", incomeFrequency);
        editor.putString("amount", amount);
        editor.apply();

        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
}

