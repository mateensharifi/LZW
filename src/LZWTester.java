import java.io.IOException;

public class LZWTester {
	public static void main (String [] args) throws IOException {
		LZW test = new LZW();
			System.out.println(test.encode("abcabcabcabcabcabcabcabcabcabcabcabc", 10));
			System.out.println(test.decode(10));
	}
}
