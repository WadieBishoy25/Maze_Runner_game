//package maze.controller;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.StaxDriver;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class CareTaker {
//
//    public void save(Memento memento) {
//        XStream xstream = new XStream(new StaxDriver());
//        String XML = xstream.toXML(memento);
//        SaveFile(XML, "Save.xml");
//    }
//
//    public Memento load() {
//        XStream xstream = new XStream(new StaxDriver());
//        Memento memento = (Memento) xstream.fromXML(new File("Save.xml"));
//        return memento;
//    }
//
//    public void SaveFile(String content, String Path) {
//        File file = new File(Path);
//        try {
//            FileWriter fileWriter = null;
//            fileWriter = new FileWriter(file);
//            fileWriter.write(content);
//            fileWriter.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
