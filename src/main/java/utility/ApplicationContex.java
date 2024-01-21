package utility;

import connection.JdbcConnection;
import repository.BrandRepository;
import service.BrandService;
import service.UserService;
import repository.UserRepository;

import java.sql.Connection;

public class ApplicationContex {

    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;
    private static final BrandRepository BRAND_REPOSITORY;
    private static final BrandService BRAND_SERVICE;

    static {

        CONNECTION = JdbcConnection.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);

        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        BRAND_SERVICE=new BrandService(BRAND_REPOSITORY);


    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
    public static BrandService getBrandService() {
        return BRAND_SERVICE;
    }
}
