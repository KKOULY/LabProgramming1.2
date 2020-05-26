import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

	private static void writeText(String wr){
		if (wr == null)
			System.out.print("Введіть дані: ");
		else 
			System.out.print(wr);
	}
	
	public static Long getLong() throws IOException{
		while (true) {
			String s = getString();
			if (s.equals("")) {
				System.out.println("Ви нічого не ввели");
				continue;
			}
			Long value = Long.valueOf(s);
			return value;
		}
	}
	
	public static char getChar(String wr){
		while (true) {
			writeText(wr);
			String s = " ";
			try {
				s = getString();
				if (s.equals("")) {
					System.out.println("Ви нічого не ввели");
					continue;
				}
				if (s.length() > 1) {
					System.out.println("Ви ввели не 1 символ");
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s.charAt(0);
		}
	}
	
	public static Integer getInt(String wr){
		while (true) {
			writeText(wr);
			String s = "";
			try {
				s = getString();
				if (s.equals("")) {
					System.out.println("Ви нічого не ввели");
					continue;
				}
				boolean isNumber = true;
				for(int i =1; i<s.length(); i++) {
					if (!Character.isDigit(s.charAt(i))) {
					isNumber=false;
					i=s.length();
					}
				}
				if (s.charAt(0)!='-' && !Character.isDigit(s.charAt(0)) && s.length()>1){
					isNumber=false;
				}
				if (s.length()==1 && !Character.isDigit(s.charAt(0))){
					isNumber=false;
				}
				if (!isNumber){
					System.out.println("Ви ввели недопустимі символи");
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Integer value = Integer.valueOf(s);
			return value;
		}
	}
	private static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static String getString(String wr) {
		writeText(wr);
		String s = "";
		try {
			s = getString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
