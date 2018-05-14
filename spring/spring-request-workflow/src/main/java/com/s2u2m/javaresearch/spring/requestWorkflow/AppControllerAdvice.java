package com.s2u2m.javaresearch.spring.requestWorkflow;

import com.s2u2m.javaresearch.spring.requestWorkflow.utils.propertyeditor.TestProperty;
import com.s2u2m.javaresearch.spring.requestWorkflow.utils.propertyeditor.TestPropertyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * class AppControllerAdvice
 *
 * @author xiayy860612
 * @date 2018/5/13
 */
@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String handleEx(RuntimeException rex) {
        return rex.getMessage();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(TestProperty.class, new TestPropertyEditor());
    }
}
