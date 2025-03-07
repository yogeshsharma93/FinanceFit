package com.example.financefit;

import android.graphics.Color;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class IncomeAnalyticsActivity extends AppCompatActivity {
    private PieChart pieChart;
    private ListView listViewExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_income_analytics);

        // Initialize views
        pieChart = findViewById(R.id.pieChart_view);
        listViewExpenses = findViewById(R.id.listViewIncome);

        // Set up pie chart (populate with actual data)
        // Set up pie chart (populate with actual data)
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(52000f, "Salary"));
        pieEntries.add(new PieEntry(12000f, "Passive Income"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Income"); // Initialize the pieDataSet
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f); // Set other properties as needed

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();


        // Set up transaction list (populate with actual data)
        ArrayList<String> transactionList = new ArrayList<>();
        transactionList.add("Annual Income - Rs 52000");
        transactionList.add("Passiive Income - Rs 12000");
        // Add other transactions based on your actual data

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, transactionList);
        listViewExpenses.setAdapter(adapter);
    }
}
