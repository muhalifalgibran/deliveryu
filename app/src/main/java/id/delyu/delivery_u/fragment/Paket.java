package id.delyu.delivery_u.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import java.util.ArrayList;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.adapter.RvAdapterPaket;
import id.delyu.delivery_u.main.DaftarActivity;
import id.delyu.delivery_u.main.LandingActivity;
import id.delyu.delivery_u.main.MainActivity;

public class Paket extends Fragment {

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
        gambarUrl.add("https://www.sipendik.com/wp-content/uploads/2015/12/cara-membuat-ayam-bakar.jpg");
        nama.add("Ayam Bakar Terbang");
        harga.add("Rp. 14.000");
        noHp.add("6285364629796");

        gambarUrl.add("https://cdns.klimg.com/vemale.com/headline/650x325/2017/03/resep-bakso-ayam-bakar-madu-enaknya-juara.jpg");
        nama.add("Bakso Ayam Australia");
        harga.add("Rp. 15.000");
        noHp.add("6282119753973");


        gambarUrl.add("https://batamtoday.com/media/news/ayam-bakar-madu.jpg");
        nama.add("Ayam Bakar Madu Spanyol");
        harga.add("Rp. 18.000");
        noHp.add("6282119753973");

        gambarUrl.add("https://food-images.files.bbci.co.uk/food/recipes/nasi_goreng_with_lime_87031_16x9.jpg");
        nama.add("Nasi Goreng Perancis");
        harga.add("Rp. 11.000");
        noHp.add("6282119753973");


        gambarUrl.add("https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/quick-spicy-nasi-goreng.jpg?itok=tkL7Dx5q");
        nama.add("Nasi Goreng Telur T-Rex");
        harga.add("Rp. 20.000");
        noHp.add("6281225462131");


        gambarUrl.add("http://www.dapurkobe.co.id/wp-content/uploads/seblak-poll-pedas-1.jpg");
        nama.add("Mie Goreng Seblak Naga");
        harga.add("Rp. 18.000");
        noHp.add("6281225462131");

        gambarUrl.add("https://i1.wp.com/resepkoki.id/wp-content/uploads/2018/09/Resep-Nasi-Bakar-Ayam-Kemangi.jpg?fit=1254%2C1254&ssl=1");
        nama.add("Nasi Bakar Inggris");
        harga.add("Rp. 24.000");
        noHp.add("6281225462131");

    }

    public void toWhatsApp(Context context, String pesanan){
        Intent sendIntent = new Intent();
        sendIntent.setData(Uri.parse(pesanan));
        context.startActivity(sendIntent);

    }


}
