package com.example.john.a2clickparking;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    /*Действие при нажатии на кнопку*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        /*Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();*/

        /*Объявляем кнопку входа, логин и пароль*/
        View buttonEnter = findViewById(R.id.buttonEnter);
        final EditText userLogin = findViewById(R.id.editTextLogin);
        final EditText userPassword = findViewById(R.id.editTextPassword);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*!!!ПОКА НИКУДА НЕ ПЕРЕДАЮ!!!*/
                String login = userLogin.getText().toString();
                String password = userPassword.getText().toString();

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra(MainActivity.EXTRA_KEY_LOGIN, login);
                intent.putExtra(MainActivity.EXTRA_KEY_PASSWORD, password);
                startActivity(intent);
                finish();
            }
        };
        buttonEnter.setOnClickListener(clickListener);
    }
}