package com.digitalbooking.back.bookStay.address;

import com.digitalbooking.back.bookStayApp.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
