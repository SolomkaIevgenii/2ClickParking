package com.example.john.a2clickparking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

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
                                .commit();

                        return true;

                    case R.id.scaner:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ScanerFragment())
                                .commit();
                        //Toast.makeText(MainActivity.this, "Раздел в разработке", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.warning:
                        Intent intent = new Intent(getBaseContext(), TicketActivity.class);
                        startActivity(intent);
                        return false;
                }
                return false;
            }
        });

    }
    public void checkPayment(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Номер авто: ");
        builder.setMessage("555");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
