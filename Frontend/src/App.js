import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import Home from './components/pages/Home';
import ViewAllSubscribers from './components/pages/ViewAllSubscribers';
import ViewAllVoiceMails from './components/pages/ViewAllVoiceMail';
import AddUser from './components/pages/AddUser';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';


function App() {
  return (
  <>
  <Router>
    <Navbar/>
    <Switch>
      <Route path='/' exact component={Home}/>
      <Route path="/addUser"  component={AddUser} />
      <Route path="/viewAllSusbscriber" exact  component={ViewAllSubscribers} />
      <Route path="/viewAllVoiceMail" exact  component={ViewAllVoiceMails} />
      
      
      
    </Switch>
  </Router>
  </>
  );
}

export default App;
