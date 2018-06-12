package com.myProjects.myRecipe.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by osboxes on 21/05/17.
 */
@Entity
@Table(name = "RecipeItem")
public class RecipeItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPEITEM_ID",unique = true, nullable = false)
    private long Id;
    @Column(name = "Quantity")
    private int quantity;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_RECIPE", nullable = true)
    private Recipe recipe;

    public RecipeItem() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

   
}
