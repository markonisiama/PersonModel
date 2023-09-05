import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p1, p2, p3, p4;

    @BeforeEach
    void setUp() {
        p1 = new Person("00000A", "Marko", "Nisiama", "Mr",2001);
        p2 = new Person("00000B", "Gabriel", "Montes", "Mr",2005);
        p3 = new Person( "Monica", "Bozalongo", "Mrs",2002);
        p4 = new Person( "Fabiana", "Barra", "Mrs",2000);

    }

    @Test
    void setiDSeed() {
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Marko");
        assertEquals("Marko", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Nisiama");
        assertEquals("Nisiama", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mr");
        assertEquals("Mr", p1.getTitle());
    }

    @Test
    void fullName() {
        assertEquals("Marko Nisiama", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr Marko Nisiama", p1.formalName());
    }

    @Test
    void getAge() {
        assertEquals("22", p1.getAge());
    }

    @Test
    void testGetAge() {

    }

    @Test
    void toCVSDataRecord() {
        assertEquals("00000A, Marko, Nisiama, Mr, 2001", p1.toCVSDataRecord());
    }
}