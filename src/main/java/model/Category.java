package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

    private int id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
