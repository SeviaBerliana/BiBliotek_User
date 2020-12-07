package com.bibliotekUser.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterPresenterTest {
    @Mock
    private RegisterView view;

    @Mock
    private RegisterService service;
    private RegisterPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new RegisterPresenter(view, service);
    }

    @Test
    public void shouldShowErrorMessageWhenEmailIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("");
        System.out.println("Test 1 --Email Kosong--");
        System.out.println("email : " + view.getEmail());
        presenter.onRegisterClicked();
        verify(view).showEmailError("Email Tidak Boleh Kosong");
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("arkinjulianto@gmail.com");
        System.out.println("Test 2 --Password Kosong--");
        System.out.println("email : " + view.getEmail());
        when(view.getPassword()).thenReturn("");
        System.out.println("password : " + view.getPassword());
        presenter.onRegisterClicked();
        verify(view).showPasswordError("Password Tidak Boleh Kosong");
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsLessThanSixChars() throws Exception {
        when(view.getEmail()).thenReturn("arkinjulianto@gmail.com");
        System.out.println("Test 3 --Password Kurang Dari 6 Karakter--");
        System.out.println("email : " + view.getEmail());
        when(view.getPassword()).thenReturn("123");
        System.out.println("password : " + view.getPassword());
        presenter.onRegisterClicked();
        verify(view).showPasswordError("Password Tidak Boleh Kurang Dari 6 Karakter");
    }

    @Test
    public void shouldShowErrorMessageWhenNameIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("arkinjulianto@gmail.com");
        System.out.println("Test 4 --Nama Kosong--");
        System.out.println("email : " + view.getEmail());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : " + view.getPassword());
        when(view.getNama()).thenReturn("");
        System.out.println("nama : " + view.getNama());
        presenter.onRegisterClicked();
        verify(view).showNamaError("Nama Tidak Boleh Kosong");
    }

    @Test
    public void shouldStartLoginActivityWhenInputsAreCorrect() throws Exception {
        when(view.getEmail()).thenReturn("arkinjulianto@gmail.com");
        System.out.println("Test 5 --Register Berhasil--");
        System.out.println("email : " + view.getEmail());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : " + view.getPassword());
        when(view.getNama()).thenReturn("arkin");
        System.out.println("nama : " + view.getNama());
        when(service.getValid(view, view.getEmail(), view.getPassword(), view.getNama())).thenReturn(true);
        System.out.println("Hasil : " + service.getValid(view, view.getEmail(), view.getPassword(), view.getNama()));
        presenter.onRegisterClicked();
    }
}