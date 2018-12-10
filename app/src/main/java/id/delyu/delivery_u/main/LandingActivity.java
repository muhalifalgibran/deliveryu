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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.zip.Inflater;

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

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tablayoutid);
       // appBarLayout = (AppBarLayout) findViewById(R.id.app);
        viewPager = (ViewPager) findViewById(R.id.viewpagerid);

        LandingAdapter adapter = new LandingAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Paket(), "Paket");
        adapter.AddFragment(new Makanan(), "Makanan");
        adapter.AddFragment(new Minuman(), "Minuman");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this, "Akun Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
