package handle_pcap;

import java.io.IOException;
import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.Packet;

public class Wireshark {
   private  NetworkInterface[] devices;
   private  int noDevices;
   private  JpcapCaptor captor;
   public Wireshark(){
       devices = JpcapCaptor.getDeviceList();
       noDevices=devices.length;
   }
   
   public void printAvailableDevices(){
        System.out.println("Available Interfaces: ");
        noDevices=devices.length;
        for (int i=1;  i<devices.length ; i++)     
        {
            System.out.println(i+": "+devices[i].name + "(" + devices[i].description+")");
            System.out.println("datalink: "+devices[i].datalink_name + "(" + devices[i].datalink_description+")");
            for(byte b=0;b<devices[i].mac_address.length;b++){
             System.out.print(Integer.toHexString(b&0xff) + ":");   
            }
            System.out.println();
             for (NetworkInterfaceAddress a : devices[i].addresses){
                System.out.println(" address:"+a.address + " " + a.subnet + " "+ a.broadcast);
             }
        }
    }
   public NetworkInterface[] getAvailableDevices(){
       return devices;
   }
   public String getNameDevices(int index){
       return devices[index].description;
   }
   public int getNoDevices(){
       return noDevices;
   }
   public void openWireDevices(int index,int size_packet,boolean promisc,int timout) throws IOException{
       captor=JpcapCaptor.openDevice(devices[index], size_packet, promisc, timout);
   }
   public Packet getWirePecket(){
       return captor.getPacket();
   }
    public Packet getWirePecketFilter(String str) throws IOException{
       captor.setFilter(str, true);
       return captor.getPacket();
   }
   public void printWirePecket(){
       System.out.println(captor.getPacket());
   }
    public void printListWirePecket(int number,boolean ProcessOrLoop){
     if(ProcessOrLoop){
         System.out.println( captor.processPacket(number, new PacketPrinter()) );
     }
     else{
        for(int i=0;i<number;i++){
          System.out.println(captor.getPacket());
        }
     }
   }
   public Packet[] getListWirePecket(int number){ 
       Packet[] pack=new Packet[100];
        for(int i=0;i<number;i++){
          pack[i]=captor.getPacket();
        
        }
      return pack;
   }
   public Packet[] getListPecketFilter(int number,String str) throws IOException{ 
       captor.setFilter(str, true);
       Packet[] pack=new Packet[100];
        for(int i=0;i<number;i++){
          pack[i]=captor.getPacket();
        
        }
      return pack;
   }       
}
