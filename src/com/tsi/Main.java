package com.tsi;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String message = "Enter 1 for: Paint Cost Calculator";
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int answer = input.nextInt();

        switch(answer){
            case 1:
                System.out.println("You've come to the right place");
                break;
            case 2:
                System.out.println("Please try again later. Use the pain cost calculator for now.");
        }

        double area = roomArea();
        System.out.println("Total area: " + area);

        double totalPaintLitres = Math.ceil(litreOfPaintRequired(area));
        System.out.println("Litres of paint required for " + area + " metre^2: " + totalPaintLitres);

        double cost = costOfPaintRequired(totalPaintLitres);
        System.out.printf("Total Cost: £%.2f %n", cost);

    }

    public static double roomArea()
    {

        Scanner input = new Scanner(System.in);

        double areaOfRoom;
        System.out.println("Do you already know the area of the wall?: ");
        String answer = input.nextLine();

        if (answer.equals("yes"))
        {

            System.out.println("Enter the area of the wall: ");
            areaOfRoom = input.nextDouble();

        }

        else
        {
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

        double litreOfPaintToCoverTotalArea = totalArea / areaCoveredByOneLitreOfPaint;
        return litreOfPaintToCoverTotalArea;

    }

    public static double costOfPaintRequired(double litreOfPaintRequired)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Size of the paint tin available to buy in litres: ");
        double paintSizeInLitres = input.nextDouble();

        System.out.println("Cost of a " + paintSizeInLitres + " L paint tin: ");
        double paintCost = input.nextDouble();

        double totalCost = paintCost * (litreOfPaintRequired / paintSizeInLitres);
        return totalCost;
    }

}
