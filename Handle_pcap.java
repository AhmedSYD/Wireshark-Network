
package handle_pcap;

import java.io.IOException;
import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.Packet;


public class Handle_pcap {
    public static void main(String[] args) throws IOException {

        Wireshark wir=new Wireshark();
        wir.printAvailableDevices();
        /*wir.openWireDevices(5,65535 , false, 5000);
       System.out.println("=============");
       Packet[] pack=wir.getListPecketFilter(5,"ip and tcp");
       System.out.println(pack[1]);
       System.out.println(wir.getWirePecket());*/
        
    }
    
}
