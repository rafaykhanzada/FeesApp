package com.example.fms.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fms.R;
import com.example.fms.ui.Std_Login;
import com.example.fms.ui.Std_dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_Login extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPassword;
    private ImageButton button;
    private TextView textView;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txtEmailLogin = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        button = (ImageButton) findViewById(R.id.btnLogin);
        textView=(TextView) findViewById(R.id.btnAdminLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(Admin_Login.this, "Please wait", "Processing", true);

                firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()) {
                                    Toast.makeText(Admin_Login.this, "Login successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Admin_Login.this, Std_dashboard.class);
                                    intent.putExtra("userid",firebaseAuth.getCurrentUser().getUid());
                                    startActivity(intent);

                                } else {
                                    Log.e("ERROR", task.getException().toString());
                                    Toast.makeText(Admin_Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }

                            }
                        });
            }
        });
    }
}