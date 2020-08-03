package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = rentalList.iterator();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = rentals.next();
            thisAmount = determineAmounts(thisAmount,each);
            frequentRenterPoints++;
            frequentRenterPoints = addBonusForRelease(frequentRenterPoints,each);
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }
        result = new StringBuilder(addFooter(result.toString(), totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private String addFooter(String result,double totalAmount,int frequentRenterPoints) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }


    private int addBonusForRelease(int frequentRenterPoints, Rental each) {
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
            && each.getDaysRented() > 1)
        frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double determineAmounts(double thisAmount, Rental each) {
        if(each.getMovie().getPriceCode() == Movie.REGULAR){
            thisAmount += Movie.REGULAR_AMOUNT;
            if (each.getDaysRented() > Movie.REGULAR_LIMIT_DAY)
                thisAmount += (each.getDaysRented() - Movie.REGULAR_LIMIT_DAY) * Movie.REGULAR_RATIO;
        }else if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE){
            thisAmount += each.getDaysRented() * Movie.RELEASE_RATIO;
        }else {
            thisAmount += Movie.CHILDRENS_AMOUNT;
            if (each.getDaysRented() > Movie.CHILDRENS_LIMIT_DAY)
                thisAmount += (each.getDaysRented() - Movie.CHILDRENS_LIMIT_DAY) * Movie.CHILDRENS_RATIO;
        }
        return thisAmount;
    }

}
