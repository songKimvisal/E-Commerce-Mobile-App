package com.example.loginregisterapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private static final String TAG = "ProductAdapter";
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
        Log.d(TAG, "ProductAdapter initialized with " + products.size() + " products");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.titleTextView.setText(product.getName());
        holder.priceTextView.setText(product.getPrice());
        holder.ratingTextView.setText(String.valueOf(product.getRating()));
        holder.reviewCountTextView.setText("(" + product.getReviewCount() + ")");
        holder.salePercentageTextView.setText(product.getSalePercentage());
        holder.productImage.setImageResource(product.getImageResId());
        Log.d(TAG, "Bound product: " + product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView priceTextView;
        public TextView ratingTextView;
        public TextView reviewCountTextView;
        public TextView salePercentageTextView;
        public ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.productTitle);
            priceTextView = itemView.findViewById(R.id.productPrice);
            ratingTextView = itemView.findViewById(R.id.productRating);
            reviewCountTextView = itemView.findViewById(R.id.productReviewCount);
            salePercentageTextView = itemView.findViewById(R.id.productSalePercentage);
            productImage = itemView.findViewById(R.id.productImage);

            if (titleTextView == null || priceTextView == null || ratingTextView == null ||
                    reviewCountTextView == null || salePercentageTextView == null || productImage == null) {
                Log.e("ProductAdapter", "One or more views in ViewHolder are null");
            }
        }
    }
}