package com.example.loginregisterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ShopDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ShopDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SALE_PERCENTAGE = "salePercentage";
    private static final String COLUMN_IMAGE_RES_ID = "imageResId";
    private static final String COLUMN_RATING = "rating";
    private static final String COLUMN_REVIEW_COUNT = "reviewCount";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PRICE = "price";
    private static final String TAG = "ShopDatabaseHelper";

    public ShopDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Creating products table");
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_SALE_PERCENTAGE + " TEXT," +
                COLUMN_IMAGE_RES_ID + " INTEGER," +
                COLUMN_RATING + " REAL," +
                COLUMN_REVIEW_COUNT + " INTEGER," +
                COLUMN_NAME + " TEXT," +
                COLUMN_PRICE + " TEXT)";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        // Insert sample data
        insertSampleData(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        Log.d(TAG, "Inserting sample data");
        insertProduct(db, "-20%", R.drawable.tshirt, 4.5f, 10, "T-Shirt Spanish", "£25 £125");
        insertProduct(db, "-15%", R.drawable.blouse, 4.2f, 8, "Blouse", "£20 £80");
        insertProduct(db, "", R.drawable.dress, 4.0f, 5, "Dorothy Perkins Evening Dress", "£30 £150");
    }

    private void insertProduct(SQLiteDatabase db, String salePercentage, int imageResId, float rating,
                               int reviewCount, String name, String price) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALE_PERCENTAGE, salePercentage);
        values.put(COLUMN_IMAGE_RES_ID, imageResId);
        values.put(COLUMN_RATING, rating);
        values.put(COLUMN_REVIEW_COUNT, reviewCount);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        long result = db.insert(TABLE_PRODUCTS, null, values);
        Log.d(TAG, "Inserted product: " + name + ", result: " + result);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTS, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SALE_PERCENTAGE)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_RES_ID)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_RATING)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_REVIEW_COUNT)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PRICE))
                );
                products.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Log.d(TAG, "Retrieved " + products.size() + " products from database");
        return products;
    }
}