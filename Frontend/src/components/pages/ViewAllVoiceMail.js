import React, { Component } from 'react';
import authService from '../services/auth.service';
import './ViewAllUserDetails.css';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Card, Button } from 'react-bootstrap';
toast.configure()

const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

class ListEmployeeComponent extends Component {
  
  //create constructor
  constructor(props) {
    super(props)
    this.addNewSubscriber=this.addNewSubscriber.bind(this);
    this.state = {
      voiceMails: []

    }
  }

  //get existing data
  componentDidMount() {
    authService.getVoiceMails().then((res) => {
    this.setState({ voiceMails: res.data });
    });
  }

  addNewSubscriber(e){
    this.props.history.push(`/addUser`);
    window.location.reload();
  }
 
  notify() {

    // Calling toast method by passing string
    toast.success(this.state.message)
  }

  


  render() {
    return (
      <div className='bodyOfCategoryBook'>
        <h2 id="headerTitle1"><b>Handle Voice Mails</b></h2>
        <br></br>

        <div className="rowV">

          <table >
            <thead>
              <tr>
                <th className='back2'>  voiceMailID</th>
                <th className='back2'>voiceMailSenderMSISDN</th>
                <th className='back2'>voiceMailReceiverMSISDN</th>
                <th className='back2'>dateMessageReceived</th>
                <th className='back2'>timeMessageReceived</th>
                <th className='back2'>messageReadStatus</th>
                <th className='back2'>voiceMailFilePath</th>
              </tr>
            </thead>

            <tbody>
              {
                this.state.voiceMails.map(
                  voiceMail =>
                    <tr key={voiceMail.id}>
                      <td className='back1'>{voiceMail.voiceMailID}</td>
                      <td className='back1'>{voiceMail.voiceMailSenderMSISDN}</td>
                      <td className='back1'>{voiceMail.voiceMailReceiverMSISDN}</td>
                      <td className='back1'>{voiceMail.dateMessageReceived}</td>
                      <td className='back1'>{voiceMail.timeMessageReceived}</td>
                      <td className='back1'>{voiceMail.messageReadStatus}</td>
                      <td className='back1'>{voiceMail.voiceMailFilePath}</td>
                      
              

                    </tr>
                )
              }
            </tbody>
          </table>

        </div>
      </div>
    );
  }
}

export default ListEmployeeComponent;