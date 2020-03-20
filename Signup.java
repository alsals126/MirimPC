import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern; //�н����峪 �̸��� Ȯ�ΰ��� ���ڿ� ���� ������ ��Ÿ���� ���� ���

//SignupŬ�������� db������ �ʿ��� �޼������ ��Ƴ��� Ŭ����
class Signup1 {
	 
    private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9970q!q!a!a!";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
  
    public Signup1() {// connection��ü�� �����ؼ� ��� ��������
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
    
    //�Էµ� ȸ�������� DB�� ����
    public void insertProfile() {
    	Signup inforprofile = new Signup();
    	inforprofile.setName();
    	inforprofile.setID();
    	inforprofile.setPW();
    	inforprofile.setPnum();
    	inforprofile.setEmail();
        String sql = "insert into java.member(name, ID, password, email, number) values(?,?,?,?,?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, inforprofile.getName());
            pstmt.setString(2, inforprofile.getID());
            pstmt.setString(3, inforprofile.getPW());
            pstmt.setString(4, inforprofile.getEmail());
            pstmt.setString(5, inforprofile.getPnum());           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

//signup Ŭ����
public class Signup {
	private String name;
	private String ID;
	private String PW;
	private String Pnum;
	private String Email;
	
	Scanner scan = new Scanner(System.in);

	//�����ڸ޼���
	public Signup(String name, String iD, String PW, String pnum, String email) {
		super();
		this.name = name;
		this.ID = iD;
		this.PW = PW;
		this.Pnum = pnum;
		this.Email = email;
	}
	public Signup() {}
	
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setName() {
		System.out.print("�̸� : ");
		name = scan.next();
	}
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
	//��й�ȣ ����Ȯ��
	public void setPW() {
		String confirmPW1, confirmPW2;
		
		System.out.print("��й�ȣ �Է� : ");
		confirmPW1 = scan.next();
		System.out.print("��й�ȣ Ȯ�� : ");
		confirmPW2 = scan.next();
		
		if(confirmPW1.equals(confirmPW2)) {
			this.PW = confirmPW1;
	        System.out.println("<��ġ>");
		}else {
	        System.out.println("<����ġ>");
			setPW();
		}
	}
	public String getPnum() {
		return Pnum;
	}
	public void setPnum(String pnum) {
		Pnum = pnum;
	}
	public void setPnum() {
		System.out.print("��ȭ��ȣ(***-****-****) : ");
		Pnum = scan.next();
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setEmail() {
		System.out.print("�̸��� : ");
		Email = scan.next();
	}
	
	//��ȣ����
	public void choosenum() {
		int choosenum;

		System.out.print("��ȣ : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //member�ҷ�����
	    	member m1 = new member();
	    	m1.callMember();
	    	break;
	    case 2 : //��(ó��)���� ���ư���
	    	Pcroom pc1 = new Pcroom();
	    	System.out.println("");
	    	pc1.main(null);  
	    	break;
	    default : //1,2�� ������ �ٸ���ȣ�� ���õǾ��� �� ����
	    	System.out.println("�ٽ��Է����ּ���. \n");
	    	choosenum(); 
	    	break;
		}
	}
	
	//Signup�� ����� ���� Ŭ����
	public void callSignup() {
	    Signup1 s1 = new Signup1();
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("---------------------------------------------");
	    System.out.println("<ȸ������>");
	    System.out.println("* 1.Ȯ��		2.���");
	   
	    s1.insertProfile();
	    choosenum(); 
	}
}