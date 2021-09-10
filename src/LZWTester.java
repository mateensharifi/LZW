import java.io.IOException;

public class LZWTester {
	public static void main (String [] args) {
		LZW test = new LZW();
		try {
			test.encode("abcabcabcabcabcabcabcabcabcabcabcabc", 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
