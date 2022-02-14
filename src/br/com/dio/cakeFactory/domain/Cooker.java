package br.com.dio.cakeFactory.domain;


import lombok.Data;

@Data
public class Cooker extends ProductionEmployee<String, CakeMixture>{

    public Cooker(String name) {
        this.name = name;
        this.jobTitle = "Cooker";
    }

    /*
    public CakeMixture mixIngredients(CakeMixture cake) {
        cake.setMixtureReady(true);
        System.out.printf("The %s %s has mixed the ingredients to prepare the %s snº %d.\n",jobTitle, name,cake.getName(), cake.getSerialNumber());
        return cake;
    }

     */

    public CakeMixture bake(CakeMixture cake) {
        System.out.printf("The %s %s baked the %s snº %d during %d minutes.\n",
                this.getJobTitle(), this.getName(), cake.getName(), cake.getSerialNumber(), cake.getBakingTimeInMinutes());
        cake.setBaked(true);
        return cake;
    }
}
