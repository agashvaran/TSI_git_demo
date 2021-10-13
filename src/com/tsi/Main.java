package com.tsi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String message = "Enter '1' for Paint Cost Calculator. '2' for Painter Hire: ";
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int answer = input.nextInt();

        switch(answer){
            case 1:
                System.out.println("You've come to the right place");
                break;
            case 2:
                System.out.println("Please try again later. Now, use the pain cost calculator for now.");
        }

        //paint cost calc
        int counter = 0;
        for(int i = 0; i<5; i++)
        {

            Scanner continueP = new Scanner(System.in);
            System.out.println("Add wall?: ");
            String start = continueP.nextLine();

            if (start.equals("yes"))
            {

                double area = roomArea();
                System.out.println("Total area: " + area);

                double paintRequiredOverall = litreOfPaintRequired(area);
                double totalPaintLitres = Math.ceil(paintRequiredOverall);
                System.out.println("Litres of paint required for " + area + " metre^2: " + totalPaintLitres);

                double costOfOneWall = costOfPaintRequired(totalPaintLitres);
                System.out.printf("Cost for this wall: £%.2f %n", costOfOneWall);

                //arrays
                List<Double> costForAllWalls = new ArrayList<>();
                costForAllWalls.add(costOfOneWall);



                for(int j = 0; j < costForAllWalls.size(); j++){
                    counter += costForAllWalls.get(j);

                }
                System.out.printf("Total Cost: £%.2f %n", counter);

            }
            else{
                break;
            }


        }



        //arrays end

//        Scanner repeatInput = new Scanner(System.in);
//        System.out.println("Add wall?: ");
//        repeat = repeatInput.nextLine();


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
