package emlakburada.dto.response;

import emlakburada.model.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MessageResponse {

    private int messageId;
    private String baslik;
    private String icerigi;
    private LocalDate gonderilenTarih;
    private LocalDate okunduguTarihi;
    private boolean gorulduMu;
    private User gonderici;
    private User alici;
}
