package com.kkamgi.user.repository;

import com.kkamgi.user.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트")
    public void createMemberTest() {
        //given
        memberRepository.save(Member.builder()
                .name("kim")
                .password("1234")
                .point(0)
                .build());

        //when
        List<Member> usersList = memberRepository.findAll();

        //then
        Member user = usersList.get(0);
        assertThat(user.getName()).isEqualTo("kim");
    }
}