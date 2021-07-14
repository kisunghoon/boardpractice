package book.file;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2440058195771035190L;
	
	// 멤버변수
	private int uid;     // 고유 uid 값 ( 1 ~ ) 중복허용X
	private String name;     // 이름
	private Integer price; // 가격
	private String memo;    // 메모
	private LocalDateTime regDate;	 // 등록일
	
	@Override
	public String toString() {
		return String.format("%d] %s : %s : %s : %s",
				uid, name, price, memo, 
				regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
	}
} // end Model
