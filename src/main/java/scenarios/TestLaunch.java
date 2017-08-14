package scenarios;

import static java.lang.Thread.sleep;

import java.io.IOException;
import krpc.client.RPCException;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.ReferenceFrame;
import krpc.client.services.SpaceCenter.Vessel;
import krpc.client.services.SpaceCenter.VesselSituation;
import root.ResourceDispather;

public class TestLaunch {
  public static void execute() throws IOException, RPCException, InterruptedException {
    sleep(2000);
    ResourceDispather rd = ResourceDispather.getINSTANCE();
    Vessel vessel = rd.getVessel();
    Control control = vessel.getControl();
    control.activateNextStage();
    control.toggleActionGroup(1);
    control.setSAS(true);
    ReferenceFrame ref = vessel.getOrbit().getBody().getReferenceFrame();
    while (vessel.flight(ref).getVerticalSpeed() >= 0.1 || vessel.getSituation() != VesselSituation.LANDED){
      sleep(1000);
      System.out.println(vessel.flight(ref).getSpeed());
    }
    control.toggleActionGroup(2);
  }
}
