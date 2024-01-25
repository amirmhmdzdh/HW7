package service;

import model.Brand;
import model.Category;
import model.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    private final Scanner scanner = new Scanner(System.in);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void findallbrand() throws SQLException {
        Brand[] brands = productRepository.findAll();

        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    public void findallcategory() throws SQLException {
        Category[] categories = productRepository.findAllC();

        for (Category category : categories) {
            System.out.println(category);
        }
    }


    public void createProduct() throws SQLException {

        System.out.print("Please enter the name of the product you want: ");
        String name = scanner.next();

        System.out.println("Please enter your productDate: ");
        int createDate = scanner.nextInt();

        findallcategory();
        findallbrand();

        System.out.println("please enter brandId");
        int Bid = scanner.nextInt();

        System.out.println("please enter categoryId");
        int Cid = scanner.nextInt();

        Product product = new Product(name, createDate, Bid, Cid);


        int result = productRepository.createProduct(product);
        if (result == 1)
            System.out.println(name + "you successfully created :)");
        else
            System.out.println("something is wrong :/");


    }

    public void editeProduct() throws SQLException {

        System.out.println("please enter your Product Id: ");
        int id = scanner.nextInt();

        Product product = load(id);

        System.out.println("please enter your Product name:");
        String productName = scanner.next();

        product.setName(productName);

        System.out.println("Please enter your productDate: ");
        int createDate = scanner.nextInt();

        product.setCreateDate(createDate);

        System.out.println("please enter categoryId: ");
        int CId = scanner.nextInt();

        product.setCategory(CId);

        System.out.println("please enter brandId: ");
        int BId = scanner.nextInt();

        product.setBrand(BId);

        productRepository.editeProduct(product);
        System.out.println(product);

    }

    private Product load(int id) throws SQLException {

        Product product = productRepository.load(id);
        return product;
    }

    public void deleteBrandId(int brandid) throws SQLException {

        productRepository.deleteBrandId(brandid);
    }

    public void deleteCategoryId(int categoryid) throws SQLException {

        Product product = load(categoryid);
        productRepository.deleteCategoryId(categoryid);


    }

    public void deleteProduct() throws SQLException {

        System.out.println("enter productId that you want delete :");
        int id = scanner.nextInt();

        Product product = load(id);
        productRepository.deleteProduct(product);


    }
}


