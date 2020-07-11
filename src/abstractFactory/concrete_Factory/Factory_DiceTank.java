package abstractFactory.concrete_Factory;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceTank;

public class Factory_DiceTank implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceTank newDice = new DiceTank();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
