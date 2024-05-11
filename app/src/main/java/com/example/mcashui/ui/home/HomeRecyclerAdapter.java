package com.example.mcashui.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcashui.R;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private List<HomeItems> homeItemsList;

    public HomeRecyclerAdapter(List<HomeItems> homeItemsList) {
        this.homeItemsList = homeItemsList;
    }

    @NonNull
    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerAdapter.ViewHolder holder, int position) {
        if (homeItemsList == null || position >= homeItemsList.size()) {
            // Handle null list or out-of-bounds index
            return;
        }

        HomeItems homeItem = homeItemsList.get(position);
        try {
            holder.icons.setImageResource(homeItem.getIcons());  // Use getIconResource() for better naming
            holder.reward_text.setText(homeItem.getReward_text());
            holder.daily_text.setText(homeItem.getTask_text());
        } catch (NullPointerException e) {
            // Handle potential null fields within HomeItem object
            // You can log the error, display a placeholder, etc.
            e.printStackTrace();  // For debugging purposes
        }
    }

    @Override
    public int getItemCount() {
        return homeItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView reward_text;
        TextView daily_text;
        ImageView icons;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            reward_text = itemView.findViewById(R.id.reward_text);
            daily_text = itemView.findViewById(R.id.task_text);
            icons = itemView.findViewById(R.id.icons);
        }
    }
}
