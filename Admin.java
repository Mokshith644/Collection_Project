package DataBase;

public class Admin {
	static final private String password="admin@123";

	public static String getPassword() {
		return password;
	} 
	public static void validation(String pw) throws Exception{
		if(!password.equals(pw)) {
			throw  new MyException("Invalid login Credentials");
		}
	}
}
