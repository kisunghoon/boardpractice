package practice.stddev;  //ppt 12-5

// by. 박수지.
public class StdDev {
	public static void main(String[] args) {	
		int[] num = new int[5];					// 정수 5개 담는 배열 생성
		
		for (int i=0; i<=4; i++) {
			num[i]=((int)(Math.random()*100)+1);		//0~100까지의 랜덤 정수 
			
			System.out.print(num[i]+"\t");
		}
		System.out.println();
		
		double avg = calcAvg(num);			
		System.out.println("평균: " + avg);
		
		double variance = calcVariance(num);
		System.out.println("분산: " + variance);
		
		double sqrt = calcStdDev(num);
		System.out.println("표준편차: " + sqrt);
		
	}// end main	
	
	/*
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 주어진 배열의 '평균값' 리턴
	 */		
	public static double calcAvg (int[] num) {
		int sum = 0;		
		for(int i=0; i < num.length; i++) {
			sum += num[i]; 
		} 		
		double avg = (double) sum / num.length;	
		return avg;		
	} //end calcAvg
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 주어진 배열의 '분산값' 리턴
	 */
	
	/*분산 = 편차제곱의 평균
	//편차제곱 = 편차*편차
	//편차 = 변량-평균
	//변량 = 위에 array로 받은 랜덤 값들
	 */
	public static double calcVariance(int[] num) {
		double variance = 0;	// 편차제곱
		double sum2 = 0;		// 
		double avg = calcAvg(num);
		for (int i=0; i < num.length; i++) {
			sum2 += (num[i]-avg) * (num[i]-avg); 
		}
		variance = sum2 / num.length;
		
		return variance;
	}	

	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */		
	public static double calcStdDev(int[] num) {
		double sqrt = 0;
		sqrt = calcVariance(num);
		
		return Math.sqrt(sqrt);
	}

	
} // end class
