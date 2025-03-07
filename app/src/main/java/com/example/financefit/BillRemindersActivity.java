package com.example.financefit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BillRemindersActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private EditText editTextBillName;
    private RadioGroup radioGroupManualAuto;
    private EditText editTextAmount;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_reminders);

        // Initialize UI elements
        calendarView = findViewById(R.id.calendarView);
        editTextBillName = findViewById(R.id.editTextBillName);
        radioGroupManualAuto = findViewById(R.id.radioGroupManualAuto);
        editTextAmount = findViewById(R.id.editTextAmount);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("BillRemindersData", MODE_PRIVATE);
    }

    // Method to handle button click
    public void onSaveButtonClick(View view) {
        // Retrieve values from UI elements
        long selectedDate = calendarView.getDate();
        String billName = editTextBillName.getText().toString();

        // Check if any radio button is selected
        if (radioGroupManualAuto.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select Manual or Auto", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedRadioButtonId = radioGroupManualAuto.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String manualAutoSelection = selectedRadioButton.getText().toString();

        String amount = editTextAmount.getText().toString();

        // Check if any field is empty
        if (billName.isEmpty() || amount.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save the input values in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("selected_date", selectedDate);
        editor.putString("bill_name", billName);
        editor.putString("manual_auto_selection", manualAutoSelection);
        editor.putString("amount", amount);
        editor.apply();

        // Pass the input values to the next activity
        Intent intent = new Intent(this, BillRemindersActivity2.class);
        startActivity(intent);
    }
}
