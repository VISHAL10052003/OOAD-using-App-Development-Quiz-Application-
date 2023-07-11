import React from 'react';
import ReactDOM from 'react-dom/client';
import Registerpage from './components/registerpage';
import Loginpage   from './components/loginpage';
import { Route, Routes } from 'react-router-dom';


function App()
 {
  return (
   <Routes>
    <Route exact path='/reg'element={<Registerpage/>}/>
    
    <Route exact path='/login'element={<Loginpage/>}/>
   </Routes>
  )
}

export default App