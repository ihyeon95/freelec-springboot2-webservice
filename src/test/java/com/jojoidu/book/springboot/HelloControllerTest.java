package com.jojoidu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    // 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자 실행
                                // 여기서는 SpringRunner라는 스프링 실행자를 사용
                                // 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)    // 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 빈(Bean)을 주입 받음
    private MockMvc mvc;    // 웹 API를 테스트할 때 사용
                            // 스프링 MVC 테스트의 시작점
                            // 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))    // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())     // HTTP Header의 Status를 검증(여기선 OK 즉, 200인지 아닌지 검증)
                .andExpect(content().string(hello));    // Controller에서 "hello"를 리턴하기 떄문에 이 값이 맞는지 검증
    }
}
