package com.urp.exception;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2018/5/22.
 */
public class FormFieldException extends PlatformException {
    List<FieldError> errors = new ArrayList<>();

    public FormFieldException() {
        super();
    }


    public FormFieldException(String objectName,String field,String error) {
        super("field "+field+" "+error);
        FieldError fields = new FieldError(objectName,field,error);
        errors.add(fields);

    }

    public List<FieldError> getErrors() {
        return errors;
    }


    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
