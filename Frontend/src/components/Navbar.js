import React ,{useState,useEffect} from 'react';
import {Link} from 'react-router-dom';
import "./Navbar.css";
import authService from './services/auth.service';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
toast.configure()


function Navbar() {
    const [click,setClick]=useState(false);
   
    const handleClick= () => setClick(!click);
    const closeMobileMenu =() => setClick(false);
    
 


    return (
      <>
      <nav className="navbar">
          <div className="navbar-container">
          <Link to="/" className="navbar-logo">
          Voice Mail System <i to="/" className='fab fa-typo3' />
              </Link> 
              <div className='menu-icon' onClick={handleClick}>
                 <i className={click ? 'fas fa-times' : 'fas fa-bars'} /> 
              </div>
              <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                  
                  
                  <li className='nav-item'>
                      <Link to='/viewAllVoiceMail' className='nav-links' onClick={closeMobileMenu}>
                          Voice Mail
                      </Link>
                  </li>
                  
                  <li className='nav-item'>
                      <Link to='/viewAllSusbscriber' className='nav-links' onClick={closeMobileMenu}>
                          Subscriber
                      </Link>
                  </li>
          
               
              
              </ul>
              
              
          </div>
       </nav>
     </>
    );
}



export default Navbar;