package DataBase;

@SuppressWarnings("serial")
public class MyException extends Exception {
	MyException(String msg){
		System.out.println(msg);
	}
}
