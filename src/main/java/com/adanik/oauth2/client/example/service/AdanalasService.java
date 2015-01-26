package com.adanik.oauth2.client.example.service;

import com.adanik.oauth2.client.example.exception.AdanalasException;
import com.adanik.oauth2.client.example.model.TransactionModel;
import com.adanik.oauth2.client.example.model.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author S Khalili
 */
@Service
public class AdanalasService {

  @Value("${embassy.clientId}")
  String clientId;

  @Value("${embassy.password}")
  String clientPassword;

  @Value("${adanalas.authorizationUri}")
  String authorizationUrl;

  @Value("${adanalas.accessTokenUrl}")
  String accessTokenUrl;

  @Value("${adanalas.userInfoUrl}")
  String userInfoUrl;

  @Value("${adanalas.transactionsUrl}")
  String transactionsUrl;

  @Value("${embassy.redirectUri}")
  String redirectUri;

  @Value("${embassy.scope.user}")
  String userScope;

  public UserInfo getUserInfo(String authorizationCode) throws AdanalasException {

    RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

    List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();

    msgConverters.add(new FormHttpMessageConverter());
    msgConverters.add(new MappingJackson2HttpMessageConverter());

    restTemplate.setMessageConverters(msgConverters);

    //REQUEST 1


    //REQUEST 2
    String token = clientId + ":" + clientPassword;
    BASE64Encoder enc = new sun.misc.BASE64Encoder();
    String encodedAuthorization = enc.encode(token.getBytes());
    String authHeader = "Basic " + encodedAuthorization;

    MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
    body.add("code", authorizationCode);
    body.add("redirect_uri", redirectUri);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.set("Authorization", authHeader);

    HttpEntity<?> entity = new HttpEntity<Object>(body, headers);


    Object accessTokenResponse = restTemplate.postForObject(accessTokenUrl, entity, Object.class);
    String accessToken = (String) ((LinkedHashMap) (((LinkedHashMap) accessTokenResponse).get("access_token"))).get("value");
    //REQUEST 3 service call
    headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    authHeader = "Bearer " + accessToken;
    headers.set("Authorization", authHeader);

    entity = new HttpEntity<Object>(headers);

    ResponseEntity<UserInfo> userInfo = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, UserInfo.class);

    ResponseEntity<TransactionModel[]> transactions = restTemplate.exchange(transactionsUrl, HttpMethod.GET, entity, TransactionModel[].class);

    userInfo.getBody().setTransactions(Arrays.asList(transactions.getBody()));
    return userInfo.getBody();
  }

}
