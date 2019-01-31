package com.skanderjabouzi.intacttest.ui.wishlist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.adapter.WishListAdapter;
import com.skanderjabouzi.intacttest.databinding.FragmentWishListBinding;
import com.skanderjabouzi.intacttest.event.CatalogEvents;
import com.skanderjabouzi.intacttest.event.GlobalBus;
import com.skanderjabouzi.intacttest.helper.DecoratorHelper;
import com.skanderjabouzi.intacttest.helper.RecyclerViewItemClickListener;
import com.skanderjabouzi.intacttest.ui.main.CartDialogFragment;
import com.skanderjabouzi.intacttest.ui.main.ProductDetailActivity;

public class WishListFragment extends Fragment implements WishListView, RecyclerViewItemClickListener, View.OnClickListener {

    WishListAdapter adapter;
    FragmentWishListBinding binding;
    WishListPresenter wishListPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_wish_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.goToCart.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        wishListPresenter = new WishListPresenter(this, getContext());
        wishListPresenter.setWishListView();
    }

    @Override
    public void setWishListViewEmpty() {
        binding.wishListEmpty.setVisibility(View.VISIBLE);
        binding.wishList.setVisibility(View.GONE);
    }

    @Override
    public void setWishListViewNotEmpty() {
        binding.wishListEmpty.setVisibility(View.GONE);
        binding.wishList.setVisibility(View.VISIBLE);
    }

    @Override
    public void setWishListTotal(Double sum) {
        binding.wishListTotal.setText(getString(R.string.wishlist_total, DecoratorHelper.formatCurrency(sum)));
        binding.wishListSubTotal.setText(getString(R.string.wishlist_subtotal, DecoratorHelper.formatCurrency(sum)));
    }

    @Override
    public void setupAdapter(WishListAdapter adapter) {
        this.adapter = adapter;
        binding.wishlistRV.setAdapter(this.adapter);
        this.adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        GlobalBus.getBus().postSticky(new CatalogEvents.ProductEvent("ShowProductDetail", this.adapter.getItem(position)));
        Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
        getActivity().startActivity(intent);
    }

    public void onGoToCart() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        CartDialogFragment editNameDialogFragment = CartDialogFragment.newInstance("");
        editNameDialogFragment.show(fm, "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goToCart:
                onGoToCart();
            break;
        }
    }
}
