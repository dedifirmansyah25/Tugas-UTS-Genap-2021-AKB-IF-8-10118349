/*
07 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.myprofile_10118349.database.table.TableCharacter;



public class Character {
        private int id;
        private String name;
        private String race;
        private String sex;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Character fromCursor(Cursor c){
            this.setId(c.getInt(c.getColumnIndex(TableCharacter.FIELD_ID)));
            this.setName(c.getString(c.getColumnIndex(TableCharacter.FIELD_NAME)));
            this.setRace(c.getString(c.getColumnIndex(TableCharacter.FIELD_RACE)));
            this.setSex(c.getString(c.getColumnIndex(TableCharacter.FIELD_SEX)));
            return this;
        }

        public ContentValues toValues() {
            ContentValues cv = new ContentValues();
            if(this.getId() > 0){
                cv.put(TableCharacter.FIELD_ID, this.getId());
            }
            cv.put(TableCharacter.FIELD_NAME, this.getName());
            cv.put(TableCharacter.FIELD_RACE, this.getRace());
            cv.put(TableCharacter.FIELD_SEX, this.getSex());
            return cv;
        }

        public String toString(){ return this.getName();
        }
    }






