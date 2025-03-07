package com.example.financefit;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

public class ExpenseFragment extends Fragment {

    RadioGroup hiddenInsurance;
    RadioGroup hiddenEducation;
    RadioGroup hiddenRation;
    RadioGroup hiddenBills;
    RadioGroup servicing;
    RadioGroup gym;
    LinearLayout layout;
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout8;
    LinearLayout layout9;
    LinearLayout layout10;
    LayoutInflater inflater;
    ViewGroup container;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        final View view = inflater.inflate(R.layout.fragment_expense, container, false);

        // Initialize click listeners
        initializeClickListeners(view);
        return view;
    }

    private void initializeClickListeners(final View view) {
        ImageButton openButton = view.findViewById(R.id.myIconButton);
        ImageButton openButton1 = view.findViewById(R.id.myIconbutton2);
        ImageButton rightArrowButton = view.findViewById(R.id.myIconbutton);
        ImageButton openButton2 = view.findViewById(R.id.myIconbutton3);

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflater.inflate(R.layout.essential, container, false);
                hiddenInsurance = view.findViewById(R.id.insuranceRadioGroup);
                layout = view.findViewById(R.id.linearlayou9);
            }
        });

        openButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflater.inflate(R.layout.routine, container, false);
                hiddenBills = view.findViewById(R.id.bill_Radio);
                servicing = view.findViewById(R.id.serv_radio);
                gym = view.findViewById(R.id.gym);
                layout8 = view.findViewById(R.id.billslayout);
                layout9 = view.findViewById(R.id.servlayout);
                layout10 = view.findViewById(R.id.gymlayout);
            }
        });

        rightArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflater.inflate(R.layout.essential, container, false);
                hiddenInsurance = view.findViewById(R.id.insuranceRadioGroup);
                hiddenEducation = view.findViewById(R.id.educationRadioGroup);
                hiddenRation = view.findViewById(R.id.hiddenration);
                layout = view.findViewById(R.id.linearlayou9);
                layout1 = view.findViewById(R.id.linearlayou11);
                layout2 = view.findViewById(R.id.linearlayou13);
            }
        });

        openButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflater.inflate(R.layout.leisure, container, false);
            }
        });
    }

    public void expand(View view) {
        if (hiddenInsurance != null && layout != null) {
            int v = (hiddenInsurance.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout, new AutoTransition());
            hiddenInsurance.setVisibility(v);
        }else {
            Log.e("MainActivity", "hiddenInsurance or layout is null");
        }

        if (hiddenEducation != null && layout1 != null) {
            int t = (hiddenEducation.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
            hiddenEducation.setVisibility(t);
        } else {
            Log.e("MainActivity", "hiddenEducation or layout1 is null");
        }

        if (hiddenRation != null && layout2 != null) {
            int p = (hiddenRation.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
            hiddenRation.setVisibility(p);
        } else {
            Log.e("MainActivity", "hiddenRation or layout2 is null");
        }

        if (hiddenBills != null && layout8 != null) {
            int p = (hiddenBills.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout8, new AutoTransition());
            hiddenBills.setVisibility(p);
        } else {
            Log.e("MainActivity", "hiddenBills or layout8 is null");
        }

        if (servicing != null && layout9 != null) {
            int q = (servicing.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout9, new AutoTransition());
            servicing.setVisibility(q);
        } else {
            Log.e("MainActivity", "servicing or layout9 is null");
        }

        if (gym != null && layout10 != null) {
            int r = (gym.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout10, new AutoTransition());
            gym.setVisibility(r);
        } else {
            Log.e("MainActivity", "gym or layout10 is null");
        }
    }

    public void goback(View view) {
        view = inflater.inflate(R.layout.activity_main, container, false);
        // Re-initialize click listeners after returning to the main activity layout
        initializeClickListeners(view);
    }
}
