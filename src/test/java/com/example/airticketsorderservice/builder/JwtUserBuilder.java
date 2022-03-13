package com.example.airticketsorderservice.builder;

import com.example.airticketsorderservice.common.jwt.JwtUser;
import com.example.airticketsorderservice.common.jwt.RoleCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUserBuilder {

    public static JwtUser.JwtUserBuilder withDefault() {
        return JwtUser.builder()
                .id(1)
                .name("小明")
                .roleCode(RoleCode.CUSTOMER.name())
                .username("Jim");
    }
}

