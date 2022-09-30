import React, { Component } from 'react';
import AuthService from '../services/auth.service';
import "../../App.css";
import HeroSection from "../HeroSection";

export default class Home extends Component {


  render(){
    return (
      <>
      <HeroSection/>
      </>
    );
  }
}