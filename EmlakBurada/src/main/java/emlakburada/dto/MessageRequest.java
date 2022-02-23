package emlakburada.dto;

import emlakburada.model.User;
import lombok.Data;

@Data
public class MessageRequest {

    private String baslik;
    private String icerigi;
    private User gonderici;
    private User alici;
}
