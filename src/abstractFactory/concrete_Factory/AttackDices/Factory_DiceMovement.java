package abstractFactory.concrete_Factory.AttackDices;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceArtillery;
import abstractFactory.concrete_Product.DiceMovement;

public class Factory_DiceMovement implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceMovement newDice = new DiceMovement();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
