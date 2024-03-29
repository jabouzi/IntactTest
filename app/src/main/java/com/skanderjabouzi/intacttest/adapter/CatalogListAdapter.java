package com.skanderjabouzi.intacttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;
import com.skanderjabouzi.intacttest.model.Product;
import com.skanderjabouzi.intacttest.viewholder.CatalogViewHolder;

import java.util.List;


public class CatalogListAdapter extends RecyclerView.Adapter<CatalogViewHolder> {
    private List<Product> products;
    private LayoutInflater mInflater;
    private RecyclerViewItemClickListener mClickListener;
    private Context context;

    public CatalogListAdapter(Context context, List<Product> data) {
        this.mInflater = LayoutInflater.from(context);
        this.products = data;
        this.context = context;
    }

    @Override
    public CatalogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.catalog_card, parent, false);
        return new CatalogViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final CatalogViewHolder holder, final int position) {
        Product product = products.get(position);
        holder.setProductImage("img"+product.getId());
        holder.setProductTitle(product.getProductName());
        holder.setClickListener(mClickListener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public Product getItem(int position) {
        return products.get(position);
    }

    public void setClickListener(RecyclerViewItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}