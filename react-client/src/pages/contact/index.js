import React from 'react';
import phone from '../../assets/contact.png';

const Contact = () => (
    <div class="page__container">
        <div>
            <img className='page-image' src={phone} alt='phone' />
            <h2>Contact Us</h2>
            <article>
                <h4>Contact Us today!</h4>
                <p>(555) 555-5555</p>
            </article>
        </div>
    </div>
);

export default Contact;
