package emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private static int messageId = 8349053;


    public List<MessageResponse> getAllMessages(){

        List<MessageResponse> messageList = new ArrayList<>();
        for (Message message : messageRepository.fetchAllMessages()) {
            messageList.add(convertToMessageResponse(message));
        }
        return messageList;

    }

    public MessageResponse saveMessage(MessageRequest request) {
        Message savedMessage = messageRepository.saveMessage(convertToUser(request));
        return convertToMessageResponse(savedMessage);
    }

    public MessageResponse getMessageByMessageId(int messageId) {
        Message message = messageRepository.findeMessageByMessageId(messageId);
        return convertToMessageResponse(message);
    }

    private MessageResponse convertToMessageResponse(Message savedMessage) {
        MessageResponse response = new MessageResponse();

        response.setMessageId(savedMessage.getMessageId());
        response.setBaslik(savedMessage.getBaslik());
        response.setIcerigi(savedMessage.getIcerigi());
        response.setGonderici(savedMessage.getGonderici());
        response.setAlici(savedMessage.getAlici());
        response.setGonderilenTarih(savedMessage.getGonderilenTarih());
        response.setOkunduguTarihi(savedMessage.getOkunduguTarihi());

        return response;
    }

    private Message convertToUser(MessageRequest request) {
        Message message = new Message();
        messageId += 10;

        message.setMessageId(messageId);
        message.setBaslik(request.getBaslik());
        message.setIcerigi(request.getIcerigi());
        message.setAlici(request.getAlici());
        message.setGonderici(request.getGonderici());
        return message;
    }
}
