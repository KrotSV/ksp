package root;

import java.io.IOException;
import krpc.client.Connection;
import krpc.client.RPCException;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Vessel;

public class ResourceDispather {

  private static ResourceDispather INSTANCE;
  private static Connection connection;
  private static SpaceCenter sc;

  public Vessel getVessel() throws IOException, RPCException {
    if(vessel != null)
    return vessel;
    else {
      vessel = sc.getActiveVessel();
      return vessel;
    }
  }

  private static Vessel vessel;

  private ResourceDispather() throws IOException {
      connection = Connection.newInstance();
      sc = SpaceCenter.newInstance(connection);
      System.out.println(sc.toString());
  }

  public static ResourceDispather getINSTANCE() throws IOException {
    if(INSTANCE != null)
    return INSTANCE;
    else {
      INSTANCE = new ResourceDispather();
      return INSTANCE;
    }
  }

  public SpaceCenter getSpaceCenter(){
    return sc;
  }

}
