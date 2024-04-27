package com.example.mcashui.ui.inviteAFriend;

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
import com.example.mcashui.databinding.FragmentHelpAndSupportBinding;
import com.example.mcashui.databinding.FragmentInviteFriendBinding;
import com.example.mcashui.ui.gallery.GalleryViewModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
public class inviteFriend extends Fragment {

    private InviteFriendViewModel mViewModel;

    private FragmentInviteFriendBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InviteFriendViewModel inviteFriendViewModel =
                new ViewModelProvider(this).get(InviteFriendViewModel.class);

        binding = FragmentInviteFriendBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInviteFriend;
        inviteFriendViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}