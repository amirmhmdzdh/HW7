package service;

import model.ShareholderBrand;
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

    public void editeShareholderBrand() throws SQLException {

        System.out.println("please enter your ShareholderBrand Id: ");
        int id = scanner.nextInt();

        ShareholderBrand shareholderBrand = load(id);

        System.out.println("please enter brandId: ");
        int BId = scanner.nextInt();

        shareholderBrand.setBrand(BId);

        System.out.println("please enter ShareholderId: ");
        int CId = scanner.nextInt();

        shareholderBrand.setShareholder(CId);

        shareholderBrandRepo.editeShareholderBrand(shareholderBrand);
        System.out.println(shareholderBrand);

    }

    private ShareholderBrand load(int id) throws SQLException {

        ShareholderBrand shareholderBrand = shareholderBrandRepo.load(id);
        return shareholderBrand;
    }

    public void deleteShareholderBrand() throws SQLException {

        System.out.println("enter shareholderId that you want delete :");
        int id = scanner.nextInt();

        ShareholderBrand shareholderBrand = load(id);
        shareholderBrandRepo.deleteShareholderBrand(shareholderBrand);


    }


}