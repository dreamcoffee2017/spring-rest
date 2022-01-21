package com.dreamcoffee.spring.boot.demo.user.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class User {

    @NonNull String id;
    String name;
    String email;
}
