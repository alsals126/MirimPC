import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//memberŬ�������� db������ �ʿ��� �޼������ ��Ƴ��� Ŭ����
class DBmember { 
	static final String USERNAME = "root";
	private static final String PASSWORD = "9970q!q!a!a!";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final int FoundID = 0;
	
	Scanner scan = new Scanner(System.in);
	
	//���̵� ã�� �� ��ȣ�����ϴ� �޼���
	public void chooseNum() {  
		int chooseNum;
		System.out.print("��ȣ : ");
		chooseNum = scan.nextInt();
		
		switch(chooseNum) {  
		case 1 : //Ȯ���� �����ϸ� LoginŬ������ �ҷ���
			Login l1 = new Login();
			l1.callLogin();	
			break;
		case 2 : //��Ҹ� �����ϸ� memberŬ������ �ҷ���
			member m1 = new member();
			m1.callMember();  
			break;
		default : //1,2�� ������ �ٸ� ��ȣ�� ������ ��� ����
			System.out.println("�ٽ��Է����ּ���.");
			chooseNum();  
			break;
		}
	}
	//���̵� ã�� �޼���
	public void FoundID(int choose) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    String email ; //�̸���
		    String number; //��ȭ��ȣ
		         
		    Statement stmt = conn.createStatement();
		    ResultSet rs = null;
		         
		    System.out.println("\n�̸���(1) �Ǵ� ��ȭ��ȣ(2)�� �� �Է��� ���� ��ȣ�� �Է����ּ���");
		    System.out.print("1 or 2 : ");
		    choose = scan.nextInt();
			 
		    switch(choose) {
		    case 1 : //Email�� ���̵�ã��
		    	System.out.println("---------------------------------------------");
		    	System.out.println("<Email�� ���̵� ã��>");
		    	System.out.println("*1.Ȯ��    2.���");
		    	System.out.print("�̸����� �Է����ּ���: "); 
		       	email = scan.next();
		       		 
		       	String sql = "SELECT * FROM java.member where email ='" + email + "';";
		       	rs = stmt.executeQuery(sql);
		       	if(rs.next()) { //���̵� �ִ���(������ if�� ����)
		       		System.out.println("ã���ô� ID�� " + rs.getString("ID") + "�Դϴ�.");}
		       	chooseNum(); 
		       	break;
		    case 2 : //��ȭ��ȣ�� ���̵�ã��
		    	System.out.println("---------------------------------------------");
		    	System.out.println("<��ȭ��ȣ�� ���̵� ã��>");
		    	System.out.println("*1.Ȯ��    2.���");
		    	System.out.print("��ȭ��ȣ�� �Է����ּ���: ");
		       	number = scan.next();
		       		 
		       	sql = "SELECT * FROM java.member where number ='" + number + "';";
		       	rs = stmt.executeQuery(sql);	
		       	if(rs.next()) { //���̵� �ִ���(������ if�� ����)
		       		System.out.println("ã���ô� ID�� " + rs.getString("ID") + "�Դϴ�.");}
		       	chooseNum();
		       	break;
		    default : //1,2�� ������ �ٸ� ��ȣ�� �Է����� �� ����
		    	System.out.println("�ٽ� �Է����ּ���");
		    	FoundID(0); //�ڽ��� �ҷ��� �ݺ�
		    	break; 
		    }
		}catch(Exception e) { 
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}
}

//memberŬ����
public class member{
	private String Name; //�̸�
	private String ID; //���̵�
	private String password; //��й�ȣ
	private String email; //�̸���
	private String number; //��ȭ��ȣ
	Scanner scan = new Scanner(System.in);
	
	//������ �޼���
	public member(String name, String iD, String password, String email, String number) {
		super();
		Name = name;
		ID = iD;
		this.password = password;
		this.email = email;
		this.number = number;
	}
	public member() {}

	//getter and setter
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	//member�� �ҷ������� ��ȣ���ø޼���
	public void choosenum() {
		int choosenum;

		System.out.print("��ȣ : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //�α���Ŭ���� �ҷ�����
	    	Login l1 = new Login();
	    	l1.callLogin();
	    	break;
	    case 2 : //������ ���ư���
	    	Pcroom pc1 = new Pcroom(); 
	    	pc1.main(null); 
	    	break;
	    case 3 : //���̵�ã�� �ҷ�����
	    	DBmember dbm1 = new DBmember();
	    	dbm1.FoundID(0);
	    	break;
	    default : //1,2,3�� ������ ��ȣ�� �������� ��
	    	System.out.println("�ٽ��Է����ּ���. \n"); 
	    	choosenum();
	    	break;
		}
	}
	
	//member�� ����� ���� Ŭ����
	public void callMember() {
		// TODO Auto-generated method stub
		DBmember m1 = new DBmember();
		
		System.out.println("---------------------------------------------");
		System.out.println("<ȸ��-�α���>");
		System.out.println("*1.�α����ϱ�   2.���    3.���̵�ã��");
		
		choosenum();	
	}
}