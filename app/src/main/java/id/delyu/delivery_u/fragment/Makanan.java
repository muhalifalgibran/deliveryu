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
import id.delyu.delivery_u.adapter.RvAdapterMakanan;
import id.delyu.delivery_u.adapter.RvAdapterPaket;

public class Makanan extends Fragment {

    private ArrayList<String> gambarUrl = new ArrayList<>();
    private ArrayList<String> nama = new ArrayList<>();
    private ArrayList<String> harga = new ArrayList<>();
    private ArrayList<String> noHp = new ArrayList<>();

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

        RvAdapterMakanan adapter = new RvAdapterMakanan(getContext(),gambarUrl, nama, harga,noHp);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void initImageToBitmap(){
        gambarUrl.add("http://cdn2.tstatic.net/jabar/foto/bank/images/mi-instan_20180101_133438.jpg");
        nama.add("mie cengek naga");
        harga.add("Rp. 12.000");
        noHp.add("6285364629796");

        gambarUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTJHY9anOS7FUzvot2frpX9Kpkja2d43lCSc-nkv3G9MtFDY7sBw");
        nama.add("bakso petir");
        harga.add("Rp. 13.000");
        noHp.add("6282119753973");


        gambarUrl.add("https://indobubbletea.files.wordpress.com/2016/04/jamur.jpg?w=652&h=336");
        nama.add("jamur mendoan");
        harga.add("Rp. 11.000");
        noHp.add("6282119753973");

        gambarUrl.add("https://breaktime.co.id/content/media/internet.jpg");
        nama.add("mie kornet enak");
        harga.add("Rp. 17.000");
        noHp.add("6282119753973");


        gambarUrl.add("http://www.tentik.com/wp-content/uploads/2018/11/history-of-indonesian-food-10.jpg");
        nama.add("sop majalengka");
        harga.add("Rp. 24.000");
        noHp.add("6281225462131");


        gambarUrl.add("https://scontent-ort2-2.cdninstagram.com/vp/4390e6eea729d3be3a3ddb7bc6bad129/5C2AB200/t51.2885-15/sh0.08/e35/c129.0.774.774/s640x640/32419729_532744767121590_417688661912453120_n.jpg");
        nama.add("nasi goreng aja");
        harga.add("Rp. 11.000");
        noHp.add("6281225462131");

        gambarUrl.add("https://s3-ap-southeast-1.amazonaws.com/traveloka/imageResource/2018/05/07/1525665660821-b0fb4336c5be209e08195fa9069c617b.jpeg");
        nama.add("sate maranggi nyos");
        harga.add("Rp. 25.000");
        noHp.add("6281225462131");

        gambarUrl.add("https://alibaba.kumpar.com/kumpar/image/upload/c_fill,g_face,f_jpg,q_auto,fl_progressive,fl_lossy,w_800/1_bsg7ex.jpg");
        nama.add("mie goreng uhuy");
        harga.add("Rp. 21.000");
        noHp.add("6281225462131");

    }

    public void toWhatsApp(Context context, String pesanan){
        Intent sendIntent = new Intent();
        sendIntent.setData(Uri.parse(pesanan));
        context.startActivity(sendIntent);
    }

}
