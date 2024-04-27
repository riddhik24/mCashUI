package com.example.mcashui.ui.bInvite;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcashui.R;
import com.example.mcashui.databinding.FragmentBInviteBinding;
import com.example.mcashui.databinding.FragmentGalleryBinding;
import com.example.mcashui.ui.gallery.GalleryViewModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
public class bInviteFragment extends Fragment {

    private FragmentBInviteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BInviteViewModel bInviteViewModel =
                new ViewModelProvider(this).get(BInviteViewModel.class);

        binding = FragmentBInviteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInvite;
        bInviteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}