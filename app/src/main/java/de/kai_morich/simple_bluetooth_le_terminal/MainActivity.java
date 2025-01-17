package de.kai_morich.simple_bluetooth_le_terminal;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private Button btn_connect;
    private Button btn_disconnect;
    private Button btn_auto;
    private Button btn_open;
    private Button btn_close;
    private Button btn_eng;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        btn_connect = findViewById(R.id.btn_connect);
        btn_disconnect = findViewById(R.id.btn_disconnect);
        btn_auto = findViewById(R.id.btn_auto);
        btn_open = findViewById(R.id.btn_open);
        btn_close = findViewById(R.id.btn_close);
        btn_eng = findViewById(R.id.btn_eng);

        setSupportActionBar(toolbar);
        // 액션바 타이틀 숨기기
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (savedInstanceState == null)
            //getSupportFragmentManager().beginTransaction().add(R.id.fragment, new DevicesFragment(), "devices").commit();
            ;
        else
            onBackStackChanged();

        btn_connect.setOnClickListener(v -> {
            btn_connect.setVisibility(INVISIBLE);
            btn_disconnect.setVisibility(INVISIBLE);
            btn_auto.setVisibility(INVISIBLE);
            btn_open.setVisibility(INVISIBLE);
            btn_close.setVisibility(INVISIBLE);
            btn_eng.setVisibility(INVISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new DevicesFragment(), "devices").commit();
        });


        btn_auto.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Auto", Toast.LENGTH_SHORT).show();

        });

        // 하단 네비게이션 바 설정
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                Toast.makeText(MainActivity.this, "홈", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_dashboard) {
                Toast.makeText(MainActivity.this, "대시보드", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_notifications) {
                Toast.makeText(MainActivity.this, "알림", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount()>0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
