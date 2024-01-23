package service;

import model.Brand;
import repository.BrandRepository;
import utility.InputValidation;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {

    private final Scanner scanner = new Scanner(System.in);
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void CreateBrand() throws SQLException {

        System.out.print("Please enter the name of the brand you want: ");
        String name = scanner.next();

        String website;
        while (true) {

            System.out.println("Please enter your brand website address: ");
            website = scanner.next();

            if (InputValidation.isValidWebsite(website))
                break;
            else
                System.out.println("please enter correct website");
        }

            System.out.println("Please enter a description of your brand: ");
            String description = scanner.next();

            Brand brand = new Brand(name, website, description);

            int result = brandRepository.CreateBrand(brand);

            if (result == 1)
                System.out.println(name + "you successfully added :)");
            else
                System.out.println("something is wrong :/");

        }

        public void editBrand () throws SQLException {

            System.out.println("please enter your Brand Id: ");
            int id = scanner.nextInt();

            Brand brand = load(id);

            System.out.println("please enter your Brand name: ");
            String BrandName = scanner.next();

            brand.setBrandName(BrandName);

            System.out.println("please enter your Brand website: ");
            String WebsiteBrand = scanner.next();

            brand.setWebsite(WebsiteBrand);

            System.out.println("please enter your Brand description: ");
            String BrandDis = scanner.next();

            brand.setDescription(BrandDis);

            brandRepository.editBrand(brand);
            System.out.println(brand);

//        if (result == 1)
//            System.out.println( BrandName + "you successfully edited :)");
//        else
//            System.out.println("something is wrong :/");

        }

        private Brand load ( int id) throws SQLException {

            Brand brand = brandRepository.load(id);
            return brand;
        }

        public void deleteBrand () throws SQLException {

            System.out.println("enter brandId that you want delete :");
            int id = scanner.nextInt();

            Brand brand = load(id);
            brandRepository.deleteBrand(brand);


        }
    }


