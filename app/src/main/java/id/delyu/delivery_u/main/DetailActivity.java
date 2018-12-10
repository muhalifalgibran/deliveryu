package id.delyu.delivery_u.main;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.delyu.delivery_u.R;

public class DetailActivity extends AppCompatActivity {
    String pesanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getStringExtra("nama");
        String harga = getIntent().getStringExtra("harga");
        String nomer = getIntent().getStringExtra("nomer");
        String gambar = getIntent().getStringExtra("gambar");

        TextView namaMakanan = findViewById(R.id.namaMakanan);
        TextView hargaMakanan = findViewById(R.id.hargaMakanan);
        ImageView gambarMakanan = findViewById(R.id.gambarMakanan);
        Button kirim = findViewById(R.id.kirimPesanan);
        Button batal = findViewById(R.id.batalPesanan);

        pesanan = "https://api.whatsapp.com/send?phone="+nomer+"&text=%5B%20dipesan%20via%20Delivery-U%20%5D%0A%0APesen "+nama;


        namaMakanan.setText(nama);
        hargaMakanan.setText(harga);
        Picasso.get()
                .load(gambar)
                .into(gambarMakanan);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setData(Uri.parse(pesanan));
                startActivity(sendIntent);
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(sendIntent);
            }
        });
    }


}
