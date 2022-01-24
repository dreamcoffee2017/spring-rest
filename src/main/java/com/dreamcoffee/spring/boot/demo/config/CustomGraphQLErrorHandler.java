package com.dreamcoffee.spring.boot.demo.config;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.DefaultGraphQLErrorHandler;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

@Component
public class CustomGraphQLErrorHandler extends DefaultGraphQLErrorHandler {

    @Override
    protected boolean isClientError(GraphQLError error) {
        if (!(error instanceof ExceptionWhileDataFetching)) {
            return true;
        }
        Throwable exception = ((ExceptionWhileDataFetching) error).getException();
        return exception instanceof GraphQLError
            || exception instanceof ConstraintViolationException;
    }
}
