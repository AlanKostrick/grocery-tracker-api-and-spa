package org.wecancodeit.serverside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PopularItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public PopularItem(){}

    public PopularItem(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
