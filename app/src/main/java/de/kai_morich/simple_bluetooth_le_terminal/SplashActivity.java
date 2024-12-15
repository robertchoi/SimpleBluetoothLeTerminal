package de.kai_morich.simple_bluetooth_le_terminal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

public class SplashActivity extends AppCompatActivity {

    // 스플래시 화면이 표시되는 시간 (밀리초)
    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2초

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 스플래시 레이아웃 설정
        setContentView(R.layout.activity_splash);

        // 핸들러를 사용하여 일정 시간 후 메인 액티비티로 이동
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 메인 액티비티로 인텐트 생성
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // 스플래시 액티비티 종료
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
