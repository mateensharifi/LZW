import java.io.IOException;

public class LZWTester {
	public static void main (String [] args) throws IOException {
		LZW test = new LZW();
			test.encode("abcabcabcabcabcabcabcabcabcabcabcabc", 10);

	}
}
