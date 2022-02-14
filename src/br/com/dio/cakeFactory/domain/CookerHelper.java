package br.com.dio.cakeFactory.domain;

import lombok.Data;

@Data
public class CookerHelper extends ProductionEmployee<String, CakeMixture>{

    public CookerHelper(String name) {
        this.name = name;
        this.jobTitle = "Cooker Helper";
    }

    /*
    public CakeMixture pickIngredients(String cakeName) {
        CakeMixture cake = new CakeMixture(cakeName);

        System.out.printf("The %s %s has picked the ingredients to prepare the %s snº %d.\n",jobTitle, name,cake.getName(), cake.getSerialNumber());
        return cake;
    }

     */

    public CakeMixture pack(CakeMixture cake) {
        System.out.printf("The %s %s packed the %s snº %d.\n",
                this.getJobTitle(), this.getName(), cake.getName(), cake.getSerialNumber());
        cake.setPacked(true);
        return cake;
    }
}
