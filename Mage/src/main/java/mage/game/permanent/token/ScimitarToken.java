

package mage.game.permanent.token;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.continuous.BoostEquippedEffect;
import mage.abilities.keyword.EquipAbility;
import mage.constants.Outcome;
import mage.constants.Zone;

/**
 *
 * @author uses
 */
public final class ScimitarToken extends TokenImpl {

    public ScimitarToken() {
        super("Scimitar", "colorless Equipment artifact token named Scimitar, \"Equipped creature gets +2/+1,\" and equip {2}");
        cardType.add(CardType.ARTIFACT);
        subtype.add(SubType.EQUIPMENT);

        Ability ability = new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostEquippedEffect(2, 1));
        this.addAbility(ability);

        this.addAbility(new EquipAbility(Outcome.BoostCreature, new GenericManaCost(2)));
    }

    public ScimitarToken(final ScimitarToken token) {
        super(token);
    }

    public ScimitarToken copy() {
        return new ScimitarToken(this);
    }
}
