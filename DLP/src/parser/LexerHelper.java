package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}

	public static char lexemeToChar(String str) {
		String value = str.replaceAll("'", "");
		if (value.equals("\\n")) {
			return '\n';
		}
		else if (value.equals("\\t")) {
			return '\t';
		}
		else if (value.charAt(0) == '\\' && Character.isDigit(value.charAt(1))) {
			return (char)Integer.parseInt(value.substring(1));
		}
		else return value.charAt(0);
	}
	
}
