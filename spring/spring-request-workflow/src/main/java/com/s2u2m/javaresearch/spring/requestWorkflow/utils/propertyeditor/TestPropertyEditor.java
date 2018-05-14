package com.s2u2m.javaresearch.spring.requestWorkflow.utils.propertyeditor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * class TestPropertyEditor
 *
 * @author xiayy860612
 * @date 2018/5/13
 */
public class TestPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new TestProperty().setValue(text));
        } else {
            setValue(null);
        }
    }
    @Override    public String getAsText() {
        TestProperty isbn = (TestProperty) getValue();
        if (isbn != null) {
            return isbn.getValue();
        } else {
            return "";
        }
    }

}
