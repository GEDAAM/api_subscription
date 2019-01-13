package br.edu.gedaam.service;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    String resourceUrl = System.getenv("EMAIL_SERVER");
    String emailUser = System.getenv("EMAIL_SERVER_USER");
    String emailPassword = System.getenv("EMAIL_SERVER_PASSWORD");
    String emailFrom = System.getenv("EMAIL_SERVER_FROM");

    public void sendEmail() {
        try {
            HttpResponse<JsonNode> request = Unirest.post(resourceUrl)
                    .basicAuth(emailUser, emailPassword)
                    .field("from", emailFrom)
                    .field("to", "Raquel Lemos <raqlem@gmail.com>")
                    .field("subject", "Envio de Email pela API")
                    .field("html", "<html>Funcionou, agora com HTML! Parabéns</html>")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
