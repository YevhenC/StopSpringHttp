package com.octopus.servicecontrol;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Stop a Spring Boot application as a service.
 *
 * @author Matthew Casperson
 */
public class StopSpringBootService {
    private static final Logger LOGGER = Logger.getLogger(StopSpringBootService.class.getName());

    public static void main(String[] args) throws Exception {
        System.out.println("Stopping Spring Boot application...");

        stopFirstAppPassword();

        System.exit(0);

    }


    static void stopFirstAppPassword() {

        try {
            HttpPost post = new HttpPost("http://localhost:8080/request");

            // add request parameter, form parameters
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("password", "abc"));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {

                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.ALL, Arrays.toString(ex.getStackTrace()));
        }


    }
}
