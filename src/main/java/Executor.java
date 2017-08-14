import java.io.IOException;
import krpc.client.RPCException;
import scenarios.TestLaunch;

public class Executor {

  public static void main(String[] args) {
    try {
      TestLaunch.execute();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (RPCException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
