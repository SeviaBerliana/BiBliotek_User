package com.bibliotekUser.UnitTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bibliotekUser.R;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private Button btnSubmit;
    private EditText edtEmail, edtPassword, edtNama;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSubmit = findViewById(R.id.btn_submit);
        edtEmail = findViewById(R.id.email_input);
        edtPassword = findViewById(R.id.password_input);
        edtNama = findViewById(R.id.nama_input);

        presenter = new RegisterPresenter(this, new RegisterService());
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRegisterClicked();
            }
        });
    }

    @Override
    public String getEmail() {
        return edtEmail.getText().toString();
    }

    @Override
    public void showEmailError(String message) {
        edtEmail.setError(message);
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public void showPasswordError(String message) {
        edtPassword.setError(message);
    }

    @Override
    public String getNama() {
        return edtNama.getText().toString();
    }
    @Override
    public void showNamaError(String message) {
        edtNama.setError(message);
    }

    @Override
    public void startLoginActivity() {
        new ActivityUtil(this).startLoginActivity();
    }
}
