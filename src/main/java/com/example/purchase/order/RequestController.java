package com.example.purchase.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
class RequestController {
    @Autowired
    RequestService requestService;

}
