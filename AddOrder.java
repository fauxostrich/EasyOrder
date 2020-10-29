package com.example.easyorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddOrder extends AppCompatActivity {

    Order newOrder;
    ImageButton doneButton;
    ImageButton cancelButton;

    Button dateButton;

    EditText customerName;
    EditText customerPhone;
    EditText customerOrder;

    TextView dateTextView;

    String name;
    String phone;
    String order;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        doneButton = (ImageButton) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityandSend();
            }
        });

        cancelButton = (ImageButton) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        customerName = (EditText) findViewById(R.id.customerName);
        customerPhone = (EditText) findViewById(R.id.customerPhone);
        customerOrder = (EditText) findViewById(R.id.customerOrder);

        dateTextView = (TextView) findViewById(R.id.dateTextView);

        dateButton = (Button) findViewById(R.id.date);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* OPEN POP-UP WINDOW */
                startActivity(new Intent(AddOrder.this, Date_Pop_Up_Window.class));
            }
        });
        Intent incomingIntent = getIntent();
        date = incomingIntent.getStringExtra("date");
        dateTextView.setText(date);
        if(customerName.getText().toString() == null
                || customerPhone.getText().toString() == null
                || customerOrder.getText().toString() == null
                || date == null)
            throw new NullPointerException();
        else
        {
            name = customerName.getText().toString();
            phone = customerPhone.getText().toString();
            order = customerOrder.getText().toString();
        }
        /*
        String orderString;
        Order o = new Order(name, phone, date, order);
        orderString = o.toString();
        Log.d("Order", orderString);
        */
    }

    private void openMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openMainActivityandSend()
    {
        Intent intent = new Intent(this, MainActivity.class);
        newOrder.add(new Order(name, phone, date, order));
        startActivity(intent);
    }
}
