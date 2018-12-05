package id.delyu.delivery_u.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "deliveryu";
    public static int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mahasiswa = "CREATE TABLE mahasiswa(_id INTEGER PRIMARY KEY," +
                "username TEXT," +
                "namaLengkap TEXT," +
                "alamat TEXT," +
                "noHp TEXT," +
                "password TEXT)";
        db.execSQL(mahasiswa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 2 && oldVersion == 1){

        }
    }


}
