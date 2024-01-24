package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShareholderBrand {

    private int id;
    private int shareholder;
    private int brand;


    public ShareholderBrand(int shareholder, int brand) {
        this.shareholder = shareholder;
        this.brand = brand;
    }
}
