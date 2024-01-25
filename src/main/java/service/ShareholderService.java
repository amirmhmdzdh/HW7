package service;

import model.Shareholder;
import repository.ShareholderRepository;
import utility.ApplicationContex;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {

    private final Scanner scanner = new Scanner(System.in);
    private final ShareholderRepository shareholderRepository;
    private final ShareholderBrandService shareholderBrandService = ApplicationContex.getShareholderBrandService();

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void signUp() throws SQLException {

        System.out.println("please enter your name: ");
        String name = scanner.next();

        System.out.println("please enter your phoneNumber: ");
        String phoneNumber = scanner.next();


        String nationalCode;
        while (true) {
            System.out.println("please enter your nationalCode:");
            nationalCode = scanner.next();

            if (Validation.isValidnatioalCode(nationalCode))
                break;
            else
                System.out.println("please enter a correct nationalCode");
        }

        Shareholder shareholder = new Shareholder(name, phoneNumber, nationalCode);
        int result = shareholderRepository.signUp(shareholder);

        if (result == 1)
            System.out.println(name + "you successfully is signup :)");
        else
            System.out.println("something is wrong :/");


    }

    public void signIn() throws SQLException {
        System.out.println("please enter your name:");
        String userName = scanner.next();

        System.out.println("please enter your nationalCode:");
        String nationalCode = scanner.next();

        Shareholder shareholder = shareholderRepository.findShareholder(nationalCode);
        if (shareholder == null)
            System.out.println("please register first");

        else if (!shareholder.getNationalCode().equals(nationalCode)) {
            System.out.println("please enter correct password");
        } else
            System.out.println("WELCOME " + shareholder.getName());
        System.out.println();

    }

    public void editeShareholder() throws SQLException {

        System.out.println("please enter your Shareholder Id: ");
        int id = scanner.nextInt();

        Shareholder shareholder = load(id);

        System.out.println("please enter your Shareholder name:");
        String Name = scanner.next();

        shareholder.setName(Name);

        System.out.println("please enter your Shareholder phoneNumber:");
        String phoneNumber = scanner.next();

        shareholder.setName(phoneNumber);

        System.out.println("please enter your Shareholder nationalCode:");
        String nationalCode = scanner.next();

        shareholder.setName(nationalCode);

        shareholderRepository.editeshareholder(shareholder);
        System.out.println(shareholder);

    }

    private Shareholder load(int id) throws SQLException {

        Shareholder shareholder = shareholderRepository.load(id);
        return shareholder;
    }

    public void deleteShareholder() throws SQLException {

        System.out.println(" enter shareholderId that you want delete : ");
        int id = scanner.nextInt();

        Shareholder shareholder = load(id);
        if (shareholder != null) {

            shareholderBrandService.deleteShareholderId(id);
            shareholderRepository.deleteShareholder(shareholder);
            System.out.println("Brand deleted successfully");
        } else {
            System.out.println("Brand not found");
        }


    }
}