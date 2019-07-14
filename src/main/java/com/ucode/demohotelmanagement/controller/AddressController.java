package com.ucode.demohotelmanagement.controller;

import com.ucode.demohotelmanagement.model.Address;
import com.ucode.demohotelmanagement.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/add")
    public String startAddForm(Model model) {
        LOGGER.info("startAddForm: navigate to addAddress");

        model.addAttribute("addressForm", new Address());

        return "address/addAddress";
    }

    @PostMapping("/address/add")
    public String addAddress(@ModelAttribute("addressForm") Address address) {
        LOGGER.info("add address: " + address);

        addressService.addAddress(address);

        return "redirect:/address/list";
    }

    @GetMapping("/address/list")
    public String getAddresses(Model model) {
        LOGGER.info("getAddresses: returning all the addresses ");

        model.addAttribute("addresses", addressService.getAddresses());

        return "address/addressList";
    }

    @GetMapping("/address/delete/{id}")
    public String deleteAddress(@PathVariable int id) {
        LOGGER.info("deleteAddress: with id " + id);

        addressService.removeAddress(id);

        return "redirect:/address/list";
    }

    @GetMapping("/address/edit/{id}")
    public String startEditForm(@PathVariable int id, Model model) {
        LOGGER.info("startEditForm: editing address with id" + id);

        model.addAttribute("addressForm", addressService.getAddress(id));
        model.addAttribute("addressId", id);

        return "address/editAddress";
    }

    @PostMapping("/address/edit/{id}")
    public String editAddress(@ModelAttribute("addressForm") Address address, @PathVariable int id, Model model) {
        LOGGER.info("editAddress: editing address with id" + id);

        addressService.updateAddress(id, address);

        return "redirect:/address/list";
    }

}
