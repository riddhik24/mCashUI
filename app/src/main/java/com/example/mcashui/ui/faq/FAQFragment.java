package com.example.mcashui.ui.faq;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mcashui.R;
import com.example.mcashui.databinding.FragmentFAQBinding;
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
public class FAQFragment extends Fragment {

    private FAQViewModel mViewModel;

    private FragmentFAQBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FAQViewModel faqViewModel =
                new ViewModelProvider(this).get(FAQViewModel.class);

        binding = FragmentFAQBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFaq;
        faqViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}