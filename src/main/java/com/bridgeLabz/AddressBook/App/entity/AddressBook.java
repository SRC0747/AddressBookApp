package com.bridgeLabz.AddressBook.App.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * AddressBookEntity setting up Entity Configuration related with database table in application
 * @author Sampriti Roy Chowdhury
 * version 0.0.1
 * @since 15-10-2021
 */

@Data
@Entity
public class AddressBook {
    @Id
    private int id;
    private String name;
    private int mobileNo;
    private String state;
    private String city;
    private String email;
}
