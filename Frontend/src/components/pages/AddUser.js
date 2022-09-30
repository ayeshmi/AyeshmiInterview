import './AddUser.css';
import React, { Component, useState } from "react";
import AuthService from '../services/auth.service';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
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

export default class AddUser extends Component {
  //create constructor
  constructor(props) {

    super(props);
    this.handleNew = this.handleNew.bind(this);
    this.onChangeSubscriberMSISDN = this.onChangeSubscriberMSISDN.bind(this);
    this.onChangeSubscriberPIN= this.onChangeSubscriberPIN.bind(this);
    this.onChangeFirstname = this.onChangeFirstname.bind(this);
    this.onChangeLastname = this.onChangeLastname.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangeVoiceMailAccountStatus = this.onChangeVoiceMailAccountStatus.bind(this);

    this.state = {
      subscriberMSISDN: "",
      subscriberPIN: "",
      firstName: "",
      lastName: "",
      subscriberPIN: "",
      email:" ",
      voiceMailAccountStatus:" ",
      loading: false,
      message: ""
    };
  }

  onChangeSubscriberMSISDN(e) {
    this.setState({
      subscriberMSISDN: e.target.value
    });
  }

  onChangeSubscriberPIN(e) {
    this.setState({
      subscriberPIN: e.target.value
    });
  }

  onChangeFirstname(e) {
    this.setState({
      firstName: e.target.value
    });
  }

  onChangeLastname(e) {
    this.setState({
      lastName: e.target.value
    });
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }

  onChangeVoiceMailAccountStatus(e) {
    this.setState({
      voiceMailAccountStatus: e.target.value
    });

  }


  handleNew(e) {
    e.preventDefault();

    this.setState({
      message: "",
      loading: true
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      AuthService.addNewSubscriber(
        this.state.firstName,
        this.state.lastName,
        this.state.email,
        this.state.subscriberMSISDN,
        this.state.subscriberPIN,
        this.state.voiceMailAccountStatus

      ).then(

        response => {
          this.setState({
            message: response.data.message,
            successful: true
          });

          this.props.history.push(`/viewAllSusbscriber`);
          window.location.reload();
          this.notify();
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            successful: false,
            message: resMessage
          });

          if (resMessage == "Request failed with status code 500") {
            this.setState({
              loading: false,
              message: "Incorrect email format!"
            }
            )
          };

          toast.error(this.state.message);
        }

      );

    }

  }

  notify() {

    // Calling toast method by passing string
    toast.success(this.state.message)
  }

  render() {
    return (
      <div>
        <img className='form-img22r' src={"/images/books-1617327_1920.jpg"} alt='register' />
        <div className="form2r">
          <Form
            onSubmit={this.handleNew}
            ref={c => {
              this.form = c;
            }}>

            <div class="row1">
              <h2 id="headerTitle1">Add New Subscriber</h2>

              <label >Firstname</label>
              <Input
                placeholder="Enter your first name"
                type="text"
                name="username"
                value={this.state.firstName}
                onChange={this.onChangeFirstname}
                validations={[required]}
              />

              <label htmlFor="password">Lastname</label>
              <Input
                placeholder="Enter your last name"
                type="text"
                name="email"
                value={this.state.lastName}
                onChange={this.onChangeLastname}
                validations={[required]}
              />

              <label >email</label>
              <Input
                placeholder="Enter your email"
                type="text"
                name="firstName"
                value={this.state.email}
                onChange={this.onChangeEmail}
                validations={[required]}
              />

              <label >Subscriber MSISDN</label>
              <Input
                placeholder="Enter your Subscriber MSISDN"
                type="text"
                name="lastName"
                value={this.state.subscriberMSISDN}
                onChange={this.onChangeSubscriberMSISDN}
                validations={[required]}
              />

              <label >Subscriber PIN</label>
              <Input
                placeholder="Enter your PIN"
                type="password"
                name="password"
                value={this.state.subscriberPIN}
                onChange={this.onChangeSubscriberPIN}
                validations={[required]}
              />

              <label >Voice Mail Account Service Status</label>
              <Input
                placeholder="Enter your status"
                type="text"
                name="password"
                value={this.state.voiceMailAccountStatus}
                onChange={this.onChangeVoiceMailAccountStatus}
                validations={[required]}
              />

            </div>

            <br></br>

            <div className="row1 ">

              <button
                className="btn btn-primary btn-block"
                disabled={this.state.loading}>
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>ADD</span>
              </button>


            </div>


            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />

          </Form>

        </div>
      </div>
    );
  }
}