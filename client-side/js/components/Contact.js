import contactImg from '../../assets/contact.png';

export default function Contact() {
  return `
  <div class="page__container">
    <div>
        <img class='page-image' src='${contactImg}' alt='books'/>
        <h2>Contact Us</h2>
        <article>
          <h4>Contact Us today!</h4>
          <p>(555) 555-5555</p>
        </article>
    </div>
  </div>
    `;
}