package com.kkamgi.user.service;

import com.kkamgi.user.domain.Member;
import com.kkamgi.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> login(String name, String password) {
        return memberRepository.findByNameAndPassword(name, password);
    }
}
