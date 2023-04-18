package com.pythoncall.jpython.controller;

import com.pythoncall.jpython.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/callingPythonFromJava", method = RequestMethod.GET)
    public String callPython(@RequestParam String symptom1, @RequestParam(defaultValue = "coma", required = false) String symptom2,
                             @RequestParam(defaultValue = "coma", required = false) String symptom3, @RequestParam(defaultValue = "coma", required = false) String symptom4,
                             @RequestParam(defaultValue = "coma", required = false) String symptom5) {
        try {
            return Main.callingPythonFromJava(symptom1, symptom2, symptom3, symptom4, symptom5);
        } catch (Exception e) {
            LOGGER.error("Exception in calling ", e);
            return "ExceptionWhileCallingPython";
        }
    }
}
