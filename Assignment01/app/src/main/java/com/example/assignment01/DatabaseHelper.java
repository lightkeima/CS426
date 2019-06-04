package com.example.assignment01;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

public class DatabaseHelper {
    final private String dbname = "database.db";
    private SQLiteDatabase db;
    DatabaseHelper(Activity context){
        db = Database.initDatabase(context,dbname);
    }
    ArrayList<Movie> GetMovieInformationList(){
        ArrayList<Movie> infor = new ArrayList<>();
        Cursor c = db.query("Movie",null,null,null,null,null,null,null);
        for(int i = 0 ; i < c.getCount(); i++) {
            c.moveToPosition(i);
            infor.add(new Movie(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getInt(3),
                    c.getDouble(4),
                    c.getString(5),
                    null,
                    c.getString(6)));
        }
        return infor;
    }

    ArrayList<String> GetGenresList(String id){
        ArrayList<String> genres = new ArrayList<>();
        Cursor c = db.query("Genres",null,"movieID = ?",  new String[]{id}, null, null,null);
        c.moveToFirst();
        for(int i = 0; i < c.getCount(); ++i){
            c.moveToPosition(i);
            genres.add(c.getString(1));
        }
        return genres;
    }
    ArrayList<Date> GetDateList(int movieID){
        final String QUERY = "SELECT DISTINCT day, dayofweek FROM Schedule WHERE movieID=? ORDER BY cast(day as int) ASC";
        ArrayList<Date> date = new ArrayList<>();
        Cursor c =db.rawQuery(QUERY, new String[]{String.valueOf(movieID)});
        c.moveToFirst();
        for(int i = 0; i < c.getCount();++i){
            date.add(new Date(
                    c.getInt(0),
                    c.getString(1)));
            c.moveToNext();
            Log.d("Check",String.valueOf(date.get(i).day));
        }
        return date;
    }
    ArrayList<String> GetCinemaList(int movieID){
        ArrayList<String> cinema = new ArrayList<>();
        final String QUERY = "SELECT CinemaName  FROM Cinema CROSS JOIN Schedule WHERE movieID=? AND Cinema.cID=Schedule.cID";
        Cursor c= db.rawQuery(QUERY,new String[]{String.valueOf(movieID)});
        c.moveToFirst();
        for(int i = 0; i<c.getCount();++i){
            cinema.add(c.getString(0));
            c.moveToNext();
        }
        return cinema;
    }
    ArrayList<String> GetTimeList(int movieID, int cID){
        ArrayList<String> time = new ArrayList<>();
        final String QUERY = "SELECT time FROM Schedule WHERE movieID=? AND cID=?";
        Cursor c= db.rawQuery(QUERY,new String[]{String.valueOf(movieID),String.valueOf(cID)});
        c.moveToFirst();
        for(int i = 0; i<c.getCount();++i){
            time.add(c.getString(0));
            c.moveToNext();
        }
        return time;
    }
}
