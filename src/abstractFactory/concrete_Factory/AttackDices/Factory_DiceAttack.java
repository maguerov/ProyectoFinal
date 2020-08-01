package abstractFactory.concrete_Factory.AttackDices;

import abstractFactory.abstract_Factory.Dice_Obj;
import abstractFactory.abstract_Product.Dice;
import abstractFactory.concrete_Product.DiceArtillery;
import abstractFactory.concrete_Product.DiceAttack;

public class Factory_DiceAttack implements Dice_Obj {


    @Override
    public Dice createDiceInstance() {
        DiceAttack newDice = new DiceAttack();
        newDice.setDiceCode(newDice.generateDiceCode());
        newDice.setDiceType(newDice.generateDiceType());
        return newDice;
    }
}
