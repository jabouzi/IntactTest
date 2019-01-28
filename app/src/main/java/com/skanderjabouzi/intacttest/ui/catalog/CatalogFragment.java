package com.skanderjabouzi.intacttest.ui.catalog;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.adapter.CatalogListAdapter;
import com.skanderjabouzi.intacttest.databinding.FragmentCatalogBinding;
import com.skanderjabouzi.intacttest.event.CatalogEvents;
import com.skanderjabouzi.intacttest.event.GlobalBus;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;
import com.skanderjabouzi.intacttest.ui.main.ProductDetailActivity;

public class CatalogFragment extends Fragment implements CatalogView, RecyclerViewItemClickListener {

    CatalogListAdapter adapter;
    FragmentCatalogBinding binding;
    CatalogPresenter catalogPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_catalog, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        catalogPresenter = new CatalogPresenter(this, getContext());
        catalogPresenter.setCatalog();
    }

    @Override
    public void setupAdapter(CatalogListAdapter adapter) {
        this.adapter = adapter;
        binding.catalogRV.setAdapter(this.adapter);
        this.adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        GlobalBus.getBus().postSticky(new CatalogEvents.ProductEvent("ShowProductDetail", this.adapter.getItem(position)));
        Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
        getActivity().startActivity(intent);
    }
}
