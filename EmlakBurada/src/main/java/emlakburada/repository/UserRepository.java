package emlakburada.repository;

import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.RealEstate;
import emlakburada.model.User;
import emlakburada.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    private static final List<User> userList = new ArrayList<>();

    @Autowired
    private static AdvertService advertService;

    static {
        userList.add(prepareUser(12345, "Enes Deniz", "enodeniz190@gmail.com", " ", "https://photolink.com", "Bireysel"));
        userList.add(prepareUser(123456, "Selen Toraman", "selentoraman@gmail.com", " ", "https://photolink.com", "Bireysel"));
        userList.add(prepareUser(123457, "Sadettin Deniz", "sadettindeniz@gmail.com", " ", "https://photolink.com", "Bireysel"));
        userList.add(prepareUser(123458, "Hatice Aksu", "haticeaksu@gmail.com", " ", "https://photolink.com", "Bireysel"));

    }

    public List<User> fetchAllUser() {
        return userList;
    }

    private static User prepareUser(int userId, String name, String email, String biyografi,
                                    String photoLink, String userType) {
        User user = new User();
        user.setUserId(userId);
        user.setIsim(name);
        user.setEmail(email);
        user.setBiyografi(biyografi);
        user.setFotograf(photoLink);
        user.setKullaniciTipi(userType);
        return user;
    }

    public User saveUser(User user) {
        userList.add(user);
        System.out.println(user.toString());
        return user;
    }

    public User findUserByUserId(int userId) {
        return userList.stream().filter(user -> user.getUserId() == userId).findAny().orElse(new User());
    }

    public static AdvertResponse prepareFavoriteAdvert(int advertNo){

        AdvertResponse response;

        response = advertService.getAdvertByAdvertId(advertNo);

        return response;

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
