package br.com.dio.cakeFactory.domain;

import lombok.Data;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

@Data
public abstract class Cake {
    private static int startedUnits;
    protected String name;
    protected int serialNumber = startedUnits;
    protected List<Ingredient> ingredients = new LinkedList<Ingredient>();
    protected boolean mixtureReady;
    protected Float preheatOvenTemperatureCelsiusDegree;
    protected int bakingTimeInMinutes;
    protected boolean baked;
    protected boolean packed;

    {
        packed = false;
        baked = false;
        mixtureReady = false;
    }

    public Cake() {
       startedUnits++;
       serialNumber = startedUnits;
    }

    public void bake() {
        System.out.println(String.format("Baking a %s cake - snº: %d. It will be ready in %d",this.name, this.serialNumber, this.bakingTimeInMinutes, this.bakingTimeInMinutes > 1 ? "s" : ""));
    }

    public void bake(int bakingTimeInMinutes) {
        System.out.println(String.format("Baking a %s cake - snº: %d. It will be ready in %d minute%s.",this.name, this.serialNumber, bakingTimeInMinutes, bakingTimeInMinutes > 1 ? "s" : ""));
    }
}
