package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dataeven extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "my_database";
    private static final String TABLE_NAME = "my_table";

    // Các cột của bảng
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_TIMETB = "timetb";
    private static final String COLUMN_TIMEEVEN = "timeeven";
    private static final String COLUMN_TEXTEVEN = "texteven";

    public dataeven(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Phương thức onCreate được gọi khi database được tạo ra lần đầu tiên
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_TIMETB + " TEXT,"
                + COLUMN_TIMEEVEN + " TEXT,"
                + COLUMN_TEXTEVEN + " TEXT"
                + ")";
        db.execSQL(createTableQuery);
    }

    // Phương thức onUpgrade được gọi khi version của database thay đổi
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ và tạo lại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Phương thức thêm dữ liệu vào bảng
    public void addData(String title, String timetb, String timeeven, String texteven) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_TIMETB, timetb);
        values.put(COLUMN_TIMEEVEN, timeeven);
        values.put(COLUMN_TEXTEVEN, texteven);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Even> getAllEvents() {
        List<Even> eventList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Even event = new Even();
                event.setTitle(cursor.getString(0));
                event.setTimeTB(cursor.getString(1));
                event.setTimeEven(cursor.getString(2));
                event.setTextEven(cursor.getString(3));

                eventList.add(event);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return eventList;
    }
    public void updateEvent(Even event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, event.getTitle1());
        values.put(COLUMN_TIMETB, event.getTimeTB());
        values.put(COLUMN_TIMEEVEN, event.getTimeEven());
        values.put(COLUMN_TEXTEVEN, event.getTextEven());
        db.update(TABLE_NAME, values, COLUMN_TITLE + "=?", new String[]{String.valueOf(event.getTitle1())});
        db.close();
    }

    public void deleteEvent(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_TITLE + " = ?", new String[]{title});
        db.close();
    }

}