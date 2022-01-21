package com.dreamcoffee.spring.boot.demo.user.resolver;

import com.dreamcoffee.spring.boot.demo.user.model.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class UserQueryResolver implements GraphQLQueryResolver {

    public User getUser(@NotBlank String id) {
        return null;
    }
}
