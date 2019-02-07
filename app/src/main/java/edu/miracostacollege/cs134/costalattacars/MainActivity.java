package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.NumberFormat;

import edu.miracostacollege.cs134.costalattacars.R;
import edu.miracostacollege.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity
{
    //Instance variables
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;
    private CarLoan currentLoan;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    //main activity to run app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);

        currentLoan = new CarLoan();

        //Number formatters

    }

    //Switches to the other activity(loan Summary page)
    public void switchToLoanSummary(View v)
    {
        //instance variables
        double carPrice;
        double cashDownPayment;
        Integer loanTerm = 0;
        carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        cashDownPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        //determines which item was picked in the radio group
        switch(loanTermRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            case R.id.fiveYearsRadioButton:
                loanTerm = 5;
                break;
        }

        //update the model
        currentLoan.setLoanTerm(loanTerm);
        currentLoan.setPrice(carPrice);
        currentLoan.setDownPayment(cashDownPayment);

        //Create a new Intent to share data between activities, start activity, destination activity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        //Packaging the information into the intent
        loanSummaryIntent.putExtra("MonthlyPayment", currency.format(currentLoan.monthlyPayment()));
        loanSummaryIntent.putExtra("CarPrice", currency.format(currentLoan.getPrice()));
        //sending the info through the intent to the new activity
        startActivity(loanSummaryIntent);
    }
}
