public class TestObserver {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile1 = new MobileApp("ClientA");
        Observer web1 = new WebApp("ClientB");

        market.registerObserver(mobile1);
        market.registerObserver(web1);

        market.setStockData("TCS", 3789.50);
        System.out.println("---");
        market.setStockData("INFY", 1470.75);
    }
}
