package emlakburada.controller;

import emlakburada.client.request.BannerRequest;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.MessageResponse;
import emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/messages")
    public ResponseEntity<List<MessageResponse>> getAllMessages(){

        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.CREATED);

    }

    @PostMapping(value = "/messages")
    public ResponseEntity<MessageResponse> createMessages(@RequestBody MessageRequest request) {

        return new ResponseEntity<>(messageService.saveMessage(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/messages/{messageId}")
    public ResponseEntity<MessageResponse> getMesageByMessageId(@PathVariable(required = false) int messageId) {
        return new ResponseEntity<>(messageService.getMessageByMessageId(messageId), HttpStatus.OK);
    }
}
