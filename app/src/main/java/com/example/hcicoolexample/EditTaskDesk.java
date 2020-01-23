package com.example.hcicoolexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class EditTaskDesk extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    EditText itemType, position, company, location, status, tags, notes;
    TextView date;
    Button btnSaveUpdate, btnDelete;
    int arrPos;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task_desk);

        arrPos = getIntent().getIntExtra("Position", -5);
        itemType = (EditText) findViewById(R.id.itemTypeText);
        position = (EditText) findViewById((R.id.positionText));
        company = (EditText) findViewById((R.id.companyText));
        location = (EditText) findViewById(R.id.locationText);
        date = (TextView) findViewById((R.id.date));
        status = (EditText) findViewById((R.id.statusText));
        tags = (EditText) findViewById(R.id.tagsText);
        notes = (EditText) findViewById((R.id.notesText));

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        //get a value from previous page
        itemType.setText(getIntent().getStringExtra("itemType"));
        position.setText(getIntent().getStringExtra("position"));
        company.setText(getIntent().getStringExtra("company"));
        location.setText(getIntent().getStringExtra("location"));
        date.setText(getIntent().getStringExtra("date"));
        status.setText(getIntent().getStringExtra("status"));
        tags.setText(getIntent().getStringExtra("tags"));
        notes.setText(getIntent().getStringExtra("notes"));


        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                   Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                   a.putExtra("DeletePosition", arrPos);
                   startActivity(a);
            }
        });


        //make an event for button
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(EditTaskDesk.this, MainActivity.class);
                a.putExtra("ChangePosition", arrPos);
                String[] newInfo = {itemType.getText().toString(), position.getText().toString(), company.getText().toString(), location.getText().toString(), date.getText().toString(), status.getText().toString(), tags.getText().toString(), notes.getText().toString()};
                a.putExtra("NewInfo", newInfo);
                startActivity(a);
            }
        });

        Button btnCalendar = (Button) findViewById(R.id.setDate);
        btnCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(cal.getTime());

        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText(currentDateString);
    }
}
