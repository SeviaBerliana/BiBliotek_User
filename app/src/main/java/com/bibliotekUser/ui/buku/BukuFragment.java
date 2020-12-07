package com.bibliotekUser.ui.buku;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bibliotekUser.R;
import com.bibliotekUser.adapter.BukuRecycleViewAdapter;
import com.bibliotekUser.api.bukuAPI;
import com.bibliotekUser.databinding.FragmentBukuBinding;
import com.bibliotekUser.model.Buku;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.Request.Method.GET;

public class BukuFragment extends Fragment {

    BukuRecycleViewAdapter adapter;
    List<Buku> bukuList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;

    FragmentBukuBinding binding;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buku, container, false);
        view = binding.getRoot();

        getBuku();

        adapter = new BukuRecycleViewAdapter(inflater.getContext(), bukuList);
        mLayoutManager = new LinearLayoutManager(getActivity());
        binding.bukuRv.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        binding.bukuRv.setHasFixedSize(true);
        binding.setData(adapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });
    }

    public void getBuku() {
        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(view.getContext());
        progressDialog.setMessage("loading....");
        progressDialog.setTitle("Menampilkan data buku");
        progressDialog.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        final JsonObjectRequest stringRequest = new JsonObjectRequest(GET, bukuAPI.URL_INDEX
                , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    if(!bukuList.isEmpty())
                        bukuList.clear();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                        String judul                = jsonObject.optString("judul");
                        String pengarang            = jsonObject.optString("pengarang");
                        String gambar               = jsonObject.optString("gambar");
                        String penerbit             = jsonObject.optString("penerbit");

                        if (gambar.equalsIgnoreCase("null")) {
                            gambar = "no-image.png";
                        }

                        Buku buku = new Buku(gambar, judul, pengarang, penerbit);
                        bukuList.add(buku);
                    }
                    adapter.notifyDataSetChanged();
                }catch (JSONException e){
                    e.printStackTrace();
                }

                Toast.makeText(view.getContext(), response.optString("message"), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(view.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }
}