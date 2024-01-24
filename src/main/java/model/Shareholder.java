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
    private String phoneNumber;
    private String nationalCode;
    private int brand;

    public Shareholder(String name, String phoneNumber, int brand) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.brand = brand;
    }

    public Shareholder(int id, String name, String phoneNumber, String nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.id = id;
    }

    public Shareholder(String name, String phoneNumber, String nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }
}
