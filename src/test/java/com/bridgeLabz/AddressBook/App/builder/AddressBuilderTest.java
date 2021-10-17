package com.bridgeLabz.AddressBook.App.builder;

import com.bridgeLabz.AddressBook.App.DTO.AddressBookDTO;
import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for the business logic for AddressBook App Builder service
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 11-10-2021
 */

@ExtendWith(MockitoExtension.class)
class AddressBuilderTest {

    @InjectMocks
    private AddressBuilder addressBuilder;

    @Test
    public void buildDOTest() {
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setName("Sam");
        addressBookDTO.setState("WB");
        AddressBook addressBookDO = addressBuilder.buildDO(addressBookDTO);
        assertEquals("Sam", addressBookDTO.getName());
        assertEquals("WB", addressBookDTO.getState());
        assertEquals("Sam", addressBookDO.getName());
        assertEquals("WB", addressBookDO.getState());
    }
}