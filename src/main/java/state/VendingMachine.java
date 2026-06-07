package state;
import enums.Denomination;
import models.Slot;

import java.util.HashMap;

public class VendingMachine {

    private static VendingMachine instance;
    private HashMap<Denomination, Integer> CashInventory;
    private HashMap<String, Slot> slots;
    private int insertedAmount;
    private VendingMachineState vendingMachineState;
    private Slot selectedSlot;

    public VendingMachine() {
        CashInventory = new HashMap<>();
        slots = new HashMap<>();
        insertedAmount = 0;
        vendingMachineState = new IdleState(this);
    }

    public static synchronized VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setVendingMachineState(VendingMachineState current) {
        this.vendingMachineState = current;
    }

    public void addCashInventory(int number, Denomination denomination) {
        CashInventory.put(denomination, CashInventory.getOrDefault(denomination, 0) + number);
    }

    public void addInsertedAmount(int amount) {
        this.insertedAmount += amount;
    }

    public void resetInsertedAmount() {
        this.insertedAmount = 0;
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public void addSlot(Slot slot) {
        slots.put(slot.getSlotCode(), slot);
    }

    public Slot getSlot(String slotCode) {
        return slots.get(slotCode);
    }

    public HashMap<String, Slot> getSlots() {
        return slots;
    }

    public HashMap<Denomination, Integer> getCashInventory() {
        return CashInventory;
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(Slot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public void resetSelectedSlot() {
        this.selectedSlot = null;
    }

    public void addMoney(int number, Denomination denomination) {
        vendingMachineState.addMoney(number, denomination);
    }

    public void selectProduct(String slotCode) {
        vendingMachineState.selectProduct(slotCode);
    }

    public void cancel() {
        vendingMachineState.cancel();
    }

    public void dispense() {
        vendingMachineState.dispense();
    }
}