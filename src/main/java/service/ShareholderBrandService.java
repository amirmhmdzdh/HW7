package service;

import model.Shareholder;
import model.ShareholderBrand;
import repository.ProductRepository;
import repository.ShareholderBrandRepo;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandService {

    private final Scanner scanner = new Scanner(System.in);
    private final ShareholderBrandRepo shareholderBrandRepo;

    public ShareholderBrandService(ShareholderBrandRepo shareholderBrandRepo) {
        this.shareholderBrandRepo = shareholderBrandRepo;
    }

    public void create() throws SQLException {

        System.out.println("please enter brandId");
        int Bid = scanner.nextInt();

        System.out.println("please enter ShareholderId");
        int Sid = scanner.nextInt();


        ShareholderBrand shareholderBrand = new ShareholderBrand(Bid, Sid);
        int result = shareholderBrandRepo.addCreate(shareholderBrand);

        if (result == 1)
            System.out.println("you successfully added :)");
        else
            System.out.println("something is wrong :/");
    }


}
