package com.example.financefit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class BudgetPlanningActivity extends AppCompatActivity {

    private Button introductionButton;
    private Button principlesButton;
    private Button financialLiteracyButton;
    private Button riskManagementButton;
    private Button realLifeExamplesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planning);

        introductionButton = findViewById(R.id.introduction_button);
        principlesButton = findViewById(R.id.principles_button);
        financialLiteracyButton = findViewById(R.id.financial_literacy_button);
        riskManagementButton = findViewById(R.id.risk_management_button);
        realLifeExamplesButton = findViewById(R.id.real_life_examples_button);

        introductionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.coursera.org/specializations/finance-accounting");
            }
        });

        principlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.mygreatlearning.com/academy/learn-for-free/courses/principles-of-budgeting");
            }
        });

        financialLiteracyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.udemy.com/course/financial-literacy-investing-101/?utm_source=adwords&utm_medium=udemyads&utm_campaign=DSA_Catchall_la.EN_cc.INDIA&campaigntype=Search&portfolio=India&language=EN&product=Course&test=&audience=DSA&topic=&priority=&utm_content=deal4584&utm_term=_._ag_82569850245_._ad_533220805577_._kw__._de_c_._dm__._pl__._ti_dsa-41219471920_._li_9298462_._pd__._&matchtype=&gad_source=1&gclid=Cj0KCQjwxeyxBhC7ARIsAC7dS38NBETowgccU4b1Zt8y4isc1_-f3IoONHZRXJTvdbxQ-rkZbp2UOBMaAjNzEALw_wcB&couponCode=IND21PM");
            }
        });

        riskManagementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.coursera.org/specializations/risk-management");
            }
        });

        realLifeExamplesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.investopedia.com/ask/answers/022916/what-502030-budget-rule.asp");
            }
        });
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}