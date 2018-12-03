package project4.test;

import static org.junit.Assert.*;
import org.junit.Test;
import project4.ManageProvider;

public class ManageProviderTest {

  ManageProvider testing;
      @Before
      public void setValues() throws Exception {
      testing = new ManageProvider();
      testing.setName("Richard's Flower Pots");
      testing.setAddress("745 Euclid Circle");
      testing.setCity("Birmingham");
      testing.setState("Alabama");
      testing.setZipcode("35213");
      }
      @Test
      public void successTest() {
      assertEquals("Richard's Flower Pots", testing.finName());
      assertEquals("754 Euclid Circle", testing.getAddress());
      assertEquals("Birmingham", testing.findCity());
      assertEquals("Alabama", testing.findState());
      assertEquals("35213", testing.findZipcode());
      }
      @Test public void sanityTest() {
      testing.setCity("New Orleans");
      testing.setCity(testing.findName());
      assertEquals("New Orleans", testing.findCity());
      }
      @Test public void ExceptionTest() {
      testing.setName("");
      testing.setName(testing.findName());
      assertEquals("Provider Profile needs to be completed...Value is missing", testing.finName());
      }
}
