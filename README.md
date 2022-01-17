# Grocery Tracker

:strawberry: :tomato: :bread:
Welcome to `Grocery Tracker` the app that tracks what you need and when you placed it in your cart. Make managing your grocery list easy with `Grocery Tracker`. Simply click on one of your popular items, and it will be added to your list. Type other items into the input field and they will be added to your list. Track your progress by clicking on items in the list to "select" them, and apply the strikethrough indicating you have that item in your cart. Completely remove items on your list by clicking the delete button.

## Environments

### Server Side (Back end)

This is a standalone api, in its own folder `server-side` that serves up a rest api with the following endpoints:

- `localhost:8080/api/popular-items`: Will display all of the popular items in the database, to make adding to your grocery list easier the next time
- `localhost:8080/api/items`: Will display all of the items you have added to your grocery list
- `localhost:8080/api/items/add-item`: Adds an item to the grocery list
- `localhost:8080/api/items/{id}/select-item`: Selects an item on the grocery list
- `localhost:8080/api/items/{id}/delete-item`: Deletes an item from the grocery list

### Client Side (Front end)

This is a single page JavaScript application built using parcel. The server will run at `localhost:1234`.

## How to run this app

- clone the application locally onto your machine
- Using IntelliJ, navigate into `server-side` and open the Spring project, run the application file.
- `cd` into `client-side` and run `npm install` to install all frontend dependencies
- Run the front end with `npm start`
