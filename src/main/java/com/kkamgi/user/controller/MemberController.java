package com.kkamgi.user.controller;

import com.kkamgi.user.domain.Member;
import com.kkamgi.user.service.MemberService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "로그인", notes = "회원 여부를 확인한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "이름", required = true, example = "테스트"),
            @ApiImplicitParam(name = "password", value = "비밀번호", required = true, example = "0000")
    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "status_code = 0, message = ok / status_code = -1, message = error / status_code = -99, message = Not Exist Required Param"),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")
//    })
    @PostMapping("v1/login")
    public Long login(@RequestParam("name") String name, @RequestParam("password") String password) {
        return memberService.login(name, password)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 혹은 비밀번호입니다."))
                .getId();
    }
}
