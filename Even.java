package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Even extends AppCompatActivity {

    EditText titleEditText;
    EditText timetbEditText;
    EditText timeevenEditText;
    EditText textevenEditText;
    String title;
    String timetb;
    String timeeven;
    String texteven;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeTB(String timetb) {
        this.timetb = timetb;
    }

    public void setTimeEven(String timeeven) {
        this.timeeven = timeeven;
    }

    public void setTextEven(String texteven) {
        this.texteven = texteven;
    }

    public String getTitle1() {
        return title;
    }
    public String getTimeTB() {
        return timetb;
    }

    public String getTimeEven() {
        return timeeven;
    }

    public String getTextEven() {
        return texteven;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themsukien);

        titleEditText = findViewById(R.id.title);
        timetbEditText = findViewById(R.id.timetb);
        timeevenEditText = findViewById(R.id.timeven);
        textevenEditText = findViewById(R.id.texteven);

        ImageButton addButton = findViewById(R.id.insert);
        addButton.setOnClickListener(v -> {
            String titleText = titleEditText.getText().toString();
            String timetbText = timetbEditText.getText().toString();
            String timeevenText = timeevenEditText.getText().toString();
            String textevenText = textevenEditText.getText().toString();

            // Tạo một đối tượng DatabaseHelper
            dataeven dbHelper = new dataeven(this);
            dbHelper.addData(titleText, timetbText, timeevenText, textevenText);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });
    }

    public void deleteEventFromDatabase() {
        dataeven dbHelper = new dataeven(this);
        dbHelper.deleteEvent(getTitle1());
    }

    // Phương thức để sửa sự kiện trong database
    public void editEventInDatabase(Even newEvent) {
        dataeven dbHelper = new dataeven(this);
        dbHelper.updateEvent(newEvent);
    }
}
