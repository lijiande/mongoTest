package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
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
}
