package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    //instance variables
    private TextView monthlyPayment;

    //Main activity that runs the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        //Initializing the variables
        monthlyPayment = findViewById(R.id.monthlyPaymentTextView);

        //Receive the intent from the main activity
        Intent intent = getIntent();

        //Populate all the text views
        monthlyPayment.setText(intent.getStringExtra("MonthlyPayment"));
    }

    public void closeActivity(View v)
    {
        this.finish();
    }


}
