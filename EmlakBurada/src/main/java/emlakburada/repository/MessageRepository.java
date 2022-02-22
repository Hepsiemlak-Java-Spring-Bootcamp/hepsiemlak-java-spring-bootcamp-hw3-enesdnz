package emlakburada.repository;


import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.Message;
import emlakburada.model.User;
import emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class MessageRepository {

    private static final List<Message> messageList = new ArrayList<>();

    @Autowired
    private static MessageService messageService;

    static {
        messageList.add(prepareMessage(234234, "Mesaj 1", "Mesaj İçeriği 1"));
        messageList.add(prepareMessage(534534, "Mesaj 2", "Mesaj İçeriği 2"));
        messageList.add(prepareMessage(657534, "Mesaj 3", "Mesaj İçeriği 3"));
        messageList.add(prepareMessage(234234, "Mesaj 4", "Mesaj İçeriği 4"));
        messageList.add(prepareMessage(652346, "Mesaj 5", "Mesaj İçeriği 5"));
        messageList.add(prepareMessage(988656, "Mesaj 6", "Mesaj İçeriği 6"));
    }

    public List<Message> fetchAllMessages() {
        return messageList;
    }

    private static LocalDate currentTime(){
        LocalDate date = LocalDate.now();

        return date;
    }

    private static Message prepareMessage(int messageId, String baslik, String icerik) {
        Message message = new Message();
        message.setMessageId(messageId);
        message.setBaslik(baslik);
        message.setIcerigi(icerik);
        message.setGonderilenTarih(currentTime());
        return message;
    }

    public Message saveMessage(Message message) {
        messageList.add(message);
        System.out.println(message.toString());
        return message;
    }

    public Message findeMessageByMessageId(int messageId) {
        return messageList.stream().filter(message -> message.getMessageId() == messageId).findAny().orElse(new Message());
    }


    public static Set<Advert> convertToSetAdvert(AdvertResponse response){

        Set<Advert> setAdvert = new HashSet<>();
        Advert advert = new Advert();

        advert.setAdvertNo(response.getAdvertNo());
        advert.setBaslik(response.getBaslik());
        advert.setFiyat(response.getFiyat());
        advert.setKullanici(response.getKullanici());
        advert.setGayrimenkul(response.getGayrimenkul());
        advert.setOlusturulmaTarihi(response.getOlusturulmaTarihi());
        advert.setResimList(response.getResimList());
        advert.setSuresi(response.getSuresi());

        setAdvert.add(advert);

        return setAdvert;

    }
}
