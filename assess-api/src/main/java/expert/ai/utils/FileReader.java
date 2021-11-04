package expert.ai.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileReader {

	@Value("${eai.file-size-limit}")
	private int fileSizeLimit;

	/**
	 * Method that extracts text from file
	 * 
	 * @param file
	 * @return Text
	 * @throws IOException
	 */
	public String extractTextFromFile(File file) throws IOException {
		// Extract Data
		String text = new String(Files.readAllBytes(Paths.get(file.getPath())));

		// Check fileSizeLimit
		if (text.length() > fileSizeLimit) {
			text = text.substring(0, fileSizeLimit);
		}
		return text;
	}

	/**
	 * Retrieves all files from a particular directory
	 * 
	 * @param inputFolder
	 * @return List<File>
	 */
	public List<File> readFiles(String inputFolder) {

		File folder = new File(inputFolder);

		File[] listOfFiles = null;
		List<File> files = new ArrayList<>();

		if (!folder.exists()) {
			return files;
		}
		
		listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				files.add(file);
			} else {
				readFiles(file.getPath());
			}
		}
		return files;
	}

}
