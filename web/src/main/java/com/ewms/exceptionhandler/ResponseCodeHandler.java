package com.ewms.exceptionhandler;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component("ResponseCodeHandler")
public class ResponseCodeHandler {
    private static final String UNMAPPED_MSG = "UNMAPPED_EXCEPTION";
    private static final String ERRORS_NULL_MSG = "ResponseCodeHandler.resolve errors is NULL!";
    private static final String THROWABLE_NULL_MSG = "ResponseCodeHandler.resolve throwable is NULL!";
    private Map<Class, String> exceptions = new HashMap<>();


    //Methods
   /* @PostConstruct
    private void init() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(PhenixExceptionCode.class));

        Set<BeanDefinition> bds = provider.findCandidateComponents("com.uscs.ewms");
        for (BeanDefinition bd : bds) {
            getMapping(Class.forName(bd.getBeanClassName()));
        }

        LOGGER.info(toString());
    }*/


    public Map<String, String> resolve(Errors errors) {
        if (errors == null) {
            throw new IllegalArgumentException(ERRORS_NULL_MSG);
        }
         return errors.getAllErrors()
                .stream().map(ex -> (FieldError)ex)
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        exceptions.keySet()
                .forEach(clazz -> sb.append(clazz.getSimpleName()).append(" "));
        return sb.toString();
    }


    private void getMapping(Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!clazz.isEnum()) {
            throw new IllegalArgumentException(clazz.getName() + " must be enum!");
        }

        Method clazzMethod = clazz.getMethod("getClazz");
        Object[] enums = clazz.getEnumConstants();

        if (enums != null) {
            for (Object o : enums) {
                exceptions.put((Class) clazzMethod.invoke(o), o.toString());
            }
        }
    }
}
