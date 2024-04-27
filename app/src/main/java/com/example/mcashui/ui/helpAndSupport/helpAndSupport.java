package com.example.mcashui.ui.helpAndSupport;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcashui.R;
import com.example.mcashui.databinding.FragmentGalleryBinding;
import com.example.mcashui.databinding.FragmentHelpAndSupportBinding;
import com.example.mcashui.ui.gallery.GalleryViewModel;

public class helpAndSupport extends Fragment {
    private FragmentHelpAndSupportBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HelpAndSupportViewModel helpAndSupportViewModel =
                new ViewModelProvider(this).get(HelpAndSupportViewModel.class);

        binding = FragmentHelpAndSupportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHelpAndSupport;
        helpAndSupportViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}