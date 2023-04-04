//package com.example.myapplication;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Sua extends AppCompatActivity {
//
//    EditText titleEditText;
//    EditText timetbEditText;
//    EditText timeevenEditText;
//    EditText textevenEditText;
//    Even eventToEdit;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sua);
//
//        titleEditText = findViewById(R.id.title);
//        timetbEditText = findViewById(R.id.timetb);
//        timeevenEditText = findViewById(R.id.timeven);
//        textevenEditText = findViewById(R.id.texteven);
//
//        // Lấy đối tượng sự kiện được truyền từ MainActivity
//        eventToEdit = getIntent().getParcelableExtra("eventToEdit");
//
//        // Đưa thông tin sự kiện lên giao diện để người dùng chỉnh sửa
//        titleEditText.setText(eventToEdit.getTitle());
//        timetbEditText.setText(eventToEdit.getTimeTB());
//        timeevenEditText.setText(eventToEdit.getTimeEven());
//        textevenEditText.setText(eventToEdit.getTextEven());
//
//        Button saveBtn = findViewById(R.id.button_save);
//        saveBtn.setOnClickListener(v -> {
//            String titleText = titleEditText.getText().toString();
//            String timetbText = timetbEditText.getText().toString();
//            String timeevenText = timeevenEditText.getText().toString();
//            String textevenText = textevenEditText.getText().toString();
//
//            // Cập nhật thông tin sự kiện vào CSDL
//            dataeven db = new dataeven(this);
//            eventToEdit.setTitle(titleText);
//            eventToEdit.setTimeTB(timetbText);
//            eventToEdit.setTimeEven(timeevenText);
//            eventToEdit.setTextEven(textevenText);
//            db.updateEvent(eventToEdit);
//
//            // Trở về MainActivity sau khi lưu thông tin sự kiện
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        });
//    }
//}

