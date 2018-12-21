import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class useDataFromTestNG {
  @Test
  public void setUp(String browser, String version, String platform) {
  }
  @BeforeClass
  @org.testing.annotations.Parameters(value={"browser","version","platform"})
  public void beforeClass() {
  }

}
