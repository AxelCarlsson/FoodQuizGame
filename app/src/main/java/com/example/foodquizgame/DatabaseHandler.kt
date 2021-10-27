package com.example.foodquizgame

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "DB"
const val TABLE_NAME = "Users"
const val COL_NAME = "name"
const val COL_AGE = "age"
const val COL_ID = "id"
const val COL_SCORE = "score"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME VARCHAR(256), " +
                "$COL_AGE INTEGER, " +
                "$COL_SCORE INTEGER)"

        db?.execSQL(createTable)
    }

    fun insertData(user : User) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE, user.age)
        cv.put(COL_SCORE, user.score)

        val result = db.insert(TABLE_NAME, null, cv)
        if (result == (0).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("Range")
    fun readData() : MutableList<User> {
        val list: MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME ORDER BY $COL_SCORE DESC LIMIT 5"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()){
            do{
                val user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                user.score = result.getString(result.getColumnIndex(COL_SCORE)).toInt()
                list.add(user)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun deleteData() {
        val db = this.writableDatabase
        db.execSQL("delete from " + com.example.foodquizgame.TABLE_NAME)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}