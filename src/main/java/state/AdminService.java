package state;

import enums.Denomination;
import models.Slot;

import java.util.HashMap;

public class AdminService {

    private VendingMachine vendingMachine;

    public AdminService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void addSlot(Slot slot) {
        vendingMachine.addSlot(slot);
    }

    public void collectCash() {
        int sum = 0;
        HashMap<Denomination, Integer> mp = vendingMachine.getCashInventory();
        for(Denomination d : mp.keySet()) {
            sum += mp.get(d) * d.getValue();
        }
        System.out.println("Cash: " + sum);
        mp.clear();
    }
    public void displayInventory() {
        HashMap<String, Slot> mp = vendingMachine.getSlots();
        for(String s : mp.keySet()) {
            System.out.println("Slot code: " + s + "Product: " + mp.get(s).getProduct().getName() +
                    "Quantity: " + mp.get(s).getQuantity());
        }
    }
}