import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;
    private List<Ad> adsList;
    public MySQLAdsDao(){
        try {
            DriverManager.registerDriver(new Driver());
            Config config = new Config();
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );


        } catch (SQLException e){
            e.printStackTrace();
        }
        adsList = new ArrayList<>();
    }

    @Override
    public List<Ad> all() {
        try{
            Statement statement = connection.createStatement();
            String adQuery = "SELECT id, users_id, title, description FROM Ads";
            ResultSet rs = statement.executeQuery(adQuery);
            while (rs.next()){
                adsList.add(new Ad(rs.getLong("id"), rs.getInt("users_id"), rs.getString("title") ,rs.getString("description")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return adsList;


    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String adQuery = "INSERT INTO Ads(users_id, title, description) VALUES("+ad.getUserId()+",'"+ad.getTitle()+"','"+ad.getDescription()+"'"+")";
            statement.executeUpdate(adQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                return rs.getLong(1);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
