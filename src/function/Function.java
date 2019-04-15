package function;

import dao.IOData;
import display.CommandLineTable;
import entities.SaleItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Function {

    public static void showSaleItems() throws IOException, ClassNotFoundException {
        List<SaleItem> saleItems = new ArrayList<>();
        saleItems = IOData.readFile();
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Acreage", "UnitPrice","RateType","CreatedAt","UpdateAt","IssuedAt","Address","Number of Room","Number of Person","Item Name");//optional - if not used then there will be no header and horizontal lines
        for(SaleItem saleItem : saleItems) {
            CommandLineTable.addRow(saleItem.getId(),saleItem.getAcreage(),saleItem.getUnitPrice(),saleItem.getRateType(),saleItem.getCreatedAt(),saleItem.getUpdatedAt(),saleItem.getIssuedAt(),saleItem.getAddress(),saleItem.getNumberOfRoom(),saleItem.getNumberOfPerson(),saleItem.getItemName());
        }
        CommandLineTable.print();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Function.showSaleItems();
    }
}
