import java.util.Scanner;

//�̸�PC���α׷� ���๮
public class Pcroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int functionnum;
		
		System.out.println("---------------------------------------------");
		System.out.println("�ѹ̸�PC�� ���ŰŸ� ȯ���մϴ٢� \n");
		System.out.println("<��ȣ�� �Է����ּ���>");
		System.out.println("1.ȸ��     2.��ȸ��     3.ȸ������");
		System.out.print("��ȣ : ");
		functionnum = scan.nextInt();
		
		switch(functionnum) {
		case 1: //ȸ��Ŭ���� �ҷ�����
			member m1 = new member();  
			m1.callMember();
			break;
		case 2: //��ȸ��Ŭ���� �ҷ�����
			Nomember n1 = new Nomember();  
			n1.callNomember();
			break;
		case 3: //ȸ������Ŭ���� �ҷ�����
			Signup s1 = new Signup();   
			s1.callSignup();
			break;
		default: //1,2,3�̿��� ��ȣ�� �־����� ����
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �����ϼ���."); 
			break;  		
		}
	}
	
}

