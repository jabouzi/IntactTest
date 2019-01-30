package com.skanderjabouzi.intacttest.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.skanderjabouzi.intacttest.databinding.ProductColorCardBinding;

public class ProductColorViewHolder extends RecyclerView.ViewHolder {

    private ProductColorCardBinding binding;
    private Context context;

    public ProductColorViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        binding = ProductColorCardBinding.bind(itemView);
    }

    public void setProductColor(String color) {
        binding.productColor.setBackgroundColor(Color.parseColor(color));
    }
}
