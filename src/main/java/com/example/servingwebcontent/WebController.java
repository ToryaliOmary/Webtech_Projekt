package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/greetings")
    public String showGreetingsPage(Model model) {
        model.addAttribute("hellogreetings", "tayfun stinkt");
        return "greetings";
    }
}
