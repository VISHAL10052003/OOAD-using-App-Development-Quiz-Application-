import React, { useState } from 'react';
import './registerpage.css';
import { Link } from 'react-router-dom';

const RegisterPage = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});

  const validateForm = () => {
    const newErrors = {};
  
    if (firstName.trim() === '') {
      newErrors.firstName = 'First Name is required';
    } else if (firstName.length < 3) {
      newErrors.firstName = 'First Name must be at least 6 characters long';
    }
  
    if (lastName.trim() === '') {
      newErrors.lastName = 'Last Name is required';
    } else if (lastName.length < 3) {
      newErrors.lastName = 'Last Name must be at least 6 characters long';
    }
  
    if (username.trim() === '') {
      newErrors.username = 'Username is required';
    } else if (!/^[a-zA-Z]{3}[0-9]{2}$/.test(username)) {
      newErrors.username = 'Username should be a combination of 3 alphabets and 2 numbers';
    }
  
    if (email.trim() === '') {
      newErrors.email = 'Email is required';
    } else if (!/\S+@\S+\.gmail\.com/.test(email)) {
      newErrors.email = 'Email should be in the format example@gmail.com';
    }
  
    if (password.trim() === '') {
      newErrors.password = 'Password is required';
    } else if (!/^(?=.[A-Za-z]{3})(?=.\d{2})(?=.[@$!%#?&]{2})\S{7,}$/.test(password)) {
      newErrors.password = 'Password should be a combination of 3 alphabets, 2 numbers, and 2 special characters';
    }
  
    setErrors(newErrors);
  
    return Object.keys(newErrors).length === 0;
  };
  

  const handleRegister = (e) => {
    e.preventDefault();
    const isValid = validateForm();

    if (isValid) {
      console.log('Registration details:', {
        firstName,
        lastName,
        username,
        email,
        password
      });
      // Perform registration logic here
    }
  };

  return (
    <div className="reg">
      <div className="register-container">
        {/* <div className='tle'><h1>QUIZ APP</h1></div> */}
        <h2>Register</h2>
        <form onSubmit={handleRegister}>
          <div className="input-container">
            <label htmlFor="firstName" style={{color:'black'}}><b><h3>First Name:</h3></b></label>
            <input
              type="text"
              id="firstName"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              className={errors.firstName ? 'input-error' : ''}
            />
            {errors.firstName && <p className="error">{errors.firstName}</p>}
          </div>
          <div className="input-container">
            <label htmlFor="lastName" style={{color:'black'}}><b><h3>Last Name:</h3></b></label>
            <input
              type="text"
              id="lastName"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              className={errors.lastName ? 'input-error' : ''}
            />
            {errors.lastName && <p className="error">{errors.lastName}</p>}
          </div>
          <div className="input-container">
            <label htmlFor="username" style={{color:'black'}}><b><h3>Username</h3></b></label>
            <input
              type="text"
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className={errors.username ? 'input-error' : ''}
            />
            {errors.username && <p className="error">{errors.username}</p>}
          </div>
          <div className="input-container">
            <label htmlFor="email" style={{color:'black'}}><b><h3>Email:</h3></b></label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className={errors.email ? 'input-error' : ''}
            />
            {errors.email && <p className="error">{errors.email}</p>}
          </div>
          <div className="input-container">
            <label htmlFor="password" style={{color:'black'}}><b><h3>Password:</h3></b></label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className={errors.password ? 'input-error' : ''}
            />
            {errors.password && <p className="error">{errors.password}</p>}
          </div>
          <br/>
          <button className="register-button" type="submit">
            <Link to='/login' style={{color:'#ffffff'}}>Register</Link>
          </button>
        </form>
      </div>
    </div>
  );
};

export default RegisterPage;