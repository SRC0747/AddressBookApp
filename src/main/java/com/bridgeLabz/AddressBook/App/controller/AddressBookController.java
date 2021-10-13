package com.bridgeLabz.AddressBook.App.controller;

import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import com.bridgeLabz.AddressBook.App.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    // CRUD
    //read
    //creating
    //updating
    //deleting

    @Autowired
    private AddressBookService addressBookService;


    @GetMapping(value = "/get-person-by-id")
    public AddressBook getPersonById(@RequestParam int id){
        return addressBookService.getPersonById(id);
    }

    @GetMapping(value = "/get-person-by-Name")
    public AddressBook getPersonByName(@RequestParam String name) {
        return addressBookService.getPersonByName(name);
    }

    @PostMapping(value = "/person")
    public AddressBook addPerson(@RequestBody AddressBook addressBookData) {
        return addressBookService.addPerson(addressBookData);
    }

    @PutMapping(value = "/person")
    public AddressBook updatePerson(@RequestBody AddressBook addressBook) {
        return addressBookService.updatePerson(addressBook);
    }

    @DeleteMapping(value = "/person")
    public String deletePerson(@RequestParam int id) {
        return addressBookService.deletePerson(id);
    }

}
