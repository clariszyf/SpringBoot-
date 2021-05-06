package edu.shanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Admin {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private String gender;
}
