package com.example.admin.datepicker;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDate = (TextView) findViewById(R.id.textViewDate);
        textDate.setHint("Enter your birth date");
    }

    public void onSelectDateClicked(View view) {
        Calendar calendar = Calendar.getInstance();
        final Calendar c = Calendar.getInstance(TimeZone.GMT_ZONE);
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        //launch datepicker modal
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textDate.setText(String.format("%s/%s/%s", String.valueOf(dayOfMonth),String.valueOf(monthOfYear),String.valueOf(year)));
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}
