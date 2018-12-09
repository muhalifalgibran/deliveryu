package id.delyu.delivery_u.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import id.delyu.delivery_u.R;
import id.delyu.delivery_u.adapter.LandingAdapter;
import id.delyu.delivery_u.database.M_deliveryU;
import id.delyu.delivery_u.database.Mahasiswa;

public class LoginAppActivity extends AppCompatActivity {

    private TextView username, password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);

        username = findViewById(R.id.usernameApp);
        password = findViewById(R.id.password);
        button   = findViewById(R.id.signInButApp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(),password.getText().toString());
            }
        });

    }

    public void login(String username, String password){
        M_deliveryU db = new M_deliveryU(this);
        Mahasiswa mhs = new Mahasiswa();

        mhs.setUsername(username);
        mhs.setPassword(password);

        if (db.login(mhs) == true){
            Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginAppActivity.this, LandingActivity.class));
        }else{
            Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
        }
    }
}
