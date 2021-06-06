/*
01 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myprofile_10118349.database.table.TableCharacter;


    public class MyOpenHelper extends SQLiteOpenHelper {
        public static String DATABASE_NAME = "SimpleCRUD";
        public static int DATABASE_VERSION = 1;


        public MyOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TableCharacter.CREATE_STATEMENT);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }



