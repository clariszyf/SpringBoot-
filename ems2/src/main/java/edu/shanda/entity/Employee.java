package edu.shanda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private String images;
    private Integer department_id;
    private Department department;
}
