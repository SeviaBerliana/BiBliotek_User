package com.bibliotekUser.UnitTest;

public class RegisterPresenter {
    private RegisterView view;
    private RegisterService service;

    public RegisterPresenter(RegisterView view, RegisterService service) {
        this.view = view;
        this.service = service;
    }

    public void onRegisterClicked() {
        if (view.getEmail().isEmpty()) {
            view.showEmailError("Email Tidak Boleh Kosong");
            return;
        } else if (view.getPassword().isEmpty()) {
            view.showPasswordError("Password Tidak Boleh Kosong");
            return;
        } else if (view.getPassword().length() < 6) {
            view.showPasswordError("Password Tidak Boleh Kurang Dari 6 Karakter");
            return;
        } else if (view.getNama().isEmpty()) {
            view.showNamaError("Nama Tidak Boleh Kosong");
            return;
        } else {
            service.register(view, view.getEmail(), view.getPassword(), view.getNama());
            return;
        }
    }
}
