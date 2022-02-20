import Contact from './components/Contact';
import Footer from './components/Footer';
import Header from './components/Header';
import Home from './components/Home';
import Items from './components/Items';
import PopularItems from './components/PopularItems';
import apiHelpers from './api-helpers/apiHelpers';

const app = document.querySelector('#app');

buildPage();

function buildPage() {
  header();
  footer();
  navContact();
  navHome();
  retrievePopularItems();
  // retrieveItems();
  //addItemsToGroceryList();
  addPopularItemToGroceryList();
  selectItemOnGroceryList();
  removeItemFromGroceryList();
  renderAccountInfo();
}

function header() {
  const headerElem = document.querySelector('.header');
  headerElem.innerHTML = Header();
}

function footer() {
  const footerElem = document.querySelector('.footer');
  footerElem.innerHTML = Footer();
}

function navContact() {
  const contactElem = document.querySelector('.nav-list__contact');
  contactElem.addEventListener('click', () => {
    app.innerHTML = Contact();
  });
}

function navHome() {
  const homeElem = document.querySelector('.nav-list__home');
  homeElem.addEventListener('click', () => {
    apiHelpers.getRequest('http://localhost:8080/api/items', (items) => {
      app.innerHTML = Home(items);
    });
  });
}

// function retrieveItems(userName) {
//   const itemsSection = document.querySelector('.itemList');
//   apiHelpers.getRequest(`http://localhost:8080/api/${userName}/items`, (items) => {
//     itemsSection.innerHTML = Items(items);
//   });
// }

function retrievePopularItems() {
  const popularItemsSection = document.querySelector('.popularItems');
  apiHelpers.getRequest('http://localhost:8080/api/popular-items', (popularItems) => {
    popularItemsSection.innerHTML = PopularItems(popularItems);
  });
}

function addItemsToGroceryList(user) {
  const name = user.userName
  app.addEventListener('click', (event) => {
    if (event.target.classList.contains('add-item__submit')) {
      const itemName = event.target.parentElement.querySelector('.add-item__name').value;
      apiHelpers.postRequest(`http://localhost:8080/api/${name}/items/add-item`,
        {
          name: itemName,
          isSelected: false
        },
        (items) => (app.innerHTML = Home(items, user)));
    }
  });
}

function addPopularItemToGroceryList() {
  app.addEventListener('click', (event) => {
    if (event.target.classList.contains('popularItem-name')) {
      const popularItemName = event.target.parentElement.querySelector('.popularItem-name__input').value;
      apiHelpers.postRequest('http://localhost:8080/api/items/add-item',
        {
          name: popularItemName,
          isSelected: false
        },
        (items) => (app.innerHTML = Home(items)));
    }
  });
}

function selectItemOnGroceryList() {
  app.addEventListener('click', (event) => {
    if (event.target.classList.contains('item-name') ||
      (event.target.classList.contains('item-name-selected'))) {
      const itemSelectedId = event.target.parentElement.querySelector('.item-idInput').value;
      const itemSelectedName = event.target.parentElement.querySelector('.item-nameInput').value;
      const itemSelectedFlag = event.target.parentElement.querySelector('.item-selectedFlagInput').value;
      apiHelpers.putRequest(`http://localhost:8080/api/items/${itemSelectedId}/select-item`,
        {
          name: itemSelectedName,
          isSelected: itemSelectedFlag === 'true' ? false : true
        },
        (items) => (app.innerHTML = Home(items)));
    }
  });
}

function removeItemFromGroceryList() {
  app.addEventListener('click', (event) => {
    if (event.target.classList.contains('item-delete')) {
      const itemSelectedId = event.target.parentElement.querySelector('.item-idInput').value;
      apiHelpers.deleteRequest(`http://localhost:8080/api/items/${itemSelectedId}/delete-item`, (items) => {
        app.innerHTML = Home(items);
      });
    }
  });
}

function renderAccountInfo() {
  const loginSubmit = document.querySelector('.loginSubmit');
  loginSubmit.addEventListener('click', (event) => {
    if (event.target.parentElement.classList.contains('loginForm')) {
      const name = event.target.parentElement.querySelector('.loginName').value;
      //from here instead of logging, you can send the user to the Account page and get the user's information, 
      //note this will only be possible for a user that is stored in your populator otherwise you will get null
      apiHelpers.getRequest(`http://localhost:8080/api/users/${name}`, (user) => {
        console.log(user);
        if (user) {
          apiHelpers.getRequest(`http://localhost:8080/api/${name}/items`, (items) => {
            app.innerHTML = Home(items, user);
          });
          addItemsToGroceryList(user);
        }
      });

    }
  })
}