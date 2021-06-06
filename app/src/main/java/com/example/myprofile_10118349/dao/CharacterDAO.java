/*
01 JUNI 2021
10118349
Dedi firmansyah
IF8
*/

package com.example.myprofile_10118349.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myprofile_10118349.database.MyOpenHelper;
import com.example.myprofile_10118349.database.table.TableCharacter;
import com.example.myprofile_10118349.model.Character;

import java.util.ArrayList;

public class CharacterDAO {
    MyOpenHelper myOpenHelper;


    public CharacterDAO(Context context){
        myOpenHelper = new MyOpenHelper(context);
    }



    public ArrayList<Character> select (String where, String[] whereArgs){
        ArrayList<Character> characters = new ArrayList<>();
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();
        try{
            Cursor c = database.query(TableCharacter.TABLE_NAME, new String[]{"*"}, where, whereArgs, null, null, TableCharacter.FIELD_NAME);
            if(c.getCount() > 0 && c.moveToFirst()) {
                while (!c.isAfterLast()) {
                    characters.add(new Character().fromCursor(c));
                    c.moveToNext();
                }
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        database.close();
        return characters;
    }


        public long insert(Character c){
            long id = -1;
            SQLiteDatabase database = myOpenHelper.getWritableDatabase();
            try {
                id = database.insert(TableCharacter.TABLE_NAME, null, c.toValues());
            }catch (Exception e){
                e.printStackTrace();
            }
            database.close();
            return id;
        }


        public int update(Character c){
            int rows = -1;
            SQLiteDatabase database = myOpenHelper.getWritableDatabase();
            try {
                ContentValues cv = c.toValues();

                rows = database.update(TableCharacter.TABLE_NAME, cv, TableCharacter.FIELD_ID + " = ?", new String[]{String.valueOf(cv.getAsInteger(TableCharacter.FIELD_ID))});
            }catch (Exception e){
                e.printStackTrace();
            }
            database.close();
            return rows;
        }


        public int delete(int id){
            int rows = -1;
            SQLiteDatabase database = myOpenHelper.getWritableDatabase();
            try {
                rows = database.delete(TableCharacter.TABLE_NAME, TableCharacter.FIELD_ID + " = ?", new String[]{String.valueOf(id)});
            }catch (Exception e){
                e.printStackTrace();
            }
            database.close();
            return rows;
        }
    }




