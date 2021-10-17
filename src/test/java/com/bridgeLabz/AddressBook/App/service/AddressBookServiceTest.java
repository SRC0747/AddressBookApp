package com.bridgeLabz.AddressBook.App.service;

import com.bridgeLabz.AddressBook.App.builder.AddressBuilder;
import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import com.bridgeLabz.AddressBook.App.repository.AddressBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to check AddressBookService using @InjectMocks and @Mock building connection with HTTP request.
 * @author Sampriti Roy Chowdhury
 * version 0.0.1
 * @since 15-10-2021
 */

@ExtendWith(MockitoExtension.class)
class AddressBookServiceTest {
    @InjectMocks
    private AddressBookService addressBookService;
    @Mock
    private AddressBookRepository addressBookRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private AddressBuilder addressBuilder;

    @Test
    public void getPersonByID_WhenIdIsGiven() {
        AddressBook addressBookData = new AddressBook();
        addressBookData.setId(1);
        Assertions.assertEquals(1, addressBookData.getId());
    }

    @Test
    public void getPersonByName_WhenNameIsGiven() {
        AddressBook addressBookData = new AddressBook();
        addressBookData.setName("Sam");
        Assertions.assertEquals("Sam", addressBookData.getName());
    }

    @Test
    public void addPersonDetails_WhenDetailingIsAdded() {
        AddressBook addressBookData = new AddressBook();
        addressBookData.setId(1);
        addressBookData.setName("Sam");
        addressBookData.setMobileNo("0747");
        addressBookData.setCity("Kolkata");
        addressBookData.setState("WB");
        addressBookData.setEmail("src@gmail.com");
        Assertions.assertEquals(1, addressBookData.getId());
        assertThat(addressBookData.getName()).isEqualTo("Sam");
        assertThat(addressBookData.getMobileNo()).isEqualTo("0747");
        assertThat(addressBookData.getCity()).isEqualTo("Kolkata");
        assertThat(addressBookData.getState()).isEqualTo("WB");
        assertThat(addressBookData.getEmail()).isEqualTo("src@gmail.com");
    }
}