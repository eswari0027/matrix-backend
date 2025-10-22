package com.matrix.controller;

import com.matrix.model.Contact;
import com.matrix.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact") // base path for contact endpoints
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

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
        return contactRepository.save(contact);
    }
}
