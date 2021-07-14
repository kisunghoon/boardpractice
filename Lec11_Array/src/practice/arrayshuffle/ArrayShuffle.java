package practice.arrayshuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayShuffle {

	public static void main(String[] args) {
		String str = "강태민\r\n"
				+ "공석원\r\n"
				+ "기성훈\r\n"
				+ "김도균\r\n"
				+ "김병진\r\n"
				+ "김성중\r\n"
				+ "문혜진\r\n"
				+ "박새별\r\n"
				+ "박수지\r\n"
				+ "박영광\r\n"
				+ "박재현\r\n"
				+ "박정희\r\n"
				+ "안수빈\r\n"
				+ "유지원\r\n"
				+ "이민규\r\n"
				+ "이삭\r\n"
				+ "임동혁\r\n"
				+ "임동희\r\n"
				+ "임장호\r\n"
				+ "임희은\r\n"
				+ "정민철\r\n"
				+ "정을영\r\n"
				+ "조세창\r\n"
				+ "조호철\r\n"
				+ "최유진";
		
		String [] arr = str.split("\\s+");
		List<String> list = Arrays.asList(arr);  // 배열 -> List<> 로 변환
		Collections.shuffle(list);  // 무작위 섞기

		System.out.println(list);
	}

}
