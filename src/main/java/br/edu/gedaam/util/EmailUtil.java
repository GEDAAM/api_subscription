package br.edu.gedaam.util;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    String resourceUrl = System.getenv("EMAIL_SERVER");
    String emailUser = System.getenv("EMAIL_SERVER_USER");
    String emailPassword = System.getenv("EMAIL_SERVER_PASSWORD");
    String emailFrom = System.getenv("EMAIL_SERVER_FROM");

    public void sendEmail(String toName, String toEmail, String subject, String mailText) {
        try {
            //String to = toName + "<" + toEmail +">";
            HttpResponse<JsonNode> request = Unirest.post(resourceUrl)
                    .basicAuth(emailUser, emailPassword)
                    .field("from", emailFrom)
                    .field("to", toEmail)
                    .field("subject", subject)
                    .field("html", mailText)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
