package id.delyu.delivery_u.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.fragment.Minuman;
import id.delyu.delivery_u.fragment.Paket;

public class RvAdapterMakanan extends RecyclerView.Adapter<RvAdapterMakanan.ViewHolder> {

    private ArrayList<String> gambarMakanan;
    private ArrayList<String> namaPaket;
    private ArrayList<String> hargaPaket;
    private ArrayList<String> noTelp;
    private Context context;
    String pesanan;
    String nama;
    String harga, nomer,gambar;

    public RvAdapterMakanan(Context context, ArrayList<String> gambarMakanan,ArrayList<String> namaPaket,ArrayList<String> hargaPaket,
                          ArrayList<String> noTelp){
        this.gambarMakanan = gambarMakanan;
        this.namaPaket = namaPaket;
        this.hargaPaket = hargaPaket;
        this.noTelp = noTelp;
        this.context = context;
    }

    @NonNull
    @Override
    public RvAdapterMakanan.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paket_list,viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapterMakanan.ViewHolder viewHolder, int i) {
        Picasso.get()
                .load(gambarMakanan.get(i))
                .into(viewHolder.gambarPaket);

        viewHolder.namaPaket.setText(namaPaket.get(i));
        viewHolder.hargaPaket.setText(hargaPaket.get(i));

        pesanan = "https://api.whatsapp.com/send?phone="+noTelp.get(i)+"&text=%5B%20dipesan%20via%20Delivery-U%20%5D%0A%0APesen "+namaPaket.get(i);
        nama = namaPaket.get(i);
        harga = hargaPaket.get(i);
        nomer = noTelp.get(i);
        gambar = gambarMakanan.get(i);
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new Minuman().toWhatsApp(context, pesanan);
                new Paket().sendMessage(context, nama,harga,nomer,gambar);

            }
        });
    }

    @Override
    public int getItemCount() {
        return namaPaket.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView gambarPaket;
        private TextView namaPaket, hargaPaket;
        private CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            gambarPaket = itemView.findViewById(R.id.gambarPaket);
            namaPaket = itemView.findViewById(R.id.namaPaket);
            hargaPaket = itemView.findViewById(R.id.hargaPaket);

        }
    }


}
