package function;

import dao.IOData;
import display.CommandLineTable;
import entities.SaleItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Function {

    public static List<SaleItem> createSaleItems(){
        SaleItem item1 = new SaleItem(1,3,4,12,300,"STREETVIEW",new Date(),new Date(),new Date(),"1st Street - Nha Trang",3,2,"Simple Room");
        SaleItem item2 = new SaleItem(2,6,6,36,1000,"CITYVIEW",new Date(),new Date(),new Date(),"Thang Long Street - Nha Trang",2,6,"City Glass Room");
        SaleItem item3 = new SaleItem(3,8,10,80,2000,"SEAVIEW",new Date(),new Date(),new Date(),"Bach Dang Street - Nha Trang",3,8,"Seaview Nature Room");
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
            System.out.println("Ghi du lieu thanh cong");
            obos.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return saleItems;
    }

    public static List<SaleItem> editListItems(List<SaleItem> saleItems,Scanner scanner){
        System.out.println("Input Id of Item need to be edited: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        Iterator<SaleItem> iterator = saleItems.iterator();
        while(iterator.hasNext()){
            SaleItem saleItem = iterator.next();
            if(saleItem.getId() == idEdit){
                System.out.println("Edit item have id "+saleItem.getId());
                System.out.println("Choose property to edit:");
                System.out.println("1: UnitPrice");
                System.out.println("2: Number of Room");
                System.out.println("3: Number of Person");
                System.out.println("4: Item Name");
                System.out.println("5: Exit");
                System.out.println("=====> Enter your choose: ");
                int propertyChoose = Integer.parseInt(scanner.nextLine());
                switch(propertyChoose){
                    case 1:
                        System.out.println("Enter your UnitPrice instead");
                        saleItem.setUnitPrice(Double.parseDouble(scanner.nextLine()));
                        saleItem.setUpdatedAt(new Date());
                        System.out.println("Done!");
                        break;
                    case 2:
                        System.out.println("Enter your Number of Room instead");
                        saleItem.setNumberOfRoom(Integer.parseInt(scanner.nextLine()));
                        saleItem.setUpdatedAt(new Date());
                        System.out.println("Done!");
                        break;
                    case 3:
                        System.out.println("Enter your Number of Person instead");
                        saleItem.setNumberOfPerson(Integer.parseInt(scanner.nextLine()));
                        saleItem.setUpdatedAt(new Date());
                        System.out.println("Done!");
                        break;
                    case 4:
                        System.out.println("Enter your Item Name instead");
                        saleItem.setItemName(scanner.nextLine());
                        saleItem.setUpdatedAt(new Date());
                        System.out.println("Done!");
                        break;
                }

            }
        }
        IOData.importSaleItems(saleItems);
        return saleItems;
    }

    public static List<SaleItem> deleteSaleItems(List<SaleItem> saleItems,Scanner scanner){
        System.out.println("Enter Id need to be deleted: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        Iterator<SaleItem> iterator = saleItems.iterator();
        while (iterator.hasNext()){
            SaleItem saleItem = iterator.next();
            if(saleItem.getId() == idDelete){
                iterator.remove();
                System.out.println("Done!");
            }
        }
        IOData.importSaleItems(saleItems);
        return saleItems;
    }




    public static void showSaleItems() throws IOException, ClassNotFoundException {
        List<SaleItem> saleItems = new ArrayList<>();
        saleItems = IOData.readFile();
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Acreage", "UnitPrice","RateType","CreatedAt","UpdateAt","IssuedAt","Address","Number of Room","Number of Person","Item Name");//optional - if not used then there will be no header and horizontal lines
        for(SaleItem saleItem : saleItems) {
            CommandLineTable.addRow(Integer.toString(saleItem.getId()),Integer.toString(saleItem.getAcreage()),Double.toString(saleItem.getUnitPrice()),Double.toString(saleItem.getRateType()),saleItem.getCreatedAt(),saleItem.getUpdatedAt(),saleItem.getIssuedAt(),saleItem.getAddress(),Integer.toString(saleItem.getNumberOfRoom()),Integer.toString(saleItem.getNumberOfPerson()),saleItem.getItemName());
        }
        CommandLineTable.print();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Scanner scanner = new Scanner(System.in);
        Function.createSaleItems();
        Function.showSaleItems();
        Function.editListItems(IOData.readFile(),scanner);
      //  Function.showSaleItems();
        //Function.deleteSaleItems(IOData.readFile(),scanner);
        Function.showSaleItems();
    }
}
