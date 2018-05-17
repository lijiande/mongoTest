package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CommonConfig commonConfig;


    @GetMapping("/getConfig")
    public ResponseEntity<Map<String, Integer>> getConfig(@RequestParam(required = false) Integer threadNum,
                                                          @RequestParam(required = false) Integer num) {
        threadNum = commonConfig.getOrSetThreadNum(threadNum);
        num = commonConfig.getOrSetNum(num);
        Map<String, Integer> map = new HashMap<>();
        map.put("threadNum", threadNum);
        map.put("num", num);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model,@RequestParam String a) {

        model.addAttribute("a",a);
        return "home";
    }
}
