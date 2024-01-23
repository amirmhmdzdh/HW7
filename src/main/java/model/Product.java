package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id ;
    private String name;
    private int createDate;
    private int category;
    private int brand;


    public Product(String name, int createDate, int category, int brand) {
        this.name = name;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
    }

    public Product(int productId, String name, int createDate, String description, int categoryId, int brandId) {
        this.name = name;
        this.createDate = createDate;
    }

}
