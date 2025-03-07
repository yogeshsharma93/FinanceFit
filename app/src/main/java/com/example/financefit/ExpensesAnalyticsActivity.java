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
import java.util.ArrayList;

public class ExpensesAnalyticsActivity extends AppCompatActivity {
    private PieChart pieChart;
    private ListView listViewExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expenses_analytics);

        // Initialize views
        pieChart = findViewById(R.id.pieChart_view);
        listViewExpenses = findViewById(R.id.listViewExpenses);

        // Set up pie chart (populate with actual data)
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(1200f, "Grocery"));
        pieEntries.add(new PieEntry(800f, "Subscription"));
        pieEntries.add(new PieEntry(500f, "Entertainment"));
        pieEntries.add(new PieEntry(300f, "Dining Out"));
        pieEntries.add(new PieEntry(400f, "Transportation"));

        // Custom lighter colors for each category
        int[] categoryColors = {
                Color.parseColor("#66b3ff"), // Light blue
                Color.parseColor("#99cc99"), // Light green
                Color.parseColor("#ffcc99"), // Light orange
                Color.parseColor("#ff9999"), // Light red
                Color.parseColor("#ff99cc")  // Light pink
        };

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Expenses");
        pieDataSet.setColors(categoryColors);
        // Customize other pie chart appearance (labels, text size, etc.)

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        // Set up transaction list (populate with actual data)
        ArrayList<String> transactionList = new ArrayList<>();
        transactionList.add("Buying some grocery - Rs 1200");
        transactionList.add("Subscription Annual - Rs 800");
        transactionList.add("Movie tickets - Rs 500");
        transactionList.add("Dinner at a restaurant - Rs 300");
        transactionList.add("Metro fare - Rs 400");
        // Add other transactions based on your actual data

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, transactionList);
        listViewExpenses.setAdapter(adapter);
    }
}