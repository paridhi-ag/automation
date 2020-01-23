package program;

public class StringMerge {
	public static String merge(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		for(int i=0; i < s1.length() || i < s2.length(); i++) {
			if(i < s1.length())
				result.append(s1.charAt(i));
			if(i < s2.length())
				result.append(s2.charAt(i));
			
			
		}
			
		return result.toString();
		

	}
		public static void main(String[] args) {
			String s1="abc";
			String s2="123";
			System.out.println(merge(s1,s2));
			
	}

}
