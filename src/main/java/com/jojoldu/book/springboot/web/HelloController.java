package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
                // 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됨
public class HelloController {

    @GetMapping("/hello")   // HTTP메소드인 Get의 요청을 받을 수 있는 API를 만들어줌
    public String hello(){
        return "hello";
    }
}
