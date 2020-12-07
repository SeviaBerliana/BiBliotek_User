package com.bibliotekUser.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bibliotekUser.api.bukuAPI;
import com.bumptech.glide.Glide;

public class Buku {
    public String imgURL;
    private String judul;
    private String pengarang;
    private String penerbit;

    public Buku(String imgURL, String judul, String pengarang, String penerbit) {
        this.imgURL = imgURL;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(bukuAPI.URL_IMAGE + imageUrl)
                .into(view);
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
