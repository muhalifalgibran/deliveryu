package id.delyu.delivery_u.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.adapter.RvAdapterPaket;

public class Minuman extends Fragment {


    private ArrayList<String> gambarUrl = new ArrayList<>();
    private ArrayList<String> nama = new ArrayList<>();
    private ArrayList<String> harga = new ArrayList<>();
    private ArrayList<String> noHp = new ArrayList<>();
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rv_paket, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView rv = getView().findViewById(R.id.rv_paket);
        initImageToBitmap();

        RvAdapterPaket adapter = new RvAdapterPaket(getContext(),gambarUrl, nama, harga,noHp);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void initImageToBitmap(){
        gambarUrl.add("https://cdn0-a.production.images.static6.com/udORpdn41RWSFQRJ4ydjD6tXu60=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/liputan6-media-production/medias/1608631/original/047468900_1496114991-Baiknya-Minuman-Dingin-atau-Hangat-untuk-Buka-Puasa.jpg");
        nama.add("Es Teh Cimin");
        harga.add("Rp. 14.000");
        noHp.add("6285364629796");

        gambarUrl.add("https://img-global.cpcdn.com/003_recipes/565bd08ff891236f/1200x630cq70/photo.jpg");
        nama.add("Jus jeruk Kelapa Muda");
        harga.add("Rp. 15.000");
        noHp.add("6282119753973");


        gambarUrl.add("https://ksmtour.com/media/images/articles16/kopi-es-tak-kie-jakarta.jpg");
        nama.add("Es Kopi");
        harga.add("Rp. 18.000");
        noHp.add("6282119753973");

        gambarUrl.add("http://cdn2.tstatic.net/travel/foto/bank/images/es-kopi-susu_20180202_130356.jpg");
        nama.add("Kopi Aduhai");
        harga.add("Rp. 18.000");
        noHp.add("6281225462131");

        gambarUrl.add("https://2.bp.blogspot.com/-I2rQkedOfiM/V0KUwEn2auI/AAAAAAAABag/eGW1iuyzArkFkur14nJPcL7orJwCI_0pACLcB/s1600/Kopi%2BEs%2BTak%2BKie.jpg");
        nama.add("Teh Tarik Nyos");
        harga.add("Rp. 24.000");
        noHp.add("6281225462131");

    }

    public void toWhatsApp(Context context, String pesanan){
        Intent sendIntent = new Intent();
        sendIntent.setData(Uri.parse(pesanan));
        context.startActivity(sendIntent);

    }

}