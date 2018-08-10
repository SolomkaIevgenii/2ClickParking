package com.example.john.a2clickparking;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_LOGIN = "Логин";
    public static final String EXTRA_KEY_PASSWORD = "Пароль";

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);



        bottomNavigation.setItemIconTintList(ContextCompat.getColorStateList(this, R.color.app_navigation_colors));

        if (savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new KeyboardFragment())
                    .commit();
        }

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.kayboard:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new KeyboardFragment())
                                .addToBackStack(null)
                                .commit();

                        return true;

                    case R.id.scaner:
                        Toast.makeText(MainActivity.this, "Раздел в разработке", Toast.LENGTH_SHORT).show();
                        return false;
                }
                return false;
            }
        });
        findViewById(R.id.buttonRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
