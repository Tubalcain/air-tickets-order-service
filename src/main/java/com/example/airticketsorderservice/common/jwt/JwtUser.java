package com.example.airticketsorderservice.common.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtUser {
    private Integer id;

    private String username;

    private String roleCode;

    private String name;

    private List<String> privileges;

    private List<GroupDTO> groups;
}
