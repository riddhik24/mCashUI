package com.example.mcashui.ui.redeem;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcashui.R;
import com.example.mcashui.databinding.FragmentGalleryBinding;
import com.example.mcashui.databinding.FragmentRedeemBinding;
import com.example.mcashui.ui.gallery.GalleryViewModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
public class redeem extends Fragment {

    private FragmentRedeemBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RedeemViewModel redeemViewModel =
                new ViewModelProvider(this).get(RedeemViewModel.class);

        binding = FragmentRedeemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRedeem;
        redeemViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}