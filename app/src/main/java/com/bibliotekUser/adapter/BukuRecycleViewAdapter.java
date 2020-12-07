package com.bibliotekUser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibliotekUser.databinding.ItemBukuBinding;
import com.bibliotekUser.model.Buku;

import java.util.List;

public class BukuRecycleViewAdapter extends RecyclerView.Adapter<BukuRecycleViewAdapter.BukuViewHolder> {
    private Context context;
    private List<Buku> listBuku;

    public BukuRecycleViewAdapter(Context context, List<Buku> userList) {
        this.context = context;
        this.listBuku = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BukuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemBukuBinding binding = ItemBukuBinding.inflate(layoutInflater,
                parent, false);

        return new BukuRecycleViewAdapter.BukuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuViewHolder holder, int position) {
        Buku buku = listBuku.get(position);
        holder.myBinding(buku);
    }

    @Override
    public int getItemCount() {
        return listBuku.size();
    }


    public class BukuViewHolder extends RecyclerView.ViewHolder {
        ItemBukuBinding binding;

        public BukuViewHolder(@NonNull ItemBukuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void myBinding(Buku buku) {
            binding.setBuku(buku);
            binding.executePendingBindings();
        }
    }
}
