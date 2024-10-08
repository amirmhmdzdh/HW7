package repository;

import model.Product;
import model.ShareholderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderBrandRepo {

    private final Connection connection;

    public ShareholderBrandRepo(Connection connection) {
        this.connection = connection;
    }

    public int addCreate(ShareholderBrand shareholderBrand) throws SQLException {

        String addquery = "INSERT INTO shareholder_brand (brand_id,shareholder_id)VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addquery);

        preparedStatement.setInt(1, shareholderBrand.getBrand());
        preparedStatement.setInt(2, shareholderBrand.getShareholder());
        int result = preparedStatement.executeUpdate();

        return result;


    }

    public ShareholderBrand editeShareholderBrand(ShareholderBrand shareholderBrand) throws SQLException {

        String edite = "UPDATE shareholder_brand set brand_id =? , shareholder_id = ?   WHERE id  = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(edite);

        preparedStatement.setInt(1, shareholderBrand.getBrand());
        preparedStatement.setInt(2, shareholderBrand.getShareholder());
        ;
        preparedStatement.setInt(3, shareholderBrand.getId());

        preparedStatement.executeUpdate();
        return shareholderBrand;

    }

    public ShareholderBrand load(int id) throws SQLException {

        String select = "SELECT * FROM shareholder_brand WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(select);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            int shareId = resultSet.getInt("id");
            int brandid = resultSet.getInt("brand_id");
            int holderid = resultSet.getInt("shareholder_id");

            ShareholderBrand shareholderBrand = new ShareholderBrand(shareId, brandid, holderid);

            return shareholderBrand;

        } else return null;

    }
    public void deleteShareholderBrand(ShareholderBrand shareholderBrand) throws SQLException {
        String deleteQuery = "DELETE FROM shareholder_brand WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, shareholderBrand.getId());
        preparedStatement.executeUpdate();
    }
    public void deleteBrandId(int brandId) throws SQLException {

        String DbrandId = "DELETE FROM shareholder_brand WHERE brand_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(DbrandId);
        preparedStatement.setInt(1, brandId);
        preparedStatement.executeUpdate();
    }

    public void deleteShareholderId(int shareholderId) throws SQLException {

        String Dshare = "DELETE FROM shareholder_brand WHERE shareholder_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(Dshare);
        preparedStatement.setInt(1, shareholderId);
        preparedStatement.executeUpdate();
    }


}
