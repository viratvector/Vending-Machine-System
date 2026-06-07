package state;
import enums.Denomination;

public interface VendingMachineState {
    void addMoney(int number, Denomination denomination);
    void selectProduct(String slotCode);
    void cancel();
    void dispense();
}
