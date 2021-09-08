import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LZW {
	private BufferedReader reader;
	private HashMap<Integer, Character> dictionary;
	public LZW(String inputFileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(inputFileName));
		dictionary = new HashMap<Integer, Character>();
	}
	
}
