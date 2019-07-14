package com.ucode.demohotelmanagement.service;

import com.ucode.demohotelmanagement.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    private static final List<Address> addresses = new ArrayList<>();

    static {
        addresses.add(new Address("RO", "Cluj", "Eugen", 38, "400", LocalDate.now()));
    }

    public void addAddress(Address address) {
        LOGGER.info("addAddress " + this);

        addresses.add(address);
    }

    public List<Address> getAddresses() {
        LOGGER.info("getAddresses " + this);

        return addresses;
    }

    public void removeAddress(int id) {
        LOGGER.info("removeAddress " + this);

        addresses.remove(id);
    }

    public Address getAddress(int id) {
        LOGGER.info("getAddress " + this);

        return addresses.get(id);
    }

    public void updateAddress(int id, Address address) {
        LOGGER.info("updateAddress " + this);

        addresses.set(id, address);
    }

}
