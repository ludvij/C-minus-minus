package visitor.codeGeneration.cg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class OutFileSingleton {

	private static OutFileSingleton instance;

	private BufferedWriter outFile;


	private OutFileSingleton() {}

	public static OutFileSingleton getInstance() {
		if (instance == null)
			instance = new OutFileSingleton();
		return instance;
	}

	public void open(String filename) {
		try {
			outFile = new BufferedWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String txt) {

		try {
			outFile.write(txt);
			outFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
