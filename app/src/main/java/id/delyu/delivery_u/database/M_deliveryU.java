package id.delyu.delivery_u.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class M_deliveryU {

    DbHelper database;

    public M_deliveryU(Context context){
        database = new DbHelper(context);
    }

    public void saveMhs(Mahasiswa mhs){
        SQLiteDatabase db = database.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", mhs.getUsername());
        cv.put("namaLengkap", mhs.getNamaLengkap());
        cv.put("alamat", mhs.getAlamat());
        cv.put("noHp", mhs.getNoHp());
        cv.put("password", mhs.getPassword());

        db.insert("mahasiswa",null, cv);
    }

    public List<Mahasiswa> tampil(){
        SQLiteDatabase db = database.getReadableDatabase();
        List<Mahasiswa> mhs = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM mahasiswa",null);

        if(cursor.moveToFirst()){
            do {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setUsername(cursor.getString(0));
                mahasiswa.setNamaLengkap(cursor.getString(1));
                mahasiswa.setAlamat(cursor.getString(2));
                mahasiswa.setNoHp(cursor.getString(3));
                mahasiswa.setPassword(cursor.getString(4));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return mhs;
    }

    public Cursor getAllMahasiswaCursor(){
        SQLiteDatabase db = database.getReadableDatabase();
        return db.rawQuery("SELECT * FROM mahasiswa", null);
    }

    public Boolean login(Mahasiswa mhs){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM mahasiswa WHERE username =? AND password =?",
                new String[]{mhs.getPassword(), mhs.getPassword()});

        if (c.getCount() > 0 ){
            return true;
        }else {
            return false;
        }
    }

    public Cursor getAllMahasiswaCursor2(){
        SQLiteDatabase db = database.getReadableDatabase();
        String[] columns = {"_id", "namaLengkap", "alamat", "noHp", "password"};
        return db.query("mahasiswa",columns,null,null,null,null,null);
    }
}
