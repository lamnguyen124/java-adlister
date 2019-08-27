import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    Connection connection;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()
            );
            System.out.println("Successfully connected to database");
//            this.generateAds();
//            System.out.println("Added test data, remember to remove generateAds");
        } catch (SQLException ex) {
            System.out.println("Connection to database failed");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            String queryString = "SELECT * FROM ads";
            ResultSet results = statement.executeQuery(queryString);
            if (results != null) {
                System.out.println("Statement executed successfully");
                while (results.next()) {
                    Ad nextAd = new Ad(
                            results.getLong("id"),
                            results.getLong("user_id"),
                            results.getString("title"),
                            results.getString("description")
                    );
                    ads.add(nextAd);
                }
                System.out.println("No more results");
            }
            else
                System.out.println("no ads found");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Long id = -1L;
        try {
            Statement statement = connection.createStatement();
            String queryString = "INSERT INTO ads(user_id, title, description) " +
                    "VALUES (1, '"+ad.getTitle()+"', '"+ad.getDescription()+"');";
            System.out.println(queryString);
            statement.executeUpdate(queryString, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getLong(1);
                System.out.println("Inserted a new record! New id is: " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    private void generateAds() {
//        List<Ad> ads = new ArrayList<>();
        this.insert(new Ad(
                1,
                1,
                "playstation for sale",
                "This is a slightly used playstation"
        ));
        this.insert(new Ad(
                2,
                1,
                "Super Nintendo",
                "Get your game on with this old-school classic!"
        ));
        this.insert(new Ad(
                3,
                2,
                "Junior Java Developer Position",
                "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        this.insert(new Ad(
                4,
                2,
                "JavaScript Developer needed",
                "Must have strong Java skills"
        ));
//        return ads;
    }

}
