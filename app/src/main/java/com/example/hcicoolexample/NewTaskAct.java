package com.example.hcicoolexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import android.widget.DatePicker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskAct extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView titlepage, itemTypeTitle, positionTitle, companyTitle, locationTitle, dateTitle, statusTitle, tagsTitle, notesTitle, date;
    EditText itemType, position, company, location, status, tags, notes;
    Button btnSaveTask, btnCancel;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlepage = findViewById(R.id.titlepage);

        itemTypeTitle = findViewById(R.id.itemType);
        itemType = findViewById(R.id.itemTypeText);
        positionTitle= findViewById(R.id.position);
        position = findViewById(R.id.positionText);
        companyTitle = findViewById(R.id.company);
        company = findViewById(R.id.companyText);
        locationTitle = findViewById(R.id.location);
        location = findViewById(R.id.locationText);
        dateTitle = findViewById(R.id.date);
        date = findViewById(R.id.date);
        statusTitle = findViewById(R.id.status);
        status = findViewById(R.id.statusText);
        tagsTitle = findViewById(R.id.tags);
        tags = findViewById(R.id.tagsText);
        notesTitle = findViewById(R.id.notes);
        notes = findViewById(R.id.notesText);


        Button btnCalendar = (Button) findViewById(R.id.setDate);
        btnCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById((R.id.btnCancel));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NewTaskAct.this, MainActivity.class);
                startActivity(a);
            }
        });



        btnSaveTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //inset data to database
                String itemT = itemType.getText().toString();
                String p = position.getText().toString();
                String c = company.getText().toString();
                String l = location.getText().toString();
                String d = dateTitle.getText().toString();
                String s = status.getText().toString();
                String t = tags.getText().toString();
                String n = notes.getText().toString();
                String[] newData = {itemT, p, c, l, d, s, t, n};

                //going back into the main activity?
                Intent a = new Intent(NewTaskAct.this, MainActivity.class);
                a.putExtra("NewData", newData);
                startActivity(a);
            }
        });

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        //customize font
        titlepage.setTypeface(MMedium);
        itemTypeTitle.setTypeface(MLight);
        itemType.setTypeface(MMedium);
        positionTitle.setTypeface(MLight);
        position.setTypeface(MMedium);
        companyTitle.setTypeface(MLight);
        company.setTypeface(MMedium);
        locationTitle.setTypeface(MLight);
        location.setTypeface(MMedium);
        dateTitle.setTypeface(MLight);
        date.setTypeface(MMedium);
        statusTitle.setTypeface(MLight);
        status.setTypeface(MMedium);
        tagsTitle.setTypeface(MLight);
        tags.setTypeface(MMedium);
        notesTitle.setTypeface(MLight);
        notes.setTypeface(MMedium);
        btnSaveTask.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);
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
