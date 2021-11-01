package com.example.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SlaveInfo implements Serializable {
    private String name;
    private String VenderID;
    private String ProductCode;
    private int position;
    private String pdo_entries;
    private String pdos;
    private String syncs;

}
