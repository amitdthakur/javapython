package com.pythoncall.jpython.controller;

import com.pythoncall.jpython.main.Main;
import com.pythoncall.jpython.pojo.OutPut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @GetMapping(value = "/pythonfromjava")
  public OutPut callPython(
      @RequestParam(defaultValue = "itching", required = false) String symptom1,
      @RequestParam(defaultValue = "itching", required = false) String symptom2,
      @RequestParam(defaultValue = "itching", required = false) String symptom3,
      @RequestParam(defaultValue = "itching", required = false) String symptom4,
      @RequestParam(defaultValue = "itching", required = false) String symptom5) {
    try {
      LOGGER.info("symptom1 {} , symptom2 {} , symptom3 {} , symptom4 {} , symptom5 {}", symptom1,
          symptom2, symptom3, symptom4, symptom5);
      return Main.callingPythonFromJava(symptom1, symptom2, symptom3, symptom4, symptom5);
    } catch (Exception e) {
      LOGGER.error(
          "Exception in calling python module please check python program under src resources", e);
      return null;
    }
  }
}
