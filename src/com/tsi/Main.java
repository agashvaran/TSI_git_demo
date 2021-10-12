package com.tsi;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("***Decoration Cost Calculator***");

        double area = roomArea();
        System.out.println("Total area: " + area);

        double totalPaintLitres = Math.ceil(litreOfPaintRequired(area));
        System.out.println("Litres of paint required for " + area + " metre^2: " + totalPaintLitres);

        double cost = costOfPaintRequired(totalPaintLitres);
        System.out.printf("Total Cost: £%.2f %n", cost);

//        int choice = 2;
//        String message;
//        //ternary operator
//        message = (choice == 1) ? "Happy days" : "sad days";
//
//        System.out.println(message);



    }

    public static double roomArea()
    {

        Scanner areaInput = new Scanner(System.in);
        System.out.println("Do you already know the area of the wall?: ");
        String answer = areaInput.nextLine();
        double areaOfRoom;

        if (answer.equals("yes"))
        {

            System.out.println("Enter the area of the wall: ");
            areaOfRoom = areaInput.nextDouble();

        }

        else
        {
            Scanner input = new Scanner(System.in); //create a scanner object

            System.out.println("Enter room Width: ");
            double rWidth = input.nextInt();

            System.out.println("Enter room length:");
            double rLength = input.nextInt();

            areaOfRoom = rWidth * rLength;

        }

        return Math.ceil(areaOfRoom);

    }


    public static double litreOfPaintRequired(double totalArea)
    {
        Scanner paintCoverage = new Scanner(System.in);
        System.out.println("Area covered by 1 litre of paint in metre^2: ");
        double areaCoveredByOneLitreOfPaint = paintCoverage.nextDouble();

        double litre = totalArea / areaCoveredByOneLitreOfPaint;
        return litre;

    }

    public static double costOfPaintRequired(double litreOfPaintRequired)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Size of the paint tin available to buy in litres: ");
        double paintSize = input.nextDouble();

        System.out.println("Cost of a " + paintSize + " L paint tin: ");
        double paintCost = input.nextDouble();

        double totalCost = paintCost * (litreOfPaintRequired / paintSize);
        return totalCost;
    }

}
