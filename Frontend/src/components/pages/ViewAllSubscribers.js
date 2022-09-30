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
      subcribers: []

    }
  }

  //get existing data
  componentDidMount() {
    authService.getSubscribers().then((res) => {
    this.setState({ subcribers: res.data });
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
        <h2 id="headerTitle1"><b>Handle Subscribers</b></h2>
        <br></br>
        <div className='cards__items13 '>
          <div>
            <Card style={{ width: '12rem', backgroundColor: 'rgb(119, 175, 212)' }}>
              <Card.Img variant="top" src="https://www.price2spy.com/blog/wp-content/uploads/2017/10/29-295797_listening-to-customers-png-cartoon-happy-customer-png.png" />
              <Card.Body>
                <Button variant="primary" onClick={this. addNewSubscriber}>Add Subscriber</Button>
              </Card.Body>
            </Card>
          </div>
        </div>

        <div className="rowV">

          <table >
            <thead>
              <tr>
                <th className='back2'> Subscriber ID</th>
                <th className='back2'>Subscriber MSISDN</th>
                <th className='back2'>First Nama</th>
                <th className='back2'>Last Name</th>
                <th className='back2'>email</th>
                <th className='back2'> Voice Mail Account Status</th>
              </tr>
            </thead>

            <tbody>
              {
                this.state.subcribers.map(
                  subcriber =>
                    <tr key={subcriber.id}>
                      <td className='back1'>{subcriber.subscriberID}</td>
                      <td className='back1'>{subcriber.subscriberMSISDN}</td>
                      <td className='back1'>{subcriber.firstName}</td>
                      <td className='back1'>{subcriber.lastName}</td>
                      <td className='back1'>{subcriber.email}</td>
                      <td className='back1'>{subcriber.voiceMailAccountStatus}</td>
                      
              

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