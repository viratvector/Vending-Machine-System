package state;

import enums.Denomination;
import exception.VendingMachineException;

public class IdleState implements VendingMachineState {

    private VendingMachine vendingMachine;
    public IdleState(VendingMachine machine) {
        this.vendingMachine = machine;
    }

    @Override
    public void addMoney(int number, Denomination denomination) {
        vendingMachine.addCashInventory(number, denomination);
        vendingMachine.addInsertedAmount(number * denomination.getValue());
        vendingMachine.setVendingMachineState(new HasMoneyState(vendingMachine));
        System.out.println("Money has been inserted: " + number * denomination.getValue());
    }

    @Override
    public void selectProduct(String slotCode) {
        throw new VendingMachineException("Please insert money first");
    }

    @Override
    public void cancel() {
        throw new VendingMachineException("No order to cancel");
    }

    @Override
    public void dispense() {
        throw new VendingMachineException("No order to dispense");
    }
}
