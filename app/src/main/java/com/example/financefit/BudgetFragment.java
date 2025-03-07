package com.example.financefit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BudgetFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        // Get references to buttons
        view.findViewById(R.id.btn_my_income).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch My Income activity
                Intent intent = new Intent(getActivity(), MyIncomeActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_budget_planning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Budget Planning activity
                Intent intent = new Intent(getActivity(), BudgetPlanningActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_bill_reminders).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Bill Reminders activity
                Intent intent = new Intent(getActivity(), BillRemindersActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_goal_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Goal Setting activity
                Intent intent = new Intent(getActivity(), GoalSettingActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}