/*
03 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.database.table;

public class TableCharacter {
    public static String TABLE_NAME = "character";


    public static String FIELD_ID = "_id";
    public static String FIELD_NAME = "name";
    public static String FIELD_RACE = "race";
    public static String FIELD_SEX = "sex";


    public static String CREATE_STATEMENT =
            "CREATE TABLE `" + TABLE_NAME + "` (" +
                    " `" + FIELD_ID + "` INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " `" + FIELD_NAME + "` TEXT NOT NULL," +
                    " `" + FIELD_RACE + "` TEXT NOT NULL," +
                    " `" + FIELD_SEX + "` TEXT NOT NULL" +
                    ")";


}
