import React from 'react';
import { Button } from './Button';
import './HeroSection.css';
import '../App.css';

function HeroSection() {
    return (
        <div className='hero-container'>
            <video src='/videos/video3.mp4' autoPlay loop muted/>
            <h1>VOICE MAIL SYSTEM </h1>
            <p>Do you want to send voice mail? </p>
            
            
        </div>
    )
}

export default HeroSection
