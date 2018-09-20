package com.solstice.lab4.accountsaddress.repository;

import com.solstice.lab4.accountsaddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByAccountId(Long id);
    Address getByIdAndAccountId(Long id, Long accountId);
}
