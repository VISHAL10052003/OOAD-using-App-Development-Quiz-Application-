import React from 'react';
import './Home.css'; // Import the CSS file for styling

class Homepage extends React.Component {
  render() {
    return (
      <div className="home-page">
        <div className='contnt'>
        <div className='text'>
          <p><h1>Let's Start </h1></p>
          <p style={{color:"#ffffff"}}><h1><b>Its time to take quiz</b></h1></p>
        </div>
        <div className='t1'>
          <p style={{color:"#ffffff"}}><b><h2><b> Choose an option from these </b></h2></b></p>
        </div>
        </div>
        <div className='but'>
        <div className='n1'>
          <button className="quiz-button" onClick={() => this.startQuiz('Individual') }>Individual</button>
        </div>
        <div className='no2'>
          <button className="quiz-button" onClick={() => this.startQuiz('Educational')}>Educational</button>
        </div>
          <div className='no3'><button className="quiz-button" onClick={() => this.startQuiz('Buissness')}>Buissness</button></div>
        </div>
    </div>
    );
  }

  startQuiz(difficulty) 
  {
    console.log(`Starting ${difficulty} quiz...`);
  }
}

export default Homepage;