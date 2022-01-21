package com.dreamcoffee.spring.boot.demo.config;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.DefaultGraphQLErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomGraphQLErrorHandler extends DefaultGraphQLErrorHandler {

    @Override
    protected boolean isClientError(GraphQLError error) {
        return true;
    }
}
