package com.example.recyclerview32;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView nameTextView = findViewById(R.id.detail_recipe_name);
        TextView fullTextTextView = findViewById(R.id.detail_recipe_full_text);
        ImageView imageView = findViewById(R.id.detail_recipe_image);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("recipe")) {
            Recipe recipe = (Recipe) intent.getSerializableExtra("recipe");
            if (recipe != null) {
                nameTextView.setText(recipe.getName());
                fullTextTextView.setText(recipe.getFullRecipe());
                imageView.setImageResource(recipe.getImageResourceId());
                setTitle(recipe.getName());
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
