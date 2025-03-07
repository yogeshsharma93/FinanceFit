package com.example.financefit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BillRemindersActivity2 extends AppCompatActivity {

    ImageView yourBillReminderImage;
    TextView yourBillText, reminderText, textBillName, textReminderDate, textAmount, textManualAutomatic;
    Button btnPay;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_reminders2);

        // Initialize views
        yourBillReminderImage = findViewById(R.id.your_bill_reminder_image);
        yourBillText = findViewById(R.id.Your_Bill_text);
        reminderText = findViewById(R.id.Reminder_text);
        textBillName = findViewById(R.id.text_bill_name);
        textReminderDate = findViewById(R.id.text_reminder_date);
        textAmount = findViewById(R.id.text_amount);
        textManualAutomatic = findViewById(R.id.text_manual_automatic);
        btnPay = findViewById(R.id.btn_pay);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("BillRemindersData", MODE_PRIVATE);

        // Display saved data
        displayData();

        // Set onClickListener for the Pay Now button
        btnPay.setOnClickListener(v -> payNow());
    }

    // Method to display saved data
    private void displayData() {
        // Retrieve saved data from SharedPreferences
        String billName = sharedPreferences.getString("bill_name", "");
        long selectedDate = sharedPreferences.getLong("selected_date", 0);
        String manualAutoSelection = sharedPreferences.getString("manual_auto_selection", "");
        String amount = sharedPreferences.getString("amount", "");

        // Format date as "DD/MM/YYYY"
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = sdf.format(new Date(selectedDate));

        // Populate TextViews with saved data
        textBillName.setText(getString(R.string.text_bill_name_placeholder, billName));
        textReminderDate.setText(getString(R.string.text_reminder_date_placeholder, formattedDate));
        textManualAutomatic.setText(getString(R.string.text_manual_automatic_placeholder, manualAutoSelection));
        textAmount.setText(getString(R.string.text_amount_placeholder, amount));
    }

    // Method to perform actions when the Pay Now button is clicked
    private void payNow() {
        // Create a toast message prompting the user to select a payment app
        Toast.makeText(this, "Select a payment app", Toast.LENGTH_SHORT).show();

        // Launch the Google Play Store to let the user choose a payment app
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=payment"));
        startActivity(intent);
    }
}
