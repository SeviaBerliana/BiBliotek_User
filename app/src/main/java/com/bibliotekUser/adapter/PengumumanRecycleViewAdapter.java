package com.bibliotekUser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibliotekUser.databinding.ItemPengumumanBinding;
import com.bibliotekUser.model.Pengumuman;

import java.util.List;

public class PengumumanRecycleViewAdapter extends RecyclerView.Adapter<PengumumanRecycleViewAdapter.PengumumanViewHolder> {
    private Context context;
    private List<Pengumuman> pengumumanList;

    public PengumumanRecycleViewAdapter(Context context, List<Pengumuman> result) {
        this.context = context;
        this.pengumumanList = result;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PengumumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemPengumumanBinding binding = ItemPengumumanBinding.inflate(layoutInflater,
                parent, false);

        return new PengumumanRecycleViewAdapter.PengumumanViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PengumumanViewHolder holder, int position) {
        Pengumuman pengumuman = pengumumanList.get(position);
        holder.myBinding(pengumuman);
    }

    @Override
    public int getItemCount() {
        return pengumumanList.size();
    }


    public class PengumumanViewHolder extends RecyclerView.ViewHolder{
        ItemPengumumanBinding binding;

        public PengumumanViewHolder(@NonNull ItemPengumumanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void myBinding(Pengumuman pengumuman) {
            binding.setPengumuman(pengumuman);
            binding.executePendingBindings();
        }
    }
}
