package com.example.financefit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsFragment extends Fragment {

    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View analyticsView = inflater.inflate(R.layout.fragment_analytics, container, false);

        Button expensesButton = analyticsView.findViewById(R.id.button);
        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExpensesAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        Button incomeButton = analyticsView.findViewById(R.id.button1);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IncomeAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        Button dynamicsButton = analyticsView.findViewById(R.id.button2);
        dynamicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DynamicsActivity.class);
                startActivity(intent);
            }
        });

        // Initialize the PieChart
        pieChart = analyticsView.findViewById(R.id.pieChart);

        // Sample data (replace with your actual data)
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(2300f, "Food"));
        entries.add(new PieEntry(19200f, "House"));
        entries.add(new PieEntry(5500f, "Coffee"));
        entries.add(new PieEntry(53000f, "Bills"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10f);

        PieData pieData = new PieData(dataSet);

        pieChart.setData(pieData);
        pieChart.setCenterText("Top Expenses\nJanuary 2023");
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setTransparentCircleRadius(30f);
        pieChart.animateXY(1000, 1000); // animate horizontal and vertical axes

        return analyticsView;
    }
}
