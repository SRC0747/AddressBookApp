package com.bridgeLabz.AddressBook.App.service;

import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import com.bridgeLabz.AddressBook.App.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class for the business logic for AddressBook App Controller service
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 13-10-2021
 */

@Service
public class AddressBookService {

    @Autowired
    private static AddressBookRepository addressBookRepository;

    /**
     * Method for getting all the students from database
     * @return list of {@link AddressBook Entity}
     */

    public static List<AddressBook> addressBookDataList(){
        return addressBookRepository.findAll();
    }

    public AddressBook getPersonById(int id) {
        Optional<AddressBook> addressBookData = addressBookRepository.findById(id);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }

    public AddressBook getPersonByName(String name) {
        Optional<AddressBook> addressBookData = addressBookRepository.findByName(name);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }
    /**
     *
     * @param AddressBook add operation
     * @return
     */

    public AddressBook addPerson(AddressBook addressBookData) {
        return addressBookRepository.save(addressBookData);
    }

    /**
     *
     * @param AddressBook update operation
     * @return
     */

    public AddressBook updatePerson(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    /**
     *
     * @param AddressBook delete operation
     * @return
     */

    public String deletePerson(int id) {
        Optional<AddressBook> addressBookEntity = addressBookRepository.findById(id);
        if (addressBookEntity.isPresent()) {
            addressBookRepository.delete(addressBookEntity.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}
