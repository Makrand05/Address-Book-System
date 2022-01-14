import com.biz.book.model.ContactList;
import com.biz.book.service.ContactPerson;
import com.biz.book.service.DBService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AddressBookTest {

    // UC 16
    @Test
    public void givenDBName_whenDBDataPresent_shouldPrintData() {
        DBService dbService = new DBService();
        boolean actualResult = dbService.showData();
        Assert.assertTrue(actualResult);
    }


    // UC 17
    @Test
    public void givenFirstName_whenNameIspresnt_shouldUpdateRecord() {
        DBService dbService = new DBService();
        dbService.UpdateRecord(1, "Ramesh");
        String actualResult = dbService.checkUpdatedRecord(1);
        String expectedResult = "Ramesh";
    }
    //UC 18
    @Test
    public void givenFDateRange_whenDates_shouldReturnCount() {
        DBService dbService = new DBService();
        List<ContactPerson> list=dbService.getCountBetDates("2001-01-01","2022-01-14");
        int actualResult= list.size();
        Assert.assertEquals(5,actualResult);

    }
    // UC 19
    @Test
    public void givenCity_whenPresent_shouldReturnCount() {
        DBService dbService = new DBService();
        int actualResult= dbService.getCountCitis("Mumbai");
        Assert.assertEquals(3,actualResult);

    }

    @Test
    public void givenContact_whenAdd_shouldReturnStatus() {
        DBService dbService = new DBService();
        boolean actualResult= dbService.addDataInDatabase(
                new ContactPerson("Makrand","Shingare","Velapur","Solapur","Maharashtra",413113,9096592086L,"makrand@gmail.com")
                );
        Assert.assertTrue(actualResult);

    }

}
