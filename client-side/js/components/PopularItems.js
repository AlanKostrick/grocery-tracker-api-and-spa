export default function PopularItems(popularItems) {
  return `
    <h2>Here are our most popular items...</h2>
    <ul class='popularItems-list'>
    ${popularItems
      .map((popularItem) => {
        return `
        <section class='popularItem-section'>
            <p class='popularItem-name'>${popularItem.name}
              <input class='popularItem-name__input' type='hidden' value=${popularItem.name} />
            </p>
            <p>${popularItem.price}</p>
        </section>
        `;
      })
      .join('')}
    </ul>
    `;
}