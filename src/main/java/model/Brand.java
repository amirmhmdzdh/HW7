package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {

    private int id;
    private String name;
    private String website;
    private String description;

    public Brand(String name, String website, String description) {
        this.name = name;
        this.website = website;
        this.description = description;
    }
}
