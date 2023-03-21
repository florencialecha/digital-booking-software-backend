package com.digitalbooking.back.bookStayApp.reserves;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
