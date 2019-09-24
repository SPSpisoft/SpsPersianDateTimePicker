package com.spisoft.spspersiandatetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.spisoft.persiandatetimepicker.date.DatePickerDialog;
import com.spisoft.persiandatetimepicker.utils.PersianCalendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static DatePickerDialog datePickerDialog;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.mText);

        PersianCalendar persianCalendar = new PersianCalendar();
        datePickerDialog = DatePickerDialog.newInstance(
                this,
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        );
//        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//                String mDate = year + "/" + (monthOfYear+1) + "/" + dayOfMonth;
//                textView.setText(mDate);
//            }
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                String mDate = year + "/" + (month+1) + "/" + dayOfMonth;
//                textView.setText(mDate);
//            }
//        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show(getFragmentManager(), "MyTag");
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                String mDate = year + "/" + (monthOfYear+1) + "/" + dayOfMonth;
                textView.setText(mDate);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String mDate = year + "/" + (month+1) + "/" + dayOfMonth;
                textView.setText(mDate);
    }
}
