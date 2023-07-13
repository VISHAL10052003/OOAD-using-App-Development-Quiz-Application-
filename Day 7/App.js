import React from 'react';
// import ReactDOM from 'react-dom/client';
import Hmnv from './components/hmnv';
import Registerpage from './components/registerpage';
import Loginpage from './components/loginpage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path='/' element={<Hmnv />} /> 
        <Route exact path='/register' element={<Registerpage />} />
        <Route exact path='/h' element={<Home />} />
        <Route exact path='/login' element={<Loginpage />} />
        
      </Routes>
    </BrowserRouter>
  );
};

export default App