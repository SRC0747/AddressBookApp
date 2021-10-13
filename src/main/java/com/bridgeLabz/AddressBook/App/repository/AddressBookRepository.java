package com.bridgeLabz.AddressBook.App.repository;

import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    Optional<AddressBook> findByName(String name);

    Optional<AddressBook> findByMobileNo(int mobileNo);

    Optional<AddressBook> findByState(String state);

    Optional<AddressBook> findByCity(String city);

    Optional<AddressBook> findByEmail(String email);
}
