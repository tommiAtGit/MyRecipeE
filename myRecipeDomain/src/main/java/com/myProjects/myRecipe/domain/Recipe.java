package com.myProjects.myRecipe.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue
    @Column(name="Recipe_ID")
    private long Id;
    @Column(name="Name")
    private String Name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RecipeItem> recipeItems = new ArrayList<RecipeItem>();
    //@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Meal_ID", nullable = false)
  //  private Meal meal;



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
