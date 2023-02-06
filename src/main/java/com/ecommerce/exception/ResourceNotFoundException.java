package com.ecommerce.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String resourceName, String resourceParam, Long resourceParamValue) {
        super(resourceName+" "+resourceParam+" "+Long.toString(resourceParamValue));
    }
}