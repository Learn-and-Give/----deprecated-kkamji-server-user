package com.kkamgi.user.repository;

import com.kkamgi.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByNameAndPassword(String name, String password);
}
