package id.delyu.delivery_u.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.adapter.LandingAdapter;
import id.delyu.delivery_u.fragment.Makanan;
import id.delyu.delivery_u.fragment.Minuman;
import id.delyu.delivery_u.fragment.Paket;

public class LandingActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        tabLayout = (TabLayout)findViewById(R.id.tablayoutid);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpagerid);

        LandingAdapter adapter = new LandingAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Paket(), "Paket");
        adapter.AddFragment(new Makanan(), "Makanan");
        adapter.AddFragment(new Minuman(), "Minuman");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    public void toWhatsApp(){
        //PackageManager pm = getApplicationContext().getPackageManager();
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
           // PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            sendIntent.setPackage("com.whatsapp");
           // sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Share with"));


    }
}
