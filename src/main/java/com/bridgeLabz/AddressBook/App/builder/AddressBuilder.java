package com.bridgeLabz.AddressBook.App.builder;

import com.bridgeLabz.AddressBook.App.DTO.AddressBookDTO;
import com.bridgeLabz.AddressBook.App.entity.AddressBook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * AddressBuilder builds the AddressBookData Entity Configuration with HTTP request response in application
 * @author Sampriti Roy Chowdhury
 * version 0.0.1
 * @since 15-10-2021
 */

@Component
public class AddressBuilder {
    public AddressBook buildDO(AddressBookDTO addressBookDTO) {
        AddressBook addressBookDO = new AddressBook();
        BeanUtils.copyProperties(addressBookDTO, addressBookDO);
        return addressBookDO;
    }
}
