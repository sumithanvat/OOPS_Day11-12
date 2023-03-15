package com.bridgelabz;

import java.util.Scanner;

class Stock {
    private String name;
    private int numOfShares;
    private double sharePrice;

    public Stock(String name, int numOfShares, double sharePrice) {
        this.name = name;
        this.numOfShares = numOfShares;
        this.sharePrice = sharePrice;
    }

    public double getValue() {
        return numOfShares * sharePrice;
    }

    public String getName() {
        return name;
    }

    public int getNumOfShares() {
        return numOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }
}

class StockPortfolio {
    private Stock[] stocks;

    public StockPortfolio(int numStocks) {
        stocks = new Stock[numStocks];
    }

    public void addStock(Stock stock, int index) {
        stocks[index] = stock;
    }

    public double getTotalValue() {
        double totalValue = 0.0;
        for (Stock stock : stocks) {
            totalValue += stock.getValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("Stock Report:");
        System.out.println("------------------------------");
        for (Stock stock : stocks) {
            System.out.println("Stock name: " + stock.getName());
            System.out.println("Number of shares: " + stock.getNumOfShares());
            System.out.println("Share price: $" + stock.getSharePrice());
            System.out.println("Total value: $" + stock.getValue());
            System.out.println("------------------------------");
        }
        System.out.println("Total portfolio value: $" + getTotalValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();

        StockPortfolio portfolio = new StockPortfolio(numStocks);

        for (int i = 0; i < numStocks; i++) {
            System.out.println("Enter the details of stock " + (i+1) + ":");
            scanner.nextLine();
            System.out.print("Stock name: ");
            String name = scanner.nextLine();
            System.out.print("Number of shares: ");
            int numOfShares = scanner.nextInt();
            System.out.print("Share price: ");
            double sharePrice = scanner.nextDouble();
            Stock stock = new Stock(name, numOfShares, sharePrice);
            portfolio.addStock(stock, i);
        }

        portfolio.printStockReport();
    }
}
