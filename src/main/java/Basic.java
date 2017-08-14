import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import krpc.client.Connection;
import krpc.client.RPCException;
import krpc.client.services.KRPC;

import java.io.IOException;
import krpc.client.services.KRPC.GameScene;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.ReferenceFrame;
import krpc.client.services.SpaceCenter.Vessel;
import krpc.client.services.SpaceCenter.VesselSituation;

public class Basic {
  public static void main(String[] args) throws IOException, RPCException {
    Connection connection = Connection.newInstance();
    KRPC krpc = KRPC.newInstance(connection);
    System.out.println("Connected to kRPC version " + krpc.getStatus().getVersion());
//    connection.close();
    SpaceCenter sc = SpaceCenter.newInstance(connection);
    Vessel vessel = sc.getActiveVessel();
    System.out.println(vessel.getName());
    Control control = vessel.getControl();
    control.activateNextStage();
    Flight flight = vessel.flight(vessel.getSurfaceReferenceFrame());
    Boolean test = flight.getVerticalSpeed() < 0 && vessel.getSituation() != VesselSituation.LANDED;
    ActionListener listener = new Descent(flight, control);
  }
}

class Descent implements ActionListener{
  Flight flight;
  Control control;

  public void actionPerformed(ActionEvent e) {
    try {
      control.setActionGroup(3, true);
    } catch (RPCException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }


  public Descent(Flight flight, Control control) {
    this.flight = flight;
    this.control = control;
  }
}