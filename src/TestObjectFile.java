import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestObjectFile {

    public static void saveFile(List<Student> listStudent) throws FileNotFoundException, IOException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Output.txt");
            ObjectOutputStream obos = new ObjectOutputStream(fos);
            obos.writeObject(listStudent);
            fos.close();
            obos.flush();
            System.out.println("Ghi du lieu thanh cong");
            obos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static List<Student> readFile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        List<Student> lsttemp = new ArrayList<>();
        try
        {
            System.out.println("Doc du lieu tu file");
            ObjectInputStream obis = new ObjectInputStream(new FileInputStream( "Output.txt"));
            lsttemp = (List<Student>) obis.readObject();
            obis.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        for (Student get : lsttemp)
        {
            System.out.println(get.getName() + " "+ get.getAge()+" "+get.getDate()) ;
        }
        PrintWriter pr = new PrintWriter("Output.txt");
        pr.close();
        return lsttemp;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> listStudent = new ArrayList<>();
        Student student1 = new Student("huy",22,new Date());
        Student student2 = new Student("huy",23,new Date());
        Student student3 = new Student("huy",24,new Date());
        Student student4 = new Student("huy",25,new Date());
        Student student5 = new Student("huy",26,new Date());
        Student student6 = new Student("huy",27,new Date());
        Student student7 = new Student("huy",28,new Date());
        Student student8 = new Student("huy",29,new Date());
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        listStudent.add(student5);
        listStudent.add(student6);
        listStudent.add(student7);
        listStudent.add(student8);

        //TestObjectFile.saveFile(listStudent);
        System.out.println(TestObjectFile.readFile());

        /*try {
            FileOutputStream f = new FileOutputStream(new File("Output.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            System.out.println("file created");

            // Write objects to file
            for(Student s : listStudent) {
                o.writeObject(s);
            }


            o.close();
            f.close();


            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }*/

    }

}
