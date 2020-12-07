package com.bibliotekUser.ui.LoginRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bibliotekUser.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private EditText et_password, et_nama, et_email;
    private Button back, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initiate firebaseauthentication
        firebaseAuth = FirebaseAuth.getInstance();

        et_email = findViewById(R.id.email_input);
        et_password = findViewById(R.id.password_input);
        et_nama = findViewById(R.id.nama_input);

        back = findViewById(R.id.btn_back);
        submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_nama.getText().toString().equals("")
                        && !et_password.getText().toString().equals("")
                        && !et_email.getText().toString().equals("")) {

                    final ProgressDialog progressDialog;

                    progressDialog = new ProgressDialog(RegisterActivity.this);
                    progressDialog.setMessage("loading....");
                    progressDialog.setTitle("Harap menunggu");
                    progressDialog.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();

                    //register to firebase
                    firebaseAuth.createUserWithEmailAndPassword(et_email.getText().toString(), et_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(et_nama.getText().toString())
                                        .build();

                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    final FirebaseUser user = firebaseAuth.getCurrentUser();
                                                    user.sendEmailVerification()
                                                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener() {
                                                                @Override
                                                                public void onComplete(@NonNull Task task) {

                                                                    if (task.isSuccessful()) {
                                                                        et_email.setText("");
                                                                        et_password.setText("");
                                                                        et_nama.setText("");
                                                                        progressDialog.dismiss();
                                                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                                                        finish();
                                                                    }
                                                                }
                                                            });
                                                }
                                            }
                                        });

                            }
                            else if (!(Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches()))
                                Toast.makeText(RegisterActivity.this, "Salah Format Email!", Toast.LENGTH_SHORT).show();
                            else if(et_password.getText().toString().length()<6)
                                Toast.makeText(RegisterActivity.this, "Jumlah karakter password harus lebih dari 6!", Toast.LENGTH_SHORT).show();
                            else {
                                Toast.makeText(RegisterActivity.this, "Regristrasi Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    if(et_email.getText().toString().equals(""))
                        Toast.makeText(RegisterActivity.this, "Email masih kosong!", Toast.LENGTH_SHORT).show();
                    else if (!(Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches()))
                        Toast.makeText(RegisterActivity.this, "Salah Format Email!", Toast.LENGTH_SHORT).show();
                    else if(et_password.getText().toString().equals(""))
                        Toast.makeText(RegisterActivity.this, "Password masih kosong!", Toast.LENGTH_SHORT).show();
                    else if(et_password.getText().toString().length()<6)
                        Toast.makeText(RegisterActivity.this, "Jumlah karakter password harus lebih dari 6!", Toast.LENGTH_SHORT).show();
                    else if(et_nama.getText().toString().equals(""))
                        Toast.makeText(RegisterActivity.this, "Nama Lengkap masih kosong!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(RegisterActivity.this, "Regristrasi Gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

}