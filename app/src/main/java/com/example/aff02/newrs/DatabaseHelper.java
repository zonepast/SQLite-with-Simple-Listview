package com.example.aff02.newrs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AFF02 on 23-Aug-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CUSTOMER_DETAILS.DB";
    public static final String TABLE_NAME = "CUSTOMER_DATA";
    public static final int DATABASE_VERSION = 1;

    public static final String COL_NAME = "Name";
    public static final String COL_RUPEES = "Rupees";
    public static final String COL_DESC = "Desc";

    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        br = "CREATE TABLE "+TABLE_NAME+"("+COL_NAME+ " TEXT, "+COL_RUPEES+ " INTEGER, "+COL_DESC+ " TEXT);";
        db.execSQL(br);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME+" ;");
    }

    public void insertData (String name, String rupees, String desc)
    {
        System.out.print("Hello "+br);
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(String.valueOf(COL_RUPEES),rupees);
        contentValues.put(COL_DESC,desc);
        db.insert(TABLE_NAME,null,contentValues);
    }

    public List<DataModel> getData()
    {
        List<DataModel> dataModelList = new ArrayList<DataModel>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" ;",null);

        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;

        while (cursor.moveToNext())
        {
            dataModel = new DataModel();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
            String desc = cursor.getString(cursor.getColumnIndexOrThrow("Desc"));
            int rupees = cursor.getInt(cursor.getColumnIndexOrThrow("Rupees"));

            dataModel.setName(name);
            dataModel.setDesc(desc);
            dataModel.setRupees(rupees);

            stringBuffer.append(dataModel);

            dataModelList.add(dataModel);
        }

        for (DataModel mo : dataModelList)
        {
            Log.i("Hellomo",""+mo.getName());
        }

        return dataModelList;
    }
}
