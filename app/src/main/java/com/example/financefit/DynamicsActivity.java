package com.example.financefit;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;

public class DynamicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamics);  // replace with your layout file

        TextView incomeAmount = findViewById(R.id.incomeAmount);
        TextView expensesAmount = findViewById(R.id.ExpensesAmount);

        // Set the income and expense amounts
        // Replace these with the actual values
        incomeAmount.setText("₹60000");
        expensesAmount.setText("₹45000");

        LineChart chart = findViewById(R.id.chart);

        // Create datasets for the income and expenses
        // Replace these with the actual values
        ArrayList<Entry> incomeEntries = new ArrayList<>();
        ArrayList<Entry> expenseEntries = new ArrayList<>();

        // Assuming we have arrays or lists of data points for both
        // incomes & expenses over months Jan to Jun.
        float[] incomes = {100000, 200000, 150000, 300000, 250000, 350000};  // replace with actual income values
        float[] expenses = {150000, 100000, 120000, 250000, 200000, 300000};  // replace with actual expense values

        // For loop to iterate over the data and add entries
        for (int i = 0; i < incomes.length; i++) {
            incomeEntries.add(new Entry(i, incomes[i]));
            expenseEntries.add(new Entry(i, expenses[i]));
        }

        // Create LineDataSet objects
        LineDataSet incomeDataSet = new LineDataSet(incomeEntries, "Income");
        incomeDataSet.setColor(ContextCompat.getColor(this, R.color.RED));
        LineDataSet expenseDataSet = new LineDataSet(expenseEntries, "Expenses");
        expenseDataSet.setColor(ContextCompat.getColor(this, R.color.BLUE));

        // Create LineData object
        LineData lineData = new LineData();
        lineData.addDataSet(incomeDataSet);
        lineData.addDataSet(expenseDataSet);

        // Set data to the chart and refresh
        chart.setData(lineData);
        chart.invalidate();
    }
}
