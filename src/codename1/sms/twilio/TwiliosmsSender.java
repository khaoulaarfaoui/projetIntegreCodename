package codename1.sms.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwiliosmsSender {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACe1cb79599bfb487e395f6a1cf610c12b";
  public static final String AUTH_TOKEN = "a056e9e5cf6d414448edaf43ee134ba6";

  public void sendsms() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21625303829"), // to
                        new PhoneNumber("+12513060988"), // from
                        "Inscription effectué avec succés").create();

        System.out.println(message.getSid());
    }
    
    
   
  }

  

   

