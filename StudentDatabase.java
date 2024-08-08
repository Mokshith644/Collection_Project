package DataBase;

import java.util.Scanner;

public class StudentDatabase {
	
	public static void main(String[] args) throws InterruptedException, MyException {
		System.out.println("Welcome");
		Scanner sc=new Scanner(System.in);
		while(true) {
			new StudentUtil().publicNote(sc);
            System.out.println("Press 1 to terminate or press any other key to continue");
            int n=(int)sc.nextInt();
            if(n==1)break;
		}
		sc.close();
		
	}

}
