import React, { useEffect, useState } from 'react';

import Axios from 'axios';
import Items from '../../components/items';
import PopularItems from '../../components/popular-items';
import style from './style.module.scss';

const Home = () => {

    const [items, setItems] = useState(null),
        [loading, setLoading] = useState(true),
        [popularItems, setPopularItems] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            const result = await Axios('http://localhost:8080/api/popular-items');
            setPopularItems(result.data);
        }

        if (popularItems) {
            setLoading(false);
        }

        const timer = setTimeout(() => {
            fetchData();
        }, 1000);
        return () => clearTimeout(timer);

        // eslint-disable-next-line
    }, [popularItems]);

    useEffect(() => {
        const fetchData = async () => {
            const result = await Axios('http://localhost:8080/api/items');
            setItems(result.data);
        }

        if (items) {
            setLoading(false);
        }

        const timer = setTimeout(() => {
            fetchData();
        }, 1000);
        return () => clearTimeout(timer);

        // eslint-disable-next-line
    }, [items]);

    return (
        <div>
            <div className={style.form__container}>
                <section className={style.itemList}>
                    {loading ? <h3>Loading ...</h3> : <Items items={items} />}
                </section>
            </div>
            <div className={style.warning__container}>
                <h2 className={style.warning}></h2>
            </div>
            {loading ? <h3>Loading ...</h3> : <PopularItems popularItems={popularItems} />}
        </div>
    );
}

export default Home;
