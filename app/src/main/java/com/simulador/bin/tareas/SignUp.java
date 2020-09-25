package com.simulador.bin.tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    Button backToLogin;
    TextInputLayout name, username, email, phoneNo, password;

/*    FirebaseDatabase rootNode;
    DatabaseReference reference;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backToLogin = findViewById(R.id.yaTienesCuenta);
        name = findViewById(R.id.nombreCompleto);
        username = findViewById(R.id.nombreDeUsuario);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.numeroTelefonico);
        password = findViewById(R.id.password);


        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private Boolean validateName(){
        String val = name.getEditText().getText().toString();
        if(val.isEmpty()){
            name.setError("El campo no puede estar vacio");
            return false;
        }else{
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateUserName(){
        String val = username.getEditText().getText().toString();
        String noWhiteSpace =  "\\A\\w{4,20}\\z";
        //"\\A\\w{4,20}\\z"
        //"(?=\\S+$)";
        if(val.isEmpty()){
            username.setError("El campo no puede estar vacio");
            return false;
        }else if (val.length()>=15){
            username.setError("Usuario demasiado largo");
            return false;
        }else if(!val.matches(noWhiteSpace)){
            username.setError("Espacios en blanco no son permitidos");
            return false;
        }else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val = email.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("El campo no puede estar vacio");
            return false;
        }else if(!val.matches(emailPattern)){
            email.setError("Direccion de correo invalida");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }
    private Boolean validatePhoneNo(){
        String val = phoneNo.getEditText().getText().toString();
        if(val.isEmpty()){
            phoneNo.setError("El campo no puede estar vacio");
            return false;
        }else{
            phoneNo.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();
        String passdowVal = "^" +
                //"(?=.*[0-9])" +       //at least 1 digit
                //"(?=.*[a-z])" +       //at least 1 lower case
                //"(?=.*[A-Z])" +       //at least 1 upper case letter
                "(?=.*[a-zA-z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)"+            //no white spaces
                ".{4,}"+                //at least 4 characters
                "$";

        if(val.isEmpty()){
            password.setError("El campo no puede estar vacio");
            return false;
        }else if(!val.matches(passdowVal)) {
            password.setError("Contraseña debil");
            return false;
        }
        else{
            password.setError(null);
            return true;
        }
    }

    public void registerUser(View view) {

        if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUserName()){
            return;
        }

        /*String name = name.getEditText().getText().toString();
        String username = nombreDeUsuario.getEditText().getText().toString();
        String phoneNo = numeroTelefonico.getEditText().getText().toString();
        String password = password.getEditText().getText().toString();
        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);*/
    }



}