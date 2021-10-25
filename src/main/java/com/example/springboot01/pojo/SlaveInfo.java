package com.example.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SlaveInfo {
    private String name;
    private String VenderID;
    private String ProductCode;
    private int position;
    private String pdo_entries;
    private String pdos;
    private String syncs;

}
