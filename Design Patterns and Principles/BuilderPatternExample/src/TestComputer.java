public class TestComputer {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder()
                          .setCPU("Intel i5")
                          .setRAM("16GB")
                          .setStorage("1TB SSD")
                          .build();
        pc.displayConfig();
    }
}
