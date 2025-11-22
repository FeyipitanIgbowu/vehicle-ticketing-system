package Test.RepositoryTest;

import VehicleTicketingSysytem.controllers.data.models.Officer;
import VehicleTicketingSysytem.controllers.data.repository.Officers;
import VehicleTicketingSysytem.controllers.data.repository.OfficersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OfficerRepositoryTest {
    private Officer officer;
    private Officers officers;
    private OfficersRepository officersRepo;

    @BeforeEach
    void setUp() {
        officer = new Officer();
        officers = new Officers();
    }

    @Test
    void testThatYouCanSaveOfficer(){
        officers.save(officer);

        assertEquals(1, officers.count());
    }

    @Test
    void testThatYouCanSaveAnOfficerTwiceAndItUpdatesInsteadOfDuplicates(){
        officers.save(officer);
        officers.save(officer);

        assertEquals(1, officers.count());
    }

    @Test
    void testThatYouCanFindTheOfficerById(){
        officer.setId(1);
        officers.save(officer);

        assertTrue(officers.findByID(1).contains(officer));
    }

    @Test
    void testThatYouCanFindAllOfficers(){
        Officer officer1 = new Officer();
        officers.save(officer);
        officers.save(officer1);

        assertEquals(2, officers.findAll().size());
    }

    @Test
    void testThatYouCanDeleteById(){
        Officer officer1 = new Officer();
        officer.setId(1);
        officer1.setId(2);
        officers.save(officer);
        officers.save(officer1);

        officers.deleteById(1);
        assertFalse(officers.findByID(1).contains(officer));
        assertTrue(officers.findByID(2).contains(officer1));
    }

    @Test
    void testThatYouCanDeleteAllOfficers(){
        Officer officer1 = new Officer();
        officers.save(officer);
        officers.save(officer1);

        officers.deleteAll();
        assertTrue(officers.findAll().isEmpty());
    }

    @Test
    void testThatYouCanDeleteAnOfficer(){
        officers.save(officer);

        officers.delete(officer);
        assertEquals(0, officers.count());
    }

    @Test
    void testThatYouCanCountOfficers(){
        Officer officer1 = new Officer();
        Officer officer2 = new Officer();
        officers.save(officer);
        officers.save(officer1);
        officers.save(officer2);

        assertEquals(3, officers.count());
    }
}

