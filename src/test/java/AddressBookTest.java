import com.biz.book.service.DBService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressBookTest {

    @Test
    public void MSTest() {
        DBService dbService=new DBService();
            boolean actualResult= dbService.showData();
        Assert.assertTrue(actualResult);
    }
}
