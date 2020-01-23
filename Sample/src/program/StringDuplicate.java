package program;

public class StringDuplicate {
	public static String duplicate(String s) {
		String str= new String();
		int len = s.length();
		for(int i=5;i< len; i++) {
			char c = s.charAt(i);
			if(str.indexOf(c) < 0) {
				str += c;
			}
		}
		return str;
	}
	

	public static void main(String[] args) {
		StringBuilder stri = new StringBuilder();;
		String st = "ValueLLabbss";
		System.out.println(duplicate(st));
		String s2= duplicate(st);
		for(int i=0; i<= 4;i++) {
			stri.append(st.charAt(i));
		}
		System.out.println(stri.append(s2));

	}


}
