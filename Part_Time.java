import java.util.Scanner;

//�ð���
public class Part_Time {
	Scanner scan = new Scanner(System.in);
	private final int won1 = 1000, won2 = 2000, won3 = 3000, won5 = 5000, won10 = 10000;
	private int time;	
	
	//������ �޼���
	public Part_Time() {
		System.out.println("---------------------------------------------");
		System.out.println("<�ð���>");
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
	
	//��ȣ ����
	public int choosenum(int result) {
		int choosenum;

		System.out.print("��ȣ�Է� : ");
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
		case 102: //��(�¼�)���� ���ư���
			Seat s1 = new Seat(); 
			s1.seat();   
			break;
		default : //1,2,3,4,5,102�� ������ �ٸ� ���ڸ� �Է��� �� ����
			System.out.println("�ٽ��Է����ּ���."); 
			choosenum(0); 
			break;
		}
		return result;
	}
	
	//�ð��� �����ϱ�
	public int ChooseParttime() {
		int result = 0;
		System.out.println("*102 : ���");
		System.out.println("1�� [ 01:00		 1000��]");
		System.out.println("2�� [ 02:10		 2000��]");
		System.out.println("3�� [ 03:20		 3000��]");
		System.out.println("4�� [ 06:00		 5000��]");
		System.out.println("5�� [ 12:00		10000��] \n");
		
		result = choosenum(result); //choosenum�� result���� result������ �־�
			
		return result; //�����Ѵ�.
	}
}