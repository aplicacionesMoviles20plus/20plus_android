package com.example.anthony.a20;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button btn_Send = findViewById(R.id.continuar);
        final EditText email = findViewById(R.id.email);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert= new AlertDialog.Builder(ForgotPasswordActivity.this);
                alert.setMessage("Contraseña enviada al correo"+email.getText().toString() );
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(a);
                    }
                });
                alert.setTitle("Alerta");
                AlertDialog dialog =alert.create();
                dialog.show();

            }
        });

    }


}
