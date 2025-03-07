package com.example.loginregisterapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private static final String TAG = "ImageAdapter";
    private final List<Integer> colorList; // List of color resource IDs

    public ImageAdapter(List<Integer> colorList) {
        this.colorList = colorList;
        Log.d(TAG, "ImageAdapter created with " + colorList.size() + " items");
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder called for position " + position);
        int colorResId = colorList.get(position);
        int color = ContextCompat.getColor(holder.imageView.getContext(), colorResId);
        holder.imageView.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        int count = colorList.size();
        Log.d(TAG, "getItemCount: " + count);
        return count;
    }

    // Made public to match the visibility requirements of RecyclerView.Adapter
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}