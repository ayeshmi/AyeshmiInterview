import axios from "axios";

const API_URL = "http://localhost:8082/api/auth/";

class AuthService {


  getSubscribers() {
    return axios.get(API_URL + "allSubscribers");
  }

  getVoiceMails() {
    return axios.get(API_URL + "allVoiceMail");
  }
 
  addNewSubscriber(firstName, lastName, email, subscriberMSISDN, subscriberPIN,voiceMailAccountStatus) {
    return axios.post(API_URL + "newSubscriber", {
      firstName, lastName, email, subscriberMSISDN, subscriberPIN,voiceMailAccountStatus
    });
  }

  getVoiceMailByID(Id){
    return axios.get('http://localhost:8082/api/auth/getVoiceMailByID/'+Id);
  }



}

export default new AuthService();