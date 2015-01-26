package com.adanik.oauth2.client.example.web.controller;

import com.adanik.oauth2.client.example.model.UserInfo;
import com.adanik.oauth2.client.example.service.AdanalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class AdanalasController {

  @Autowired
  private AdanalasService adanalasService;

  @RequestMapping("/adanalas/info")
  public String getInfo(@RequestParam(required = false, value = "code") String code, @RequestParam(required = false, value = "error") String error, Model model) throws Exception {
    if (error != null) {
      model.addAttribute("error", error);
      return "oauth_error";
    } else {
      try {
        UserInfo userInfo = adanalasService.getUserInfo(code);
        model.addAttribute("userInfo", userInfo);
        return "adanalas";
      } catch (HttpClientErrorException e) {
        return "oauth_error";
      }
    }
  }

  @RequestMapping("/adanalas/categoryTransactions")
  public String getTransaction(Model model) throws Exception {
    return "adanalas";
  }

}
