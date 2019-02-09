package com.community.controller;

import com.community.annotation.SocialUser;
import com.community.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController { // User정보를 가져와 세션에 저장하는 코드

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/loginSuccess")
    public String loginComplete(@SocialUser User user){
        return "redirect:/board/list";
    }
}
