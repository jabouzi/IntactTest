package com.skanderjabouzi.intacttest.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.DialogFragment;

import com.skanderjabouzi.intacttest.R;

public class CartDialogFragment extends DialogFragment {

    private Button cancelButton;
    private Button okButton;

    public static CartDialogFragment newInstance(String title) {
        CartDialogFragment frag = new CartDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container);

        cancelButton = view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        okButton = view.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);

        return view;
    }
}
