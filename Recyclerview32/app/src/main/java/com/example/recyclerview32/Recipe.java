package com.example.recyclerview32;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String name;
    private String description;
    private String fullRecipe;
    private int imageResourceId;

    public Recipe(String name, String description, String fullRecipe, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.fullRecipe = fullRecipe;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFullRecipe() {
        return fullRecipe;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
