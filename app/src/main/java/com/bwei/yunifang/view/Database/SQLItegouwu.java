package com.bwei.yunifang.view.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *  * 作者：19084 on 2016/12/16 14:34
 *  * 邮箱：xjs250@163.com
 *  
 */
public class SQLItegouwu extends SQLiteOpenHelper {
    public SQLItegouwu(Context context) {
        super(context, "gouwu.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_class_table="create table gouwuche(_id integer primary key autoincrement,ProName text,proimg text,shopprice text,markPrice text,proCount text)";
        sqLiteDatabase.execSQL(sql_class_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
