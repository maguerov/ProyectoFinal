package controller;

import abstractFactory.abstract_Factory.Army_Unit;
import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.abstract_Product.Unit;
import abstractFactory.concrete_Factory.*;
import abstractFactory.concrete_Factory.Unit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static ArrayList<Dice> diceArray = new ArrayList<Dice>();

    public static String throwDice() {
        throwInvocationDices();
        //MISING THE OTHER DICE, THE ONE WITH THE ATTACKS AND MOVEMENTS

        return "\n" + "Dados lanzados de manera exitosa" + "\n";
    }

    public static void throwInvocationDices() {
        Dice_Obj moUnit;

        for (int i = 0; i < 2; i++) {
            int diceResult = Helper.throwDice();
            if (diceResult == 1 || diceResult == 2 || diceResult == 3) {
                moUnit = new Factory_DiceInfantry();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            } else if (diceResult == 4 || diceResult == 5) {
                moUnit = new Factory_DiceArtillery();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            } else {
                moUnit = new Factory_DiceTank();
                System.out.println("El resultado del dado fue: " + diceResult + "\n" + "De tipo: " + CreateDiceFactory(moUnit));
            }
        }
    }

    public static String CreateDiceFactory(Dice_Obj pFactory) {
        Dice objDice = pFactory.createDiceInstance();
        addToArray(objDice);
        return objDice.getType();
    }

    private static void addToArray(Dice pObjDice) {
        if (diceArray.size() < 6) {
            diceArray.add(pObjDice);
        } else {
            System.out.println("No se pueden agregar más dados de invocación, se ha alcanzado el tope máximo de 6");
        }
    }

    public static String countInvocationDices() {
        int artillery = 0, infantry = 0, tanks = 0;

        for (int i = 0; i < diceArray.size(); i++) {
            if (diceArray.get(i).getType().equals("DadoArtilleria")) {
                artillery++;
            } else if (diceArray.get(i).getType().equals("DadoInfanteria")) {
                infantry++;
            } else if (diceArray.get(i).getType().equals("DadoTanque")) {
                tanks++;
            }
        }
        return "Dados disponibles:" + "\n" +
                "Infantería: " + infantry + "\n" +
                "Artillería: " + artillery + "\n" +
                "Tanque: " + tanks + "\n";
    }


    public static void summonUnitMain(int unitType) {

        switch (unitType) {
            case 1:
                if (countDicesPerUnit("DadoInfanteria") >= 2) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar la infantería, insuficientes dados");
                }
                break;

            case 2:
                if (countDicesPerUnit("DadoArtilleria") >= 3) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar la artillería, insuficientes dados");
                }
                break;

            case 3:
                if (countDicesPerUnit("DadoTanque") >= 4) {
                    summonUnit(unitType);
                } else {
                    System.out.println("No se puede invocar el tanque, insuficientes dados");
                }
                break;

            default:
                break;

        }

    }

    public static int countDicesPerUnit(String diceType) {
        int total = 0;
        for (int i = 0; i < diceArray.size(); i++) {
            if (diceArray.get(i).getType().equals(diceType)) {
                total++;
            }
        }
        return total;
    }

    public static void summonUnit(int unitType) {
        Army_Unit moUnit;

        switch (unitType) {
            case 1:
                moUnit = new Factory_Infantry();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoInfanteria");
                break;

            case 2:
                moUnit = new Factory_Artillery();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoArtilleria");
                break;

            case 3:
                moUnit = new Factory_Tank();
                System.out.println(CreateUnitFactory(moUnit));
                removeDicesUnit("DadoTanque");
                break;

            default:
                break;
        }


    }

    public static String CreateUnitFactory(Army_Unit pFactory) {
        Unit objUnit = pFactory.createUnit();
        addToArmyArray(objUnit);
        return objUnit.getUnitInformation();
    }

    public static void removeDicesUnit(String diceType) {
        int dicesRemoved = 0;
        switch (diceType) {
            case "DadoInfanteria":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <2) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
                break;
            case "DadoArtilleria":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <3) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
                break;
            case "DadoTanque":
                for (int i = 0; i < diceArray.size(); i++) {
                    if (diceArray.get(i).getType().equals(diceType) & dicesRemoved <4) {
                        diceArray.remove(i);
                        dicesRemoved++;
                        i--;
                    }
                }
            default:
                break;
        }




    }

    private static HashMap<Integer, Unit> armyArray = new HashMap<Integer, Unit>();

    private static void addToArmyArray(Unit pObjUnit) {
        armyArray.put(pObjUnit.getCode(), pObjUnit);
    }

    public static String getInfoArmy() {
        String msData="";
        for(Map.Entry<Integer, Unit> entry : armyArray.entrySet()){
            msData = msData + entry.getValue().getUnitInformation() + "\n";
        }

        return msData;
    }
}