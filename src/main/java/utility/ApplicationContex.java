package utility;

import connection.JdbcConnection;
import repository.*;
import service.*;

import java.sql.Connection;

public class ApplicationContex {

    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;
    private static final BrandRepository BRAND_REPOSITORY;
    private static final BrandService BRAND_SERVICE;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final ProductService PRODUCT_SERVICE;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final ShareholderBrandRepo SHAREHOLDER_BRAND_REPO;
    private static final ShareholderBrandService SHAREHOLDER_BRAND_SERVICE;


    static {

        CONNECTION = JdbcConnection.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);

        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);

        CATEGORY_REPOSITORY = new CategoryRepository(CONNECTION);
        CATEGORY_SERVICE = new CategoryService(CATEGORY_REPOSITORY);

        PRODUCT_REPOSITORY = new ProductRepository(CONNECTION);
        PRODUCT_SERVICE = new ProductService(PRODUCT_REPOSITORY);

        SHAREHOLDER_REPOSITORY = new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE = new ShareholderService(SHAREHOLDER_REPOSITORY);

        SHAREHOLDER_BRAND_REPO = new ShareholderBrandRepo(CONNECTION);
        SHAREHOLDER_BRAND_SERVICE = new ShareholderBrandService(SHAREHOLDER_BRAND_REPO);


    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    public static BrandService getBrandService() {
        return BRAND_SERVICE;
    }

    public static CategoryService getCategoryService() {
        return CATEGORY_SERVICE;
    }

    public static ProductService getProductService() {
        return PRODUCT_SERVICE;
    }

   public static ShareholderService getShareholderService(){
        return SHAREHOLDER_SERVICE;
   }

public static ShareholderBrandService getShareholderBrandService(){
        return SHAREHOLDER_BRAND_SERVICE;
}

}

