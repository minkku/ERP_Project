package org.gagu.repository;

import org.gagu.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    public Optional<Member> findById(String member_userid);
}
