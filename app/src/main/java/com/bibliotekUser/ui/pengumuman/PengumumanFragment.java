package com.bibliotekUser.ui.pengumuman;

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
import com.bibliotekUser.adapter.PengumumanRecycleViewAdapter;
import com.bibliotekUser.api.pengumumanAPI;
import com.bibliotekUser.databinding.FragmentPengumumanBinding;
import com.bibliotekUser.model.Pengumuman;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.Request.Method.GET;

public class PengumumanFragment extends Fragment {

    PengumumanRecycleViewAdapter adapter;
    List<Pengumuman> listPengumuman = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;

    FragmentPengumumanBinding binding;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pengumuman, container, false);
        view = binding.getRoot();

        getPengumuman();

        adapter = new PengumumanRecycleViewAdapter(inflater.getContext(), listPengumuman);
        mLayoutManager = new LinearLayoutManager(getActivity());
        binding.pengumumanRv.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        binding.pengumumanRv.setHasFixedSize(true);
        binding.setData(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });
    }

    public void getPengumuman() {
        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(view.getContext());
        progressDialog.setMessage("loading....");
        progressDialog.setTitle("Menampilkan data pengumuman");
        progressDialog.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        final JsonObjectRequest stringRequest = new JsonObjectRequest(GET, pengumumanAPI.URL_INDEX
                , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    if(!listPengumuman.isEmpty())
                        listPengumuman.clear();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                        String id                   = jsonObject.optString("id");
                        String judul                = jsonObject.optString("judul");
                        String deskripsi            = jsonObject.optString("deskripsi");

                        Pengumuman pengumuman = new Pengumuman(judul, deskripsi);
                        listPengumuman.add(pengumuman);
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