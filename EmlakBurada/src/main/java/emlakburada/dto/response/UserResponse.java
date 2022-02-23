package emlakburada.dto.response;

import emlakburada.model.Advert;
import emlakburada.model.Message;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserResponse {

    private int userId;
    private String kullaniciTipi;
    private String isim;
    private String email;
    private String fotograf;
    private String biyografi;
    private Set<Advert> favoriteAdvert;

}
