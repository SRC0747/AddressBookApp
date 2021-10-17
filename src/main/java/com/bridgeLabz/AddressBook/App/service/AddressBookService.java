package com.bridgeLabz.AddressBook.App.service;

import com.bridgeLabz.AddressBook.App.DTO.AddressBookDTO;
import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import com.bridgeLabz.AddressBook.App.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;

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

    public AddressBook getPersonByMobileNo(int mobileNo) {
        Optional<AddressBook> addressBookData = addressBookRepository.findByMobileNo(mobileNo);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }

    public AddressBook getPersonByState(String state) {
        Optional<AddressBook> addressBookData = addressBookRepository.findByState(state);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }

    public AddressBook getPersonByCity(String city) {
        Optional<AddressBook> addressBookData = addressBookRepository.findByCity(city);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }

    public AddressBook getPersonByEmail(String email) {
        Optional<AddressBook> addressBookData = addressBookRepository.findByEmail(email);
        if (addressBookData.isPresent()){
            return addressBookData.get();
        }
        return null;
    }

    /**
     *
     * @param AddressBookDTO add operation
     * @return
     */

    public AddressBook addPerson(AddressBook addressBookData) {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        return addressBookRepository.save(addressBookData);
    }

    /**
     *
     * @param AddressBookDTO update operation
     * @return
     */

    public AddressBook updatePerson(int id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> optionalAddressBookEntity = addressBookRepository.findById(id);
        if(optionalAddressBookEntity.isPresent()) {
            AddressBook addressBookData = optionalAddressBookEntity.get();
            addressBookData.setId(addressBookDTO.getId());
            addressBookData.setName(addressBookDTO.getName());
            addressBookData.setState(addressBookData.getState());
            addressBookData.setCity(addressBookData.getCity());
            addressBookData.setMobileNo(addressBookData.getMobileNo());
            addressBookData.setEmail(addressBookData.getEmail());
            return addressBookRepository.save(addressBookData);
        }
        //return addressBookRepository.save(addressBookData);
        return null;
    }
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
