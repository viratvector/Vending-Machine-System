import enums.Denomination;
import exception.VendingMachineException;
import models.Product;
import models.Slot;
import state.AdminService;
import state.VendingMachine;
import state.VendingMachineState;

import java.util.*;
import java.io.*;

public class Main {
    static void main() throws IOException {

       List<Product> products = Arrays.asList(
               new Product("Kitkat", "Super chocolaty", 20),
               new Product("Pineapple", "Fruit", 30),
               new Product("Maggi", "Junk", 40));

       List<Slot> slots = Arrays.asList(
               new Slot("A1", products.get(0), 8, 10),
               new Slot("B2", products.get(1), 8, 10),
               new Slot("C3", products.get(2), 8, 10));

       VendingMachine vendingMachine = VendingMachine.getInstance();

        AdminService adminService = new AdminService(vendingMachine);

        adminService.addSlot(slots.get(0));
        adminService.addSlot(slots.get(1));
        adminService.addSlot(slots.get(2));
        System.out.println("CURRENT INVENTORY");
        adminService.displayInventory();

        vendingMachine.addCashInventory(6, Denomination.TEN);
        vendingMachine.addCashInventory(6, Denomination.FIVE);
        vendingMachine.addCashInventory(3, Denomination.TWENTY);

        System.out.println("User buys Chocolate (₹20) with ₹50");
        vendingMachine.addMoney(1, Denomination.FIFTY);
        vendingMachine.selectProduct("A1");

        System.out.println("User inserts money then cancels");
        vendingMachine.addMoney(2, Denomination.TEN);
        vendingMachine.cancel();

        System.out.println("Insufficient funds");
        vendingMachine.addMoney(1, Denomination.TEN);
        try {
            vendingMachine.selectProduct("C3"); //Cost = 50. giving money ₹0;
        } catch (VendingMachineException e) {
            System.out.println("Error: " + e.getMessage());
        }
        vendingMachine.cancel();
    }
}
