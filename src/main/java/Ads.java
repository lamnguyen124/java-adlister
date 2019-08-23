import java.util.List;

public interface Ads {
    List<Ad> all();
    Ad lookup(int id);
    int add(String title, String description);
}
