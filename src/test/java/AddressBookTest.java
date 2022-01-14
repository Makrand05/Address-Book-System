import com.biz.book.service.DBService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressBookTest {

    @Test
    public void givenDBName_whenDBDataPresent_shouldPrintData() {
        DBService dbService=new DBService();
            boolean actualResult= dbService.showData();
        Assert.assertTrue(actualResult);
    }

    @Test
    public void givenFirstName_whenNameIspresnt_shouldUpdateRecord()
    {
        DBService dbService=new DBService();
       dbService.UpdateRecord(1,"Ramesh");
        String actualResult=dbService.checkUpdatedRecord(1);
        String expectedResult="Ramesh";
    }

}
