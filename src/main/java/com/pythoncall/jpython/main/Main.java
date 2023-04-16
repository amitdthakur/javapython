package com.pythoncall.jpython.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static String callingPythonFromJava(String symptom1, String symptom2, String symptom3,
      String symptom4, String symptom5) throws Exception {
    ProcessBuilder processBuilder = new ProcessBuilder("python",
        //Program name and arguments
        resolvePythonScriptPath("FinalProgram.py"), symptom1, symptom2, symptom3, symptom4,
        symptom5);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    List<String> results = readProcessOutput(process.getInputStream());
    LOGGER.info("Output {}", results);
    return results.get(0);
  }

  private static List<String> readProcessOutput(InputStream inputStream) throws IOException {
    try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
      return output.lines()
          .collect(Collectors.toList());
    }
  }

  private static String resolvePythonScriptPath(final String filename) {
    File file = new File("src/main/resources/" + filename);
    return file.getAbsolutePath();
  }


}
