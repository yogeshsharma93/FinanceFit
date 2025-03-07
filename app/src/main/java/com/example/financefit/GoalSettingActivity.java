package com.example.financefit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GoalSettingActivity extends AppCompatActivity {

    private EditText editTextGoalName, editTextGoalDeadline, editTextAmountSaved, editTextGoalAmount;
    private LinearLayout layoutEnteredData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_setting);

        // Initialize EditTexts
        editTextGoalName = findViewById(R.id.editTextGoalName);
        editTextGoalDeadline = findViewById(R.id.editTextGoalDeadline);
        editTextAmountSaved = findViewById(R.id.editTextAmountSaved);
        editTextGoalAmount = findViewById(R.id.editTextGoalAmount);

        // Initialize LinearLayout to display entered data
        layoutEnteredData = findViewById(R.id.layoutEnteredData);
    }

    public void onAddGoalButtonClick(View view) {
        // Get entered data
        String goalName = editTextGoalName.getText().toString();
        String goalDeadline = editTextGoalDeadline.getText().toString();
        String amountSaved = editTextAmountSaved.getText().toString();
        String goalAmount = editTextGoalAmount.getText().toString();

        // Create TextViews to display the entered data with their respective headings
        TextView textViewGoalName = new TextView(this);
        textViewGoalName.setText("Goal Name: " + goalName);

        TextView textViewGoalDeadline = new TextView(this);
        textViewGoalDeadline.setText("Goal Deadline: " + goalDeadline);

        TextView textViewAmountSaved = new TextView(this);
        textViewAmountSaved.setText("Amount Saved: Rs. " + amountSaved);

        TextView textViewGoalAmount = new TextView(this);
        textViewGoalAmount.setText("Goal Amount: Rs. " + goalAmount);

        // Add TextViews to the layoutEnteredData LinearLayout
        layoutEnteredData.addView(textViewGoalName);
        layoutEnteredData.addView(textViewGoalDeadline);
        layoutEnteredData.addView(textViewAmountSaved);
        layoutEnteredData.addView(textViewGoalAmount);

        // Clear EditText fields after adding the goal
        editTextGoalName.getText().clear();
        editTextGoalDeadline.getText().clear();
        editTextAmountSaved.getText().clear();
        editTextGoalAmount.getText().clear();
    }


}