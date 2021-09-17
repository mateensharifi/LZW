import java.io.IOException;

public class LZWTester {
	public static void main (String [] args) throws IOException {
		LZW test = new LZW();
			System.out.println(test.encode("lzw-file1 copy.txt"));

	}
}
