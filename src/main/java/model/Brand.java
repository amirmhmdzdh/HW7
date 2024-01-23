package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {

    private int id;
    private String brandName;
    private String website;
    private String description;

    public Brand(String brandName, String website, String description) {
        this.brandName = brandName;
        this.website = website;
        this.description = description;
    }
}

