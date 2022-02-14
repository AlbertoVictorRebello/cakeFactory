import br.com.dio.cakeFactory.domain.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selectedCakeName;
        CakeMixture cake;
        String message;

        // Setting the cake stock
        Queue<CakeMixture> unbackedCakes = new LinkedList<>();
        Queue<CakeMixture> backedCakes = new LinkedList<>();
        Queue<CakeMixture> packedCakes = new LinkedList<>();

        // Setting the production employees
        CookerHelper john = new CookerHelper("John");
        Cooker peter = new Cooker("Peter");

        //Selecting production information
        System.out.println("Please, select the cake name from the portfolio:");
        System.out.println("1 - Super Easy Brownie");
        scanner.nextInt();
        selectedCakeName = "Super Easy Brownie"; // Unique portfolio product for while
        System.out.println(String.format("Please, inform how many %s shall be produced:", selectedCakeName));
        int cakeDemand = scanner.nextInt();
        while (cakeDemand <= 0) {
            System.out.println(String.format("Please, inform a number greater than 0.", selectedCakeName));
            cakeDemand = scanner.nextInt();
        }


        // Informing the ingredients
        System.out.println("The following ingredients will be used to produce the cakes:");
        for (Ingredient ingredient : CakeRecipeIngredientLists.getIngredientList(selectedCakeName)) {
            System.out.println("  " + ingredient.toString());
        }
        System.out.println();

        // Picking the ingredients to the new production lot
        for (int i = 0; i < cakeDemand; i++) {
            cake = john.handleIngredients(selectedCakeName);
            unbackedCakes.add(cake);
        }
        productionStatus(unbackedCakes.size(), backedCakes.size(), packedCakes.size());

        // Simulating a problem during the production
        if (unbackedCakes.size() > 0) {
            cake = unbackedCakes.poll();
            unbackedCakes.add(cake);
            cake = unbackedCakes.poll();
            System.out.printf("The %s %s rejected the %s cake snº %d due poor quality ingredients.\n\n",peter.getJobTitle(), peter.getName(), cake.getName(),cake.getSerialNumber());
        }

        while (!unbackedCakes.isEmpty()) {
            cake = unbackedCakes.poll();
            peter.handleIngredients(cake);
            peter.bake(cake);
            backedCakes.add(cake);
        }
        productionStatus(unbackedCakes.size(), backedCakes.size(), packedCakes.size());

        // Simulating a problem during the production
        if (backedCakes.size() > 0) {
            cake = backedCakes.poll();
            backedCakes.add(cake);
            cake = backedCakes.poll();
            System.out.printf("The %s %s rejected the %s cake snº %d due bad appearance.\n\n",john.getJobTitle(), john.getName(), cake.getName(),cake.getSerialNumber());
        }

        while (!backedCakes.isEmpty()) {
            cake = john.pack(backedCakes.poll());
            packedCakes.add(cake);
        }

        productionStatus(unbackedCakes.size(), backedCakes.size(), packedCakes.size());
        System.out.printf("Total demand: %d | produced: %d.\n", cakeDemand, packedCakes.size());
        System.out.print("snº list: ");
        message = "";
        while (!packedCakes.isEmpty()) {
            if (!"".equals(message)) message += ", ";
            cake = packedCakes.poll();
            message += String.valueOf(cake.getSerialNumber());
        }
        System.out.printf(message);



    }

    public static void productionStatus(int n1, int n2, int n3) {
        System.out.println("******************************************************************************");
        System.out.printf("Production status: unbacked cakes: %d | backed cakes: %d | packed cakes: %d",n1, n2, n3);
        System.out.println();
        System.out.println("******************************************************************************");
        System.out.println();
    }
}
