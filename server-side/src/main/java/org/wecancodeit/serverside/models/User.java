package org.wecancodeit.serverside.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    @OneToMany
    private Collection<Item> items;

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

    public Collection<Item> getItems(){
        return items;
    }

    protected User(){}

    public User(String userName, Item ...items) {
        this.userName = userName;
        this.items = new HashSet<>(Arrays.asList(items));
    }

    public void addItem(Item itemToAdd) {
        items.add(itemToAdd);
    }
}
