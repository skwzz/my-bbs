package com.skwzz.mybbs.domain.member.entity.repository;

import com.skwzz.mybbs.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
}
