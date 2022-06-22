import React from 'react';
import style from './style.module.scss';

const PopularItems = ({ popularItems }) => (
    <>
        <h2>Here are our most popular items...</h2>
        <ul className={style.popularItemsList}>
            {popularItems.map(popularItem => (
                <div className={style.popularItemDataContainer} key={popularItem.id}>
                    <p>{popularItem.name}</p>
                    <p>{popularItem.price}</p>
                </div>
            ))}
        </ul>
    </>
);

export default PopularItems;