package com.skanderjabouzi.intacttest.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.skanderjabouzi.intacttest.adapter.ProductColorAdapter;
import com.skanderjabouzi.intacttest.databinding.WishListCardBinding;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;

import java.io.IOException;
import java.io.InputStream;


public class WishLIstViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private WishListCardBinding binding;
    private RecyclerViewItemClickListener mClickListener;
    private Context context;

    public WishLIstViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        binding = WishListCardBinding.bind(itemView);
        itemView.setOnClickListener(this);
    }

    public void setProductImage(String imageString) {
        try {
            InputStream inputStream = context.getAssets().open(imageString+".jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            binding.productImage.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e("WishLIstViewHolder", e.getLocalizedMessage());
        }
    }

    public void setProductTitle(String productTitle) {
        binding.productTitle.setText(productTitle);
    }

    public void  setProductPrice(String productPrice) {
        binding.productPrice.setText(productPrice);
    }

    public void setProductDescription(String productDescription) {
        binding.productDescription.setText(productDescription);
    }

    public void setProductMaterial(String productMaterial) {
        binding.productMaterial.setText(productMaterial);
    }

    public void setProductOutOfStock() {
        binding.productOutOfStocks.setVisibility(View.VISIBLE);
        binding.productColors.setVisibility(View.GONE);
    }

    public void setProductColors(ProductColorAdapter adapter) {
        binding.productOutOfStocks.setVisibility(View.GONE);
        binding.productColors.setVisibility(View.VISIBLE);
        binding.productColors.setAdapter(adapter);
    }

    public ViewGroup getContainer() {
        return binding.listItemContainer;
    }

    public void setClickListener(RecyclerViewItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}