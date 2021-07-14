package practice.cardcompany;

// by 공석원
public class Company {

	static int cardNum = 10000;
	Card cardInstance; 

	private static Company instance=null;
	public static Company getInstance() {
		if(instance==null) {
			instance = new Company();
		}
		return instance;
	}
	
	
	Card createCard() {
		// TODO Auto-generated method stub
		cardNum++;
		cardInstance = new Card(cardNum);
		return cardInstance;
	}
	
	// 필요한 변수, 메소드, 생성자 정의하기
		
} // end class
