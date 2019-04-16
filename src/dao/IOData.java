package dao;

import entities.SaleItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IOData {
    public static List<SaleItem> createData(){
        SaleItem item1 = new SaleItem(1,3,4,12,300,"STREESTVIEW",new Date(),new Date(),new Date(),"1st Street - Nha Trang",3,2,"Simple Room");
        SaleItem item3 = new SaleItem(3,8,10,80,2000,"SEAVIEW",new Date(),new Date(),new Date(),"Bach Dang Street - Nha Trang",3,8,"Seaview Nature Room");
        SaleItem item2 = new SaleItem(2,6,6,36,1000,"CITYVIEW",new Date(),new Date(),new Date(),"Thang Long Street - Nha Trang",2,6,"City Glass Room");

        SaleItem item4 = new SaleItem(4,10,10,100,3000,"RESORT",new Date(),new Date(),new Date(),"2nd Tran Quoc Tuan - Nha Trang",4,10,"Diamond Resort Room");

        List<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(item1);
        saleItems.add(item2);
        saleItems.add(item3);
        saleItems.add(item4);

        try
        {
            FileOutputStream fos = new FileOutputStream("Output.txt");
            ObjectOutputStream obos = new ObjectOutputStream(fos);
            obos.writeObject(saleItems);
            fos.close();
            obos.flush();
            System.out.println("Create Success");
            obos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return saleItems;
    }

    public static void importSaleItems(List<SaleItem> saleItems){
        try
        {
            FileOutputStream fos = new FileOutputStream("Output.txt");
            ObjectOutputStream obos = new ObjectOutputStream(fos);
            obos.writeObject(saleItems);
            fos.close();
            obos.flush();
            System.out.println("Import Success");
            obos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }




    public static List<SaleItem> readFile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        List<SaleItem> lsttemp = new ArrayList<>();
        try
        {
            System.out.println("Read Data from file");
            ObjectInputStream obis = new ObjectInputStream(new FileInputStream( "Output.txt"));
            lsttemp = (List<SaleItem>) obis.readObject();
            obis.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

      //  PrintWriter pr = new PrintWriter("Output.txt");
       // pr.close();
        return lsttemp;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // IOData.createData();
            System.out.println(IOData.readFile());
    }
}
