package task0783;

public class Computer {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
