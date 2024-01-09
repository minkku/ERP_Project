package org.gagu.repository;

import org.gagu.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
//    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph, EntityGraphType.LOAD)
//    @Query("SELECT  FROM")
}
