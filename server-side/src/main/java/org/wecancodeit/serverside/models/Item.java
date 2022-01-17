package org.wecancodeit.serverside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean isSelected;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getSelected(){return isSelected;}

    public void setSelected(boolean itemIsSelected) {
        this.isSelected = itemIsSelected;
    }

    public Item(){}

    public Item(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

}
