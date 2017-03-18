package com.example.ali.datetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private int year_x,month_x,day_x;
    private static final int DATE_DIALOG_ID = 0;
    private static final int TIME_DIALOG_ID = 1;
    private Button button1;
    private int hour_x,minute_x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        showDialogonButtonClick();
        ShowTimePickerDialog();
    }

    public void showDialogonButtonClick(){

        button = (Button)findViewById(R.id.btn_date_picker);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        showDialog(DATE_DIALOG_ID);


                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DATE_DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner ,year_x,month_x,day_x);
         else if (id == TIME_DIALOG_ID)
            return new TimePickerDialog(MainActivity.this, KTimePickerDialog,hour_x,minute_x,false);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month+1;
            day_x = dayOfMonth;
            Toast.makeText(MainActivity.this,year_x + "/" + month_x + "/" + day_x,Toast.LENGTH_LONG).show();
        }
    };

    public void ShowTimePickerDialog(){

        button1 = (Button)findViewById(R.id.btn_time_picker);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME_DIALOG_ID);
                    }
                }
        );
    }

    protected TimePickerDialog.OnTimeSetListener KTimePickerDialog =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    hour_x = hourOfDay;
                    minute_x = minute;
                    Toast.makeText(MainActivity.this,hour_x+" : " + minute_x, Toast.LENGTH_SHORT).show();

                }
            };

}


