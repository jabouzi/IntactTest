package com.skanderjabouzi.intacttest.ui.main;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.databinding.ActivityProductDetailBinding;
import com.skanderjabouzi.intacttest.helper.CatalogHelper;
import com.skanderjabouzi.intacttest.helper.DecoratorHelper;

import java.io.IOException;
import java.io.InputStream;


public class ProductDetailActivity extends AppCompatActivity implements ProductDetailView{

    ActivityProductDetailBinding binding;
    ProductDetailPresenter presenter;

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
        presenter.setProductDetailView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.OnResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showProductImage(String imageString) {
        try {
            InputStream inputStream = this.getAssets().open(imageString+".jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            binding.productImage.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
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
    public void showProductPrice(Double price) {
        binding.productDetails.productPrice.setText(DecoratorHelper.formatCurrency(price));
    }

    @Override
    public void showProductColorAttributes() {

    }

    @Override
    public void showProductSizeAttributes() {

    }

    @Override
    public void setProductRate() {

    }

    @Override
    public void addToWishList() {

    }
}
