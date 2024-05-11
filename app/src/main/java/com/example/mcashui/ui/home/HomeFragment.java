package com.example.mcashui.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcashui.R;
import com.example.mcashui.databinding.FragmentHomeBinding;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    public HomeFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<HomeItems> homeItemList = generateHomeItems();
        RecyclerView homeRecyclerView = binding.homeRecyclerView;
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(homeItemList);
        homeRecyclerView.setAdapter(homeRecyclerAdapter);
        return root;
    }
    private List<HomeItems> generateHomeItems(){
        List<HomeItems> Homeitems= new ArrayList<>();

        Homeitems.add(new HomeItems(R.drawable.baseline_checklist_24,"Task Reward","Complete tasks to get \ncoins!"));
        Homeitems.add(new HomeItems(R.drawable.baseline_flash_on_24,"Buzz Offers","Complete buzz offers get \ncoins!"));
        Homeitems.add(new HomeItems(R.drawable.baseline_local_offer_24,"Limited Offer","Complete offers to get \ncoins!"));


        return Homeitems;
    }
}