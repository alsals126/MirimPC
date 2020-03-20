import java.util.Scanner;

//미림PC프로그램 실행문
public class Pcroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int functionnum;
		
		System.out.println("---------------------------------------------");
		System.out.println("☞미림PC에 오신거를 환영합니다☜ \n");
		System.out.println("<번호를 입력해주세요>");
		System.out.println("1.회원     2.비회원     3.회원가입");
		System.out.print("번호 : ");
		functionnum = scan.nextInt();
		
		switch(functionnum) {
		case 1: //회원클래스 불러오기
			member m1 = new member();  
			m1.callMember();
			break;
		case 2: //비회원클래스 불러오기
			Nomember n1 = new Nomember();  
			n1.callNomember();
			break;
		case 3: //회원가입클래스 불러오기
			Signup s1 = new Signup();   
			s1.callSignup();
			break;
		default: //1,2,3이외의 번호를 넣었을때 실행
			System.out.println("번호를 잘못 입력하셨습니다. 다시 실행하세요."); 
			break;  		
		}
	}
	
}

