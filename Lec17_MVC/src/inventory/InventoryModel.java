package inventory;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryModel {
	private int id;
	private String itemName;
	private int price;
	private int count;
	private LocalDateTime time;
	
	@Override
	public String toString() {
		return "------------------------------\n"+
				id + " | "+ 
				itemName + " | "+
				price + "원" + " | "+
				count + "개" + " | "+
				time;
	}
}
