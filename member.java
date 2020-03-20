import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//member클래스에서 db에관해 필요한 메서드들을 모아놓은 클래스
class DBmember { 
	static final String USERNAME = "root";
	private static final String PASSWORD = "9970q!q!a!a!";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final int FoundID = 0;
	
	Scanner scan = new Scanner(System.in);
	
	//아이디를 찾은 후 번호선택하는 메서드
	public void chooseNum() {  
		int chooseNum;
		System.out.print("번호 : ");
		chooseNum = scan.nextInt();
		
		switch(chooseNum) {  
		case 1 : //확인을 선택하면 Login클래스를 불러옴
			Login l1 = new Login();
			l1.callLogin();	
			break;
		case 2 : //취소를 선택하면 member클래스를 불러옴
			member m1 = new member();
			m1.callMember();  
			break;
		default : //1,2를 제외한 다른 번호를 선택한 경우 실행
			System.out.println("다시입력해주세요.");
			chooseNum();  
			break;
		}
	}
	//아이디를 찾는 메서드
	public void FoundID(int choose) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    String email ; //이메일
		    String number; //전화번호
		         
		    Statement stmt = conn.createStatement();
		    ResultSet rs = null;
		         
		    System.out.println("\n이메일(1) 또는 전화번호(2)를 중 입력할 것의 번호를 입력해주세요");
		    System.out.print("1 or 2 : ");
		    choose = scan.nextInt();
			 
		    switch(choose) {
		    case 1 : //Email로 아이디찾기
		    	System.out.println("---------------------------------------------");
		    	System.out.println("<Email로 아이디 찾기>");
		    	System.out.println("*1.확인    2.취소");
		    	System.out.print("이메일을 입력해주세요: "); 
		       	email = scan.next();
		       		 
		       	String sql = "SELECT * FROM java.member where email ='" + email + "';";
		       	rs = stmt.executeQuery(sql);
		       	if(rs.next()) { //아이디가 있는지(있으면 if문 실행)
		       		System.out.println("찾으시는 ID는 " + rs.getString("ID") + "입니다.");}
		       	chooseNum(); 
		       	break;
		    case 2 : //전화번호로 아이디찾기
		    	System.out.println("---------------------------------------------");
		    	System.out.println("<전화번호로 아이디 찾기>");
		    	System.out.println("*1.확인    2.취소");
		    	System.out.print("전화번호를 입력해주세요: ");
		       	number = scan.next();
		       		 
		       	sql = "SELECT * FROM java.member where number ='" + number + "';";
		       	rs = stmt.executeQuery(sql);	
		       	if(rs.next()) { //아이디가 있는지(있으면 if문 실행)
		       		System.out.println("찾으시는 ID는 " + rs.getString("ID") + "입니다.");}
		       	chooseNum();
		       	break;
		    default : //1,2를 제외한 다른 번호를 입력했을 때 실행
		    	System.out.println("다시 입력해주세요");
		    	FoundID(0); //자신을 불러와 반복
		    	break; 
		    }
		}catch(Exception e) { 
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}
}

//member클래스
public class member{
	private String Name; //이름
	private String ID; //아이디
	private String password; //비밀번호
	private String email; //이메일
	private String number; //전화번호
	Scanner scan = new Scanner(System.in);
	
	//생성자 메서드
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
	
	//member를 불러왔을때 번호선택메서드
	public void choosenum() {
		int choosenum;

		System.out.print("번호 : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //로그인클래스 불러오기
	    	Login l1 = new Login();
	    	l1.callLogin();
	    	break;
	    case 2 : //앞으로 돌아가기
	    	Pcroom pc1 = new Pcroom(); 
	    	pc1.main(null); 
	    	break;
	    case 3 : //아이디찾기 불러오기
	    	DBmember dbm1 = new DBmember();
	    	dbm1.FoundID(0);
	    	break;
	    default : //1,2,3을 제외한 번호를 선택했을 때
	    	System.out.println("다시입력해주세요. \n"); 
	    	choosenum();
	    	break;
		}
	}
	
	//member의 기능을 담은 클래스
	public void callMember() {
		// TODO Auto-generated method stub
		DBmember m1 = new DBmember();
		
		System.out.println("---------------------------------------------");
		System.out.println("<회원-로그인>");
		System.out.println("*1.로그인하기   2.취소    3.아이디찾기");
		
		choosenum();	
	}
}