import java.util.Scanner;

//시간제
public class Part_Time {
	Scanner scan = new Scanner(System.in);
	private final int won1 = 1000, won2 = 2000, won3 = 3000, won5 = 5000, won10 = 10000;
	private int time;	
	
	//생성자 메서드
	public Part_Time() {
		System.out.println("---------------------------------------------");
		System.out.println("<시간제>");
	}	
	public Part_Time(int time) {
		super();
		this.time = time;
	}

	//setter and getter
	public int getWon1() {
		return won1;
	}
	public int getWon2() {
		return won2;
	}
	public int getWon3() {
		return won3;
	}
	public int getWon5() {
		return won5;
	}
	public int getWon10() {
		return won10;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	//번호 선택
	public int choosenum(int result) {
		int choosenum;

		System.out.print("번호입력 : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
		case 1: 
			result = getWon1(); break;			
		case 2:
			result = getWon2(); break;
		case 3:
			result = getWon3(); break;
		case 4:
			result = getWon5(); break;
		case 5:
			result = getWon10(); break;
		case 102: //전(좌석)으로 돌아가기
			Seat s1 = new Seat(); 
			s1.seat();   
			break;
		default : //1,2,3,4,5,102를 제외한 다른 숫자를 입력할 때 실행
			System.out.println("다시입력해주세요."); 
			choosenum(0); 
			break;
		}
		return result;
	}
	
	//시간제 선택하기
	public int ChooseParttime() {
		int result = 0;
		System.out.println("*102 : 취소");
		System.out.println("1번 [ 01:00		 1000원]");
		System.out.println("2번 [ 02:10		 2000원]");
		System.out.println("3번 [ 03:20		 3000원]");
		System.out.println("4번 [ 06:00		 5000원]");
		System.out.println("5번 [ 12:00		10000원] \n");
		
		result = choosenum(result); //choosenum의 result값을 result변수에 넣어
			
		return result; //리턴한다.
	}
}