import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern; //패스워드나 이메일 확인같은 문자열 제한 조건을 나타내기 위해 사용

//Signup클래스에서 db에관해 필요한 메서드들을 모아놓은 클래스
class Signup1 {
	 
    private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9970q!q!a!a!";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";
  
    public Signup1() {// connection객체를 생성해서 디비에 연결해줌
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
    
    //입력된 회원정보를 DB에 저장
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

//signup 클래스
public class Signup {
	private String name;
	private String ID;
	private String PW;
	private String Pnum;
	private String Email;
	
	Scanner scan = new Scanner(System.in);

	//생성자메서드
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
		System.out.print("이름 : ");
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
	//비밀번호 이중확인
	public void setPW() {
		String confirmPW1, confirmPW2;
		
		System.out.print("비밀번호 입력 : ");
		confirmPW1 = scan.next();
		System.out.print("비밀번호 확인 : ");
		confirmPW2 = scan.next();
		
		if(confirmPW1.equals(confirmPW2)) {
			this.PW = confirmPW1;
	        System.out.println("<일치>");
		}else {
	        System.out.println("<불일치>");
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
		System.out.print("전화번호(***-****-****) : ");
		Pnum = scan.next();
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setEmail() {
		System.out.print("이메일 : ");
		Email = scan.next();
	}
	
	//번호선택
	public void choosenum() {
		int choosenum;

		System.out.print("번호 : ");
		choosenum = scan.nextInt();
		
		switch(choosenum) {
	    case 1 : //member불러오기
	    	member m1 = new member();
	    	m1.callMember();
	    	break;
	    case 2 : //전(처음)으로 돌아가기
	    	Pcroom pc1 = new Pcroom();
	    	System.out.println("");
	    	pc1.main(null);  
	    	break;
	    default : //1,2를 제외한 다른번호가 선택되었을 때 실행
	    	System.out.println("다시입력해주세요. \n");
	    	choosenum(); 
	    	break;
		}
	}
	
	//Signup의 기능을 담은 클래스
	public void callSignup() {
	    Signup1 s1 = new Signup1();
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("---------------------------------------------");
	    System.out.println("<회원가입>");
	    System.out.println("* 1.확인		2.취소");
	   
	    s1.insertProfile();
	    choosenum(); 
	}
}