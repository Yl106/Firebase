package com.yq.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Bundle parametros = getIntent().getExtras();
        String nombre     = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono   = parametros.getString(getResources().getString(R.string.ptelefono));
        String email      = parametros.getString(getResources().getString(R.string.pemail));

        tvNombre = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }
    public void  llamar (View v){
        //Implicit
        String telefono = tvTelefono.getText().toString();
        int permisot = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permisot == PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " +telefono)));
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            }
        }

    }

    public void  enviarMail (View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }

    public boolean onKeyDown (int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}