package com.example.purchase.order;

import com.example.purchase.order.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
class RequestController {
    @Autowired
    RequestService requestService;

    @PostMapping("/purchaseOrder")
    private RequestDto saveRequest(@RequestBody RequestDto requestDto){
        requestService.saveRequest(requestDto);
        return requestDto;
    }

    @GetMapping("/purchaseOrder")
    private List<Request> getRequest(@RequestParam(required = false) String itemName, @RequestParam(required = false) String itemColor, @RequestParam(required = false) String po, @RequestParam(required = false) String date){
        return requestService.getRequests( itemName, itemColor, po, date);
    }

    @PutMapping("/purchaseOrder/{id}")
    private ResponseEntity<Object> updateRequest(@PathVariable int id, @RequestBody Request request){
        return requestService.updateRequest(id,request);
    }

}
