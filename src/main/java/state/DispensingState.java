package state;
import enums.Denomination;
import models.Slot;
import java.util.Arrays;
import java.util.List;

public class DispensingState implements VendingMachineState {

    private VendingMachine vendingMachine;
    private int amount;
    public DispensingState(VendingMachine machine, int a) {
        this.vendingMachine = machine;
        this.amount = a;
    }

    @Override
    public void addMoney(int number, Denomination denomination) {
        throw new UnsupportedOperationException("Dispense your order then add money");
    }

    @Override
    public void selectProduct(String slotCode) {
        throw new UnsupportedOperationException("Dispense your order then select product");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("Order cannot be cancelled");
    }

    @Override
    public void dispense() {
        Slot s = vendingMachine.getSelectedSlot();
        s.setQuantity(s.getQuantity() - 1);
        System.out.println("Dispensed: " + s.getProduct().getName());
        vendingMachine.resetInsertedAmount();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        //amount
        int change = this.amount;
        List<Denomination> arr = Arrays.asList(Denomination.values());
        arr.sort((a, b) -> b.getValue() - a.getValue());
        for(Denomination d : arr) {
            while(change > d.getValue() && vendingMachine.getCashInventory().getOrDefault(d, 0) > 0) {
                change -= d.getValue();
                System.out.println("Change returned: " + d.getValue());
                vendingMachine.getCashInventory().put(d, vendingMachine.getCashInventory().getOrDefault(d, 0) - 1);
            }
        }
        if(change > 0) {
            System.out.println("Could not return ₹" + change + " - insufficient change in machine");
        }
    }
}
