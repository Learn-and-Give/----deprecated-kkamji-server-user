package com.kkamgi.user.controller;

import com.kkamgi.user.domain.Member;
import com.kkamgi.user.service.MemberService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

//    @ApiOperation(value = "로그인", notes = "회원 여부를 확인한다.")
//    @ApiImplicitParam(name = "request", value = "이름, 비밀번호", required = true)
//    @PostMapping("v1/login")
//    public ResponseMapper login(@RequestBody @Valid LoginMemberRequest request) {
//        Optional<Member> login = memberService.login(request.getName(), request.getPassword());
//        if (login.isPresent()) {
//            return ResponseMapper.register(HttpStatus.OK, new LoginMemberResponse(login.get().getId()));
//        } else {
//            return ResponseMapper.register(HttpStatus.UNAUTHORIZED);
//        }
//    }

    @ApiOperation(value = "로그인", notes = "회원 여부를 확인한다.")
    @ApiImplicitParam(name = "request", value = "이름, 비밀번호", required = true)
    @PostMapping("v1/login")
    public ResponseEntity login(@RequestBody @Valid LoginMemberRequest request) {
        Optional<Member> login = memberService.login(request.getName(), request.getPassword());
        if (login.isPresent()) {
            return new ResponseEntity(new LoginMemberResponse(login.get().getId()), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    // DTO 클래스를 사용하여 요청 데이터 정의
    @Getter
    static class LoginMemberRequest {
        @ApiModelProperty(value = "이름", example = "테스트", required = true)
        private String name;
        @ApiModelProperty(value = "비밀번호", example = "0000", required = true)
        private String password;
    }

    // DTO 클래스를 사용하여 응답 데이터 정의
    @Data
    @AllArgsConstructor
    static class LoginMemberResponse {
        private Long userId;
    }
}
