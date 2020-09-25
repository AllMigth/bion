package com.simulador.bin.tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    Button callSignUp, forgetPassword;
    ImageView imageView;
    TextView logoText, logoName, sloganText;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //Hooks
        callSignUp = findViewById(R.id.nuevoUsuario);
        imageView = findViewById(R.id.logo_image);
        logoName = findViewById(R.id.logo_name);
        logoText = findViewById(R.id.logo_desc);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgetPassword = findViewById(R.id.restorePassWordBtn);

        callSignUp = findViewById(R.id.nuevoUsuario);


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);

                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(imageView, "logo_image");
                pairs[1] = new Pair<View, String>(logoName, "logo_texto");
                pairs[2] = new Pair<View, String>(logoText, "logo_desc");
                pairs[3] = new Pair<View, String>(username, "username_tran");
                pairs[4] = new Pair<View, String>(password, "password_tran");
                pairs[5] = new Pair<View, String>(forgetPassword, "button_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}