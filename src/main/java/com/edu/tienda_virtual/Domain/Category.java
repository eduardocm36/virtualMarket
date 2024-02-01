package com.edu.tienda_virtual.Domain;

public class Category {

    private int idCategory;
    private String nameCategory;
    private Boolean statusCategory;

    //Getters and Setters

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Boolean getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(Boolean active) {
        this.statusCategory = active;
    }
}
