package com.matrix.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contact") // base path for contact endpoints
@CrossOrigin(origins = "*")
public class ContactController {

    // In-memory list to store contacts
    private final List<Contact> contacts = new ArrayList<>();

    // Health check for ContactController
    @GetMapping("/health")
    public String health() {
        return "✅ ContactController is running!";
    }

    // Create a new contact
    @PostMapping("/save")
    public Contact createContact(@RequestBody Contact contact) {
        if (contact.getName() == null || contact.getEmail() == null) {
            throw new IllegalArgumentException("Name and Email are required");
        }
        contacts.add(contact); // save in memory instead of DB
        return contact;
    }

    // List all contacts
    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contacts;
    }

    // Simple Contact class inside controller (can also make it a separate file)
    public static class Contact {
        private String name;
        private String email;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
