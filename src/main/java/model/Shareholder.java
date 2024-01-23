package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shareholder {
    private int id;
    private String name;
    private int phoneNumber;
    private String nationalCode;


    public Shareholder(String name, int phoneNumber, String nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }
}
