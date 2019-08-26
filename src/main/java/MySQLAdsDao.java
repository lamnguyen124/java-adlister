import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection;

    public MySQLAdsDao(){
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()
            );
            System.out.println("Successfully connected to database");
        } catch (SQLException ex){
            System.out.println("Connection to database failed");
            ex.printStackTrace();
        }
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
            String adQuery = "INSERT INTO Ads(users_id, title, description) VALUES("+ad.getUserId()+",'"+ad.getTitle()+"','"+ad.getDescription()+"')";
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
