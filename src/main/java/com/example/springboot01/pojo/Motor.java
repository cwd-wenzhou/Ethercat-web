package com.example.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Motor {
    private int motorindex;
    private int opmode;
    private int TargetPosition;
    private int TargetTorque;
    private int TargetVelocity;

    private int CurrentPosition;
    private int CurrentTorque;
    private int CurrentVelocity;
}
