package com.example.easyorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Date_Pop_Up_Window extends Activity {

    CalendarView myCalendar;
    Button doneButton;
    String date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_pop_up_window);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout( (int)(0.8* width), (int)(0.8*height) );
        myCalendar = (CalendarView) findViewById(R.id.calendarView);
        myCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month+1) + "/" + dayOfMonth + "/" + year;
                Intent intent = new Intent(Date_Pop_Up_Window.this, AddOrder.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
        /*
        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddOrderActivity();
            }
        });*/
    }

    public void openAddOrderActivity()
    {
        Intent intent = new Intent(Date_Pop_Up_Window.this, AddOrder.class);
        startActivity(intent);
    }
}
