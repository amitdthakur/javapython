package com.pythoncall.jpython.controller;

import com.pythoncall.jpython.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @RequestMapping(value = "/callingPythonFromJava", method = RequestMethod.GET)
  public String callPython() {
    try {
      return Main.callingPythonFromJava("coma", "coma", "coma", "coma", "coma");
    } catch (Exception e) {
      LOGGER.error("Exception in calling ", e);
      return "ExceptionWhileCallingPython";
    }
  }
}
