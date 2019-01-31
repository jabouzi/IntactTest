package com.skanderjabouzi.intacttest.ui.main;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.adapter.ProductColorAdapter;
import com.skanderjabouzi.intacttest.databinding.ActivityProductDetailBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.skanderjabouzi.intacttest.app.CatalogApp.getContext;


public class ProductDetailActivity extends AppCompatActivity implements ProductDetailView {

    ActivityProductDetailBinding binding;
    ProductDetailPresenter presenter;
    ProductColorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        presenter = new ProductDetailPresenter();
        presenter.setProductDetailView(this, getContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showProductImage(String imageString) {
        try {
            InputStream inputStream = this.getAssets().open(imageString + ".jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            binding.productImage.setImageDrawable(drawable);

        } catch (IOException e) {
           Log.e("ProductDetailActivity", e.getLocalizedMessage());
        }
    }

    @Override
    public void showProductTitle(String title) {
        binding.myToolbarText.setText(title);
    }

    @Override
    public void showProductDescription(String description) {
        binding.productDetails.productDescription.setText(description);
    }

    @Override
    public void showProductPrice(String price) {
        binding.productDetails.productPrice.setText(price);
    }

    @Override
    public void showProductColorAttributes(ProductColorAdapter adapter) {
        this.adapter = adapter;
        binding.productDetails.productColors.setAdapter(this.adapter);
    }

    @Override
    public void showProductSizeAttributes(String sizes) {
        binding.productDetails.productDimensions.setText(sizes);
    }

    @Override
    public void setProductRate(List<Integer> rates) {
        for (int i = 0; i < rates.size(); i++) {
            String buttonID = "star" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            AppCompatButton button = findViewById(resID);
            button.setBackgroundResource(rates.get(i));
        }
    }

    @Override
    public void addToWishList(int color, int text) {
        binding.productDetails.add2WishLit.setBackgroundResource(color);
        binding.productDetails.add2WishLit.setText(text);
    }

    public void onStarClicked(View view) {
        Button button = (Button) view;
        String tag = button.getTag().toString();
        presenter.starClicked(Integer.valueOf(tag));
    }

    public void onToggleWishList(View view) {
        presenter.toggleWishList();
    }
}
