package com.example.recyclerview32;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeList = new ArrayList<>();

        recipeList.add(new Recipe("Kale/Lemon Sandwiches", 
                "This sandwich is stunningly delicious and tastes as good as it is healthy.",
                "Ingredients:\nKale\nLemon\nBread\n\nProcedure:\n1. Wash Kale.\n2. Squeeze Lemon.\n3. Make Sandwich.", 
                R.drawable.kale_lemon_sandwiches));
        
        recipeList.add(new Recipe("Mango-Lime Bean Salad", 
                "Everyone loves this, so double or even triple the recipe!",
                "Ingredients:\nMango\nLime\nBeans\n\nProcedure:\n1. Dice Mango.\n2. Mix with beans.\n3. Add Lime juice.", 
                R.drawable.mango_lime_bean_salad));
        
        recipeList.add(new Recipe("Sweet Potato and Lentil Soup", 
                "This soup is so good Essy and I ate it ALL the first time I made it.",
                "Ingredients:\nSweet Potato\nLentils\nBroth\n\nProcedure:\n1. Boil broth.\n2. Add ingredients.\n3. Simmer.", 
                R.drawable.sweet_potatoand_lentil_soup));

        recipeList.add(new Recipe("Lime Mousse", 
                "This is FABULOUS alone, topped with fruit of any kind or as a frosting on cake.",
                "Ingredients:\nLime\nCream\nSugar\n\nProcedure:\n1. Whip cream.\n2. Add sugar and lime.\n3. Chill.", 
                R.drawable.lime_mousse));
        
        recipeList.add(new Recipe("Broiled Tilapia Parmesan", 
                "Flavorful recipe for this farm raised fish that is easy and done in minutes!",
                "Ingredients:\nTilapia\nParmesan\nButter\n\nProcedure:\n1. Season fish.\n2. Broil.\n3. Top with cheese.", 
                R.drawable.broiled_tiapia_parmesan));

        adapter = new RecipeAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);
    }
}
