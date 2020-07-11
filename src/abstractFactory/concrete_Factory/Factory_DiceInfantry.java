package abstractFactory.concrete_Factory;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceInfantry;

public class Factory_DiceInfantry implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceInfantry newDice = new DiceInfantry();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
