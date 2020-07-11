package abstractFactory.concrete_Factory;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceArtillery;

public class Factory_DiceArtillery implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceArtillery newDice = new DiceArtillery();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
