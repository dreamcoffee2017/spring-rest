package com.dreamcoffee.spring.boot.demo.user.resolver;

import com.dreamcoffee.spring.boot.demo.user.model.User;
import com.dreamcoffee.spring.boot.demo.user.model.UserInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class UserMutationResolver implements GraphQLMutationResolver {

    public User createUser(@Valid UserInput input) throws Exception {
        return User.builder().id("1").build();
    }
}
