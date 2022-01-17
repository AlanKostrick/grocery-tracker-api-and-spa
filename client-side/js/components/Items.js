export default function Items(items) {
  return `
    ${items
      .map((item) => {
        const classNames = item.selected ? 'item-name-selected' : 'item-name';
        return `
            <section>
              <p class=${classNames}>${item.name}
                <button class='item-delete'>x</button>
                <input class='item-idInput' type='hidden' value=${item.id} />
                <input class='item-nameInput' type='hidden' value=${item.name} />
                <input class='item-selectedFlagInput' type='hidden' value=${item.selected} />
              </p>
            </section>
        `;
        // }
      })
      .join('')}
    `;
}