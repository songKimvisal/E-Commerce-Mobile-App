package com.example.loginregisterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;

    // Constructor
    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    // ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView saleBadge;
        public ImageView productImage;
        public ImageView favoriteIcon;
        public RatingBar ratingBar;
        public TextView reviewCount;
        public TextView productName;
        public TextView productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            saleBadge = itemView.findViewById(R.id.sale_badge);
            productImage = itemView.findViewById(R.id.product_image);
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            reviewCount = itemView.findViewById(R.id.review_count);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.saleBadge.setText(product.getSalePercentage());
        holder.productImage.setImageResource(product.getImageResId());
        holder.ratingBar.setRating(product.getRating());
        holder.reviewCount.setText("(" + product.getReviewCount() + ")");
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}