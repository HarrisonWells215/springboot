package com.springboot.controller;

import com.springboot.datetansor.AccessTokenDTO;
import com.springboot.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNameAuthorizeController
 * @Date2019-11-3020:47
 **/
@Controller
public class AuthorizeController {
    @Autowired
    private Provider provider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
    @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("https://github.com/login/oauth/access_token");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("3d0fc83ea1af95ebd2fd");
        accessTokenDTO.setClient_secret("a6368413a6c23a164517aae4bad6d9ed846776c3");
        provider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
