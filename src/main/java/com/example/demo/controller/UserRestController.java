package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@RequestMapping("/api/v1")
@RestController
public class UserRestController {

    /**
     * 사번 조회
     *
     * @return
     */
    @GetMapping(value = "/user")
    public ResponseEntity<?> getUserSabun(HttpServletRequest request) {

        // 전체 URL을 가져옴
        String requestUri = request.getRequestURL().toString();

        // 숫자 패턴을 정의 (정규 표현식)
        Pattern pattern = Pattern.compile("http://(\\d+)");
        Matcher matcher = pattern.matcher(requestUri);

        String id;
        if (matcher.find()) {
            // 첫 번째 매칭된 숫자 추출
            id = matcher.group(1);
        } else {
            id = "사번이 없습니다.";
        }
       
        return ResponseEntity.ok(id);
    }

}
