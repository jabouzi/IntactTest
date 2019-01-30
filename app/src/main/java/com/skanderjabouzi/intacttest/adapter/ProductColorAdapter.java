package com.skanderjabouzi.intacttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.model.ProductColor;
import com.skanderjabouzi.intacttest.viewholder.ProductColorViewHolder;

import java.util.List;

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorViewHolder> {
    private List<ProductColor> productColors;
    private LayoutInflater mInflater;
    private Context context;

    public ProductColorAdapter(Context context, List<ProductColor> data) {
        this.mInflater = LayoutInflater.from(context);
        this.productColors = data;
        this.context = context;
    }

    @Override
    public ProductColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_color_card, parent, false);
        return new ProductColorViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final ProductColorViewHolder holder, final int position) {
        ProductColor color = productColors.get(position);
        holder.setProductColor(color.getColorCode());
    }

    @Override
    public int getItemCount() {
        return productColors.size();
    }

    public ProductColor getItem(int position) {
        return productColors.get(position);
    }

}
