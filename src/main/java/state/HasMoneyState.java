package state;

import enums.Denomination;
import exception.VendingMachineException;
import models.Slot;

public class HasMoneyState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine machine) {
        this.vendingMachine = machine;
    }

    @Override
    public void addMoney(int number, Denomination denomination) {
        throw new VendingMachineException("Money has already been added");
    }

    @Override
    public void selectProduct(String slotCode) {
        Slot s = vendingMachine.getSlot(slotCode);
        if(s == null) {
            throw new VendingMachineException("Slot not found");
        }
        if(s.getQuantity() <= 0) {
            throw new VendingMachineException("Product is out of stock");
        }
        int amt = vendingMachine.getInsertedAmount();
        if(s.getProduct().getPrice() > amt) {
            throw new VendingMachineException("Insufficient funds. Need ₹"
                    + (s.getProduct().getPrice() - amt) + " more");
        }
        else {
            vendingMachine.setSelectedSlot(s);
            vendingMachine.setVendingMachineState(new DispensingState(vendingMachine, (int) (amt - s.getProduct().getPrice())));
            vendingMachine.dispense();
        }
    }

    @Override
    public void cancel() {
        System.out.println("Refund Money: " + vendingMachine.getInsertedAmount());
        vendingMachine.resetInsertedAmount();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void dispense() {
        throw new VendingMachineException("No order to dispense");
    }
}
