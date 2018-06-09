package com.myProjects.myRecipe.domain;

/**
 * Created by osboxes on 21/05/17.
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name="Ingredient")
public class Ingredient implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Ingredient_ID",unique = true, nullable = false)
    private long Id;
    @Column(name="Name")
    private String name;
    @Column(name="Manufacturer")
    private String manufacturer;
    @Column(name="Energy")
    private double energy;
    @Column(name="Protein")
    private double protein;
    @Column(name="Carbonhydrates")
    private double carbonHydrates;
    @Column(name="Fat")
    private double fat;
    @Column(name="Category")
    private String category;


    public Ingredient(){

    }
 
    public Ingredient(String Name,
                      String Manufacturer,
                      double Energy,
                      double Protein,
                      double CarbonHydrates,
                      double Fat){
        
        this.name = Name;
        this.manufacturer = Manufacturer;
        this.energy = Energy;
        this.protein = Protein;
        this.carbonHydrates = CarbonHydrates;
        this.fat = Fat;
    }

    public long getId() {
            return Id;
    }

    public void setId(long id) {
            Id = id;
    }
    
    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
    public String getManufacturer() {
            return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
    }
    
    public double getEnergy() {
            return energy;
    }

    public void setEnergy(double energy) {
            this.energy = energy;
    }
    
    
    public double getProtein() {
            return protein;
    }

    public void setProtein(double protein) {
            this.protein = protein;
    }
    
    public double getCarbonHydrates() {
            return carbonHydrates;
    }

    public void setCarbonHydrates(double carbonHydrates) {
            this.carbonHydrates = carbonHydrates;
    }

    public double getFat() {
            return fat;
    }

    public void setFat(double fat) {
            this.fat = fat;
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
