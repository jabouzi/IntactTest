package com.skanderjabouzi.intacttest.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.skanderjabouzi.intacttest.databinding.CatalogCardBinding;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;

import java.io.IOException;
import java.io.InputStream;


public class WishLIstViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CatalogCardBinding binding;
    private RecyclerViewItemClickListener mClickListener;
    private Context context;

    public WishLIstViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        binding = CatalogCardBinding.bind(itemView);
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