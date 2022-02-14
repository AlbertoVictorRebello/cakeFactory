package br.com.dio.cakeFactory.domain;

import lombok.Data;

import javax.xml.namespace.QName;

@Data
public abstract class ProductionEmployee<T, S> {
    protected String name;
    protected String jobTitle;

    public CakeMixture handleIngredients(CakeMixture cake) {
        cake.setMixtureReady(true);
        System.out.printf("The %s %s has mixed the ingredients to prepare the %s snº %d.\n",jobTitle, name,cake.getName(), cake.getSerialNumber());
        return cake;
    }

    public CakeMixture handleIngredients(String cakeName) {
        CakeMixture cake = new CakeMixture(cakeName);

        System.out.printf("The %s %s has picked the ingredients to prepare the %s snº %d.\n",jobTitle, name,cake.getName(), cake.getSerialNumber());
        return cake;
    }
}
