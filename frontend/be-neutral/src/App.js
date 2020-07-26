import React from 'react';
import './App.css';

const stepList = [
  {
    img: 'schema-house.png',
    alt: 'House - cloud - tree cycle with highlighted house.',
    title: 'Tell us about your home',
    text: 'We calculate your CO<sub>2</sub> emission based on your utilities usage and location-specific information of how the energy is produced and transmitted.'
  },
  {
    img: 'schema-cloud.png',
    alt: 'House - cloud - tree cycle with highlighted data cloud',
    title: 'Compare your options',
    text: 'Learn what contributes to your footprint. Compare options to reduce your emission and to offset what remains emitted. By reducing utilities usage, you will also pay lower bills. Get to know how much you can save and what upfront costs you\'ll have to cover. Whenever possible, we complete our knowledge-based estimates with data-based estimates by analyzing previous implementations of a solution in other houses in the network, similar to yours.'
  },
  {
    img: 'schema-tree.png',
    alt: 'House - cloud - tree cycle with highlighted tree',
    title: 'Take an action',
    text: 'Retrofit your house by addressing energy efficiency and shifting sources of energy to renewable, change your habits. Insulate your walls or renovate windows, install new solar panels, replace bulbs and plant trees to capture what you couldn\'t reduce.'
  },
  {
    img: 'schema-arrows.png',
    alt: 'House - cloud - tree cycle with highlighted transition arrows',
    title: 'Repeat until you are neutral',
    text: 'Keep on measuring your utilities and reducing your emission until you achieve carbon-neutrality and then maintain it by balancing emission with absorption. Start small, by replacing a few bulbs or setting the thermostat one degree up/down. Over time as you build trust to our estimates you can make bigger improvements like renovating windows, installing solar panels, or even trying that new energy-efficiency technology which you may have never considered before. Ultimately - make well informed decisions and move at your own pace. Track changes in your utilities usage and see effects, both ecological and economical, of your efforts'
  },
  {
    img: 'schema-rain.png',
    alt: 'House - cloud - tree cycle with data flying all over the place',
    title: 'Share with the community',
    text: 'Community is our super-power! Share changes you are making and how efficient they are so that we can make even more accurate estimates for others to rely on. We calculate the efficiency of your implementation by computing what \'normal\' utility usage meant for your house before the change (relative to the baseline established by other similar and nearby houses, to account for weather) and after the change compare your new \'normal\' with the old one.'
  }



]

function App() {
  return (
    <div>
      <section className="main-section">
        <img
          src="logo.png"
          alt="BeNeutral logo - zen circle around CO2."
          style={{
            display: 'block',
            marginLeft: 'auto',
            marginRight: 'auto',
            width: '60vw',
            minWidth: '350px'
          }}
        />
        <button onClick={() => console.log('click')}>Start the balancing art</button>
      </section>

      <section className="main-section">
        <p>Heating and cooling, warm water, cooking, electricity to power appliances and lights all demand energy, taking a great toll on the environment and family budgets worldwide. From 25% in car-dominated US<a href="#ref1"><sup>1</sup></a> to 40% in bicycle-focused Denmark<a href="#ref2"><sup>2</sup></a>, homes contribute significantly to the annual emissions of a household.</p>

        <img src="personal-footprint-structure-us-avg.png"
          alt="Pie chart with footprint breakdown for an average american, home account for about 1/4, travel 1/3, other are food, goods and services."
          style={{ float: 'right', height: '250px' }} />

        <p>We look for better ways to obtain energy, yet, <b>as much as 80% of energy consumed at homes is wasted</b><a href="#ref3"><sup>3</sup></a>. Many energy solutions already exist, from improving efficiency to new sources, from accurate insulation to solar panels. On the other hand, we could also absorb some of the CO<sub>2</sub> emitted by carefully and smartly planting trees<a href="#ref4"><sup>4</sup></a>. We lack knowledge about all of these options, ways to compare and quantify them.</p>

        <p>Long term, we believe there is no other way for the planet then every human to keep balance of his emissions and absorptions, and we need tools to do that.</p>
      </section>

      <section className="main-section">
        <h2>How does <span style={{ color: '#1ca240' }}>B</span>e<span style={{ color: '#1ca240' }}>N</span>eutral work?</h2>

        <p>Based on your utilities usage, we calculate CO<sub>2</sub> emitted by your house, advise how to reduce it, and encourage you to offset the rest by planting trees.</p>

        <p>In short, we use data to help you keep balance to be neutral.</p>
        <ol className="steps">
          {stepList.map((step, index) => {
            return (
              <div key={index}>
                <li className="step" >
                  <img src={step.img} alt={step.alt} />
                  <div className="point">{index + 1}</div>
                  <h3>{step.title}</h3>
                  <p>{step.text}</p>
                </li>
              </div>
            )
          })}
        </ol>
      </section>

      <section class="main-section">
        <p>
          <span id="ref1">1.&nbsp;<a href="https://www.nature.org/en-us/get-involved/how-to-help/carbon-footprint-calculator/">The Nature Conservancy Carbon Footprint Calculator</a></span>
          <span id="ref2">2.&nbsp;Copenhagen: Solutions For Sustainable Cities, 2014, p. 38</span>
          <span id="ref3">3.&nbsp;<a href="https://drawdown.org/solutions/building-retrofitting">Project Drawdown - Building retrofitting</a></span>
          <span id="ref4">4.&nbsp;<a href="https://www.arborday.org/calculator/">The Arbor Day Foundation's Tree Benefit Calculator</a></span>
        </p>
        <p style={{ color: 'grey' }}>TODO: maybe include water consumption - as a matter of running out of resources rather than global warming.</p>
      </section>




    </div>
  );
}

export default App;