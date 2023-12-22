/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pubilc.sw.monitoring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author asdf0
 */

@Controller
public class ncContoller {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @PostMapping("/calculate")
    public String calculateGcdLcm(@RequestParam("a") int a, @RequestParam("b") int b, Model model) {
        int greatest = greatest(a, b);
        int least = (a * b) / greatest;

        model.addAttribute("greatest", greatest);
        model.addAttribute("least", least);

        return "boot_post";
    }

    private int greatest(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
