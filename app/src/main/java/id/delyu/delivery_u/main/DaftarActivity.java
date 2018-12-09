package id.delyu.delivery_u.main;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.database.M_deliveryU;
import id.delyu.delivery_u.database.Mahasiswa;

public class DaftarActivity extends AppCompatActivity {

    private Button daftar;
    private TextView userName, namaLengkap, alamat, noHp, password;

    M_deliveryU db = new M_deliveryU(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        daftar = findViewById(R.id.signInButApp1);
        userName = findViewById(R.id.username);
        namaLengkap = findViewById(R.id.namaLengkap);
        alamat = findViewById(R.id.alamat);
        noHp = findViewById(R.id.noHp);
        password = findViewById(R.id.password1);

        final Mahasiswa mhs = new Mahasiswa();

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhs.setNamaLengkap(namaLengkap.getText().toString());
                mhs.setUsername(userName.getText().toString());
                mhs.setAlamat(alamat.getText().toString());
                mhs.setNoHp(noHp.getText().toString());
                mhs.setPassword(password.getText().toString());
                db.saveMhs(mhs);

                startActivity(new Intent(DaftarActivity.this,LoginAppActivity.class));
            }
        });

//        M_deliveryU db = new M_deliveryU(this);
//        List<Mahasiswa> mahas = db.tampil();
//
//        for (Mahasiswa p: mahas){
//            Log.i("ahaha", p.getAlamat());
//        }
//
//        while (db.getAllMahasiswaCursor2().moveToNext()){
//            String name = db.getAllMahasiswaCursor2().getString(db.getAllMahasiswaCursor2().getColumnIndex("username"));
//            Log.i("ahaha", name);
//        }
    }


}
