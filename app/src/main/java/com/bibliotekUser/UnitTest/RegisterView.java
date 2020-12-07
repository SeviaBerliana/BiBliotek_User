package com.bibliotekUser.UnitTest;

public interface RegisterView {
    String getEmail();
    String getPassword();
    String getNama();

    void showEmailError(String message);
    void showPasswordError(String message);
    void showNamaError(String message);

    void startLoginActivity();
}
