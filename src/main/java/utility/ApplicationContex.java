package utility;

import connection.JdbcConnection;
import service.UserService;
import userrepository.UserRepository;
import java.sql.Connection;

public class ApplicationContex {

    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;

    static {

        CONNECTION = JdbcConnection.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);
    }
 public static UserService getUserService(){
        return USER_SERVICE;
 }

}
