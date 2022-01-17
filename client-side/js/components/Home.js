import Items from './Items';
import PopularItems from './PopularItems';
import apiHelpers from '../api-helpers/apiHelpers';

const [popularItems, setPopularItems] = apiHelpers.useState();

apiHelpers.getRequest('http://localhost:8080/api/popular-items', (popularItems) => {
  setPopularItems(popularItems);
});


export default function Home(items) {
  return `
  <div class='page__container'>
    <div class='form__container'>
        <input  class='add-item__name' type='text' placeholder='Enter item'>
        <button class='add-item__submit'>Submit</button>
        <section class='itemList'>
         ${Items(items)}
        </section>
      </div>
      <div class='warning__container'>
        <h2 class='warning'></h2>
      </div>
      ${PopularItems(popularItems())}
    </div> 
   </div>
    `;
}