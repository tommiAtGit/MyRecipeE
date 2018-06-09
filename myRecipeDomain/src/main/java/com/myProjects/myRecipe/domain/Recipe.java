package com.myProjects.myRecipe.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by osboxes on 21/05/17.
 */

@Entity
@Table(name="Recipe")
public class Recipe implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Recipe_ID",unique = true, nullable = false)
    private long Id;
    @Column(name="Name")
    private String Name;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeItem> recipeItems = new ArrayList<RecipeItem>();
    @ManyToOne
    @JoinColumn(name = "MEAL_RECIPE", nullable = false)
    private Meal meal;



    public Recipe(){

    }


    public long getID() {
         return Id;
    }

    public void setID(long Id) {
            this.Id = Id;
    }
    
    public String getName() {
            return Name;
    }

    public void setName(String name) {
            Name = name;
    }
    
    public List<RecipeItem> getRecipeItems() {
            return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
            this.recipeItems = recipeItems;
    }
    
    /*public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }*/
    
}
