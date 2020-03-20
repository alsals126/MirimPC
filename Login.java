import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.io.*;

//Login클래스에서 db에관해 필요한 메서드들을 모아놓은 클래스
class LoginDB{
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9970q!q!a!a!";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
    
    Properties info = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs = null;
    
    public LoginDB() {// connection객체를 생성해서 디비에 연결해줌
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//          System.out.println("연결성공");
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("클래스 적재 실패!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("연결 실패!!");
        }
    }
    
    //db와 연동하여 로그인하기
    public int letLogin() {
    	Login l1 = new Login();
    	
    	System.out.println("---------------------------------------------");
    	System.out.println("<회원-로그인>");
    	System.out.println("*1.확인   2.취소");
    	l1.setID();
    	l1.setPW();
    	String id = l1.getID();
    	String pw = l1.getPW();
    	int result = 1;
    	
    	try {
            stmt = conn.createStatement();
            sql = "select * from java.member where ID='" + id + "';";
            rs = stmt.executeQuery(sql); 
 
            if (rs.next() == false || (id.isEmpty()) == true) { // id가 존재x
                result = 1;
            } else {
                sql = "select * from java.member where ID='" + id + "';";
                rs = stmt.executeQuery(sql);
                while (rs.next() == true) {         // 다음값의
                    if(rs.getString(3).equals(pw)) {  // pw와 같은지 비교
                		result = 0;                 // 같으면 로그인 성공
                		try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("id.txt"));
                            writer.write(id);
                            writer.close();
                        } catch(Exception ex) {
                        
                        }
                    }else                 // 아이디는같고 pw가 다른경우
                        result = 1;
                }
            }
        } catch (Exception ee) {
            System.out.println("문제있음");
            ee.printStackTrace();
        }
        return result;
    }
}

//Login클래스
public class Login{
	private String ID;
	private String PW;
	Scanner scan = new Scanner(System.in);
	
	//생성자 메서드
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
	
	//번호선택
	public void choosenum() {
		int choosenum;

		System.out.print("\n번호 : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //좌석선택불러오기
	    	System.out.println("\n로그인 되었습니다.");	
	    	Seat s1 = new Seat();
	    	s1.callSeat();
	    	break;
	    case 2 : //전(처음)으로 돌아가기
	    	Pcroom p1 = new Pcroom();
	    	p1.main(null);
	    	break;
	    default : //1,2를 제외한 번호를 선택했을 때 실행
	    	System.out.println("다시입력해주세요. \n"); 
	    	choosenum(); 
	    	break;
		}
	}
	
	//Login의 기능을 담은 클래스
	public void callLogin() {
		LoginCheck lc = new LoginCheck();
		
		lc.checkpwid();				
	}
}

//LoginCheck클래스
class LoginCheck {
	private LoginDB ldb = new LoginDB();
	private Login l1 = new Login();
	private int num;
	
	Scanner scan = new Scanner(System.in);
	
	//번호선택
	public void choosenum() {
		int choosenum;
		System.out.print("번호 : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
		case 1 : //checkpwid메서드 불러옴
			checkpwid();
			break;
		case 2 : //전(처음)으로 돌아가기
			Pcroom p1 = new Pcroom();
		 	p1.main(null);
		 	break;
		default : //1,2이 아닌 다른 번호를 선택했을 때 실행
			System.out.println("다시입력해주세요. \n"); 
			choosenum(); 
			break;
		}
	}
	
	//로그인이 잘 되었는지 안되었는지 알려주는 메서드
	public void checkpwid() {
		this.num = ldb.letLogin();
		if(num == 0) { 
			l1.choosenum();		
		}else if(num == 1){
			System.out.println("ID 또는 PW를 확인해주세요.");
			this.choosenum();
			checkpwid();
		}
	}
}