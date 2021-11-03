package expert.ai.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.expert.nlapi.exceptions.NLApiException;
import expert.ai.entity.ResultAnalyze;
import expert.ai.service.ResultAnalyzeService;
import expert.ai.utils.FileReader;

@RestController
@RequestMapping("/api")
public class AnalyzeEndPoint {

	@Autowired
	private ResultAnalyzeService resultAnalyzeService;

	@Autowired
	private FileReader fileReader;

	@Value("${eai.input-folder}")
	private String folder;

	/**
	 * Analyzes files inside the input directory
	 * @return
	 * @throws NLApiException
	 * @throws IOException
	 */
	@GetMapping("/analyze")
	public List<ResultAnalyze> analyzeFiles() throws NLApiException, IOException {
		// Read files from input
		List<File> files = fileReader.readFiles(folder);
		List<ResultAnalyze> results = new ArrayList<>();
		
		// Process file by file 
		for (File file : files) {
			String text = fileReader.extractTextFromFile(file);
			ResultAnalyze resultAnalyze = resultAnalyzeService.createResultAnalyze(text, file.getName());
			results.add(resultAnalyze);
		}
		return results;
	}
	
	/**
	 * Retrieves ResultAnalyze by its id
	 * @param id
	 * @return ResultAnalyze
	 */
	@GetMapping("/analyze/{id}")
	public ResultAnalyze retrieveResultAnalyzeById(@PathVariable("id") Long id) {
		return resultAnalyzeService.findResultAnalyzeById(id);
	}
}
