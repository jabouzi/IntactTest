package com.skanderjabouzi.intacttest.ui.catalog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.adapter.CatalogListAdapter;
import com.skanderjabouzi.intacttest.app.CatalogApp;
import com.skanderjabouzi.intacttest.databinding.FragmentCatalogBinding;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;
import com.skanderjabouzi.intacttest.model.Products;

import java.io.IOException;
import java.io.InputStream;


public class CatalogFragment extends Fragment implements CatalogView, RecyclerViewItemClickListener {


    CatalogListAdapter adapter;
    FragmentCatalogBinding binding;
    CatalogPresenter catalogPresenter;

    public CatalogFragment() {
//        catalogPresenter = new CatalogPresenter(this, getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding = FragmentCatalogBinding.inflate(getLayoutInflater());
        getActivity().setContentView(binding.getRoot());
        catalogPresenter = new CatalogPresenter(this, getContext());
        catalogPresenter.setCatalog();
    }

    @Override
    public void setupRecyclerView() {
//        binding.catalogRV.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setupAdapter(CatalogListAdapter adapter) {
        this.adapter = adapter;
        binding.catalogRV.setAdapter(this.adapter);
        this.adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e("PRODUCT", String.valueOf(position));
    }
}
