package emlakburada.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	@Setter
	private int messageId;
	private String baslik;
	private String icerigi;
	private LocalDate gonderilenTarih;
	private LocalDate okunduguTarihi;
	private boolean gorulduMu;
	private User gonderici;
	private User alici;

	public Message(String baslik) {
		super();
		this.baslik = baslik;
	}

}
