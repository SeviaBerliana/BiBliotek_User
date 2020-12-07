package com.bibliotekUser.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.bibliotekUser.BR;

public class Pengumuman  extends BaseObservable {
    private String judul;
    private String deskripsi;

    public Pengumuman(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    @Bindable
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
        notifyPropertyChanged(BR.judul);
    }

    @Bindable
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        notifyPropertyChanged(BR.deskripsi);
    }
}
