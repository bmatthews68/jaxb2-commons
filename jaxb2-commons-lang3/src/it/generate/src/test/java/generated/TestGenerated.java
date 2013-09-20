package generated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class TestGenerated {

    private Person brian;
    private Person brian1;
    private Person joe;

    @Before
    public void setup() {
        brian = new Person();
        brian.setFirstName("Brian");
        brian.setLastName("Matthews");
        brian1 = new Person();
        brian1.setFirstName("Brian");
        brian1.setLastName("Matthews");
        joe = new Person();
        joe.setFirstName("Joe");
        joe.setLastName("Bloggs");
    }

    @Test
    public void testEquals() {
        assertEquals(brian, brian);
        assertEquals(brian, brian1);
        assertNotEquals(brian, joe);
    }

    @Test
    public void testHashCode() {
        assertEquals(-1532935948, brian.hashCode());
        assertEquals(-1532935948, brian1.hashCode());
        assertEquals(1995458871, joe.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Person[firstName=Brian,lastName=Matthews]", brian.toString());
        assertEquals("Person[firstName=Brian,lastName=Matthews]", brian1.toString());
        assertEquals("Person[firstName=Joe,lastName=Bloggs]", joe.toString());
    }
}