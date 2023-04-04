package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Even.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataeven db = new dataeven(this);
        List<Even> eventList = db.getAllEvents();

        adapter = new EventAdapter(this, eventList);
        recyclerView.setAdapter(adapter);

        adapter.setEventListener(new EventAdapter.EventListener() {
            @Override
            public void onDelete(int position) {
                Even eventToDelete = eventList.get(position);
                dataeven db = new dataeven(MainActivity.this);
                db.deleteEvent(eventToDelete.getTitle1());
                eventList.remove(position);
                adapter.notifyItemRemoved(position);
            }

            @Override
            public void onEdit(int position) {
                Even eventToEdit = eventList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("title", eventToEdit.getTitle1());
                bundle.putString("timetb", eventToEdit.getTimeTB());
                bundle.putString("timeeven", eventToEdit.getTimeEven());
                bundle.putString("texteven", eventToEdit.getTextEven());
//                Intent intent = new Intent(MainActivity.this, Sua.class);
//                intent.putExtra("eventToEdit", bundle);
//                startActivity(intent);
            }
        });


        adapter = new EventAdapter(this, eventList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                Intent intent = new Intent(this, themlich.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}