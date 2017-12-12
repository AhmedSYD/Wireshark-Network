
package handle_pcap;

import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class PacketPrinter implements PacketReceiver{
   @Override
   public  void receivePacket(Packet packet){
       System.out.println(packet); 
   }  
}
