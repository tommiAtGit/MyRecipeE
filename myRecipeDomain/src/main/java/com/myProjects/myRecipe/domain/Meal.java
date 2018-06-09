package com.myProjects.myRecipe.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by osboxes on 21/05/17.
 */
@Entity
@Table(name="Meal")
public class Meal implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Meal_ID",unique = true, nullable = false)
    private long Id;
    @Column(name="Name")
    private String Name;
    @Column(name="Recipe")
    @OneToMany(mappedBy = "meal")
    private List<Recipe> recipes = new ArrayList<Recipe>();
    @Column(name="Quantity")
    private int quantity;
    @Column(name="TimeStamp")
    private Date timeStamp;


    public Meal(){
        
    }
    
    public long getId() {
        return Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }
    
    public String getName() {
	return Name;
    }
    public void setName(String name) {
	Name = name;
    }
    
    public List<Recipe> getRecipe() {
	return recipes;
    }
    public void setRecipe(List<Recipe> recipes) {
	this.recipes = recipes;
    }
    
    public int getQuantity() {
	return quantity;
    }
    public void setQuatity(int quatity) {
	this.quantity = quatity;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
