import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.io.*;

//LoginŬ�������� db������ �ʿ��� �޼������ ��Ƴ��� Ŭ����
class LoginDB{
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9970q!q!a!a!";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
    
    Properties info = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs = null;
    
    public LoginDB() {// connection��ü�� �����ؼ� ��� ��������
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//          System.out.println("���Ἲ��");
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Ŭ���� ���� ����!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("���� ����!!");
        }
    }
    
    //db�� �����Ͽ� �α����ϱ�
    public int letLogin() {
    	Login l1 = new Login();
    	
    	System.out.println("---------------------------------------------");
    	System.out.println("<ȸ��-�α���>");
    	System.out.println("*1.Ȯ��   2.���");
    	l1.setID();
    	l1.setPW();
    	String id = l1.getID();
    	String pw = l1.getPW();
    	int result = 1;
    	
    	try {
            stmt = conn.createStatement();
            sql = "select * from java.member where ID='" + id + "';";
            rs = stmt.executeQuery(sql); 
 
            if (rs.next() == false || (id.isEmpty()) == true) { // id�� ����x
                result = 1;
            } else {
                sql = "select * from java.member where ID='" + id + "';";
                rs = stmt.executeQuery(sql);
                while (rs.next() == true) {         // ��������
                    if(rs.getString(3).equals(pw)) {  // pw�� ������ ��
                		result = 0;                 // ������ �α��� ����
                		try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("id.txt"));
                            writer.write(id);
                            writer.close();
                        } catch(Exception ex) {
                        
                        }
                    }else                 // ���̵�°��� pw�� �ٸ����
                        result = 1;
                }
            }
        } catch (Exception ee) {
            System.out.println("��������");
            ee.printStackTrace();
        }
        return result;
    }
}

//LoginŬ����
public class Login{
	private String ID;
	private String PW;
	Scanner scan = new Scanner(System.in);
	
	//������ �޼���
	public Login(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
	}
	public Login() {}

	//getter and setter
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setID() {
		System.out.print("ID : ");
		ID = scan.next();
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}	
	public void setPW() {
		System.out.print("PW : ");
		PW = scan.next();
	}
	
	//��ȣ����
	public void choosenum() {
		int choosenum;

		System.out.print("\n��ȣ : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //�¼����úҷ�����
	    	System.out.println("\n�α��� �Ǿ����ϴ�.");	
	    	Seat s1 = new Seat();
	    	s1.callSeat();
	    	break;
	    case 2 : //��(ó��)���� ���ư���
	    	Pcroom p1 = new Pcroom();
	    	p1.main(null);
	    	break;
	    default : //1,2�� ������ ��ȣ�� �������� �� ����
	    	System.out.println("�ٽ��Է����ּ���. \n"); 
	    	choosenum(); 
	    	break;
		}
	}
	
	//Login�� ����� ���� Ŭ����
	public void callLogin() {
		LoginCheck lc = new LoginCheck();
		
		lc.checkpwid();				
	}
}

//LoginCheckŬ����
class LoginCheck {
	private LoginDB ldb = new LoginDB();
	private Login l1 = new Login();
	private int num;
	
	Scanner scan = new Scanner(System.in);
	
	//��ȣ����
	public void choosenum() {
		int choosenum;
		System.out.print("��ȣ : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
		case 1 : //checkpwid�޼��� �ҷ���
			checkpwid();
			break;
		case 2 : //��(ó��)���� ���ư���
			Pcroom p1 = new Pcroom();
		 	p1.main(null);
		 	break;
		default : //1,2�� �ƴ� �ٸ� ��ȣ�� �������� �� ����
			System.out.println("�ٽ��Է����ּ���. \n"); 
			choosenum(); 
			break;
		}
	}
	
	//�α����� �� �Ǿ����� �ȵǾ����� �˷��ִ� �޼���
	public void checkpwid() {
		this.num = ldb.letLogin();
		if(num == 0) { 
			l1.choosenum();		
		}else if(num == 1){
			System.out.println("ID �Ǵ� PW�� Ȯ�����ּ���.");
			this.choosenum();
			checkpwid();
		}
	}
}