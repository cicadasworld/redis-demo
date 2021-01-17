package com.jin.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {// implements Serializable {
    private String name;
    private int age;
}
