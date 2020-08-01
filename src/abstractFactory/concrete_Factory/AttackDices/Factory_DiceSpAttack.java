package abstractFactory.concrete_Factory.AttackDices;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceArtillery;
import abstractFactory.concrete_Product.DiceSpAttack;

public class Factory_DiceSpAttack implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceSpAttack newDice = new DiceSpAttack();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
