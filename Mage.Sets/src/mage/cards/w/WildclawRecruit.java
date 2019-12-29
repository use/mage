
package mage.cards.w;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.LifelinkAbility;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.game.permanent.token.ScimitarToken;

/**
 *
 * @author uses
 */
public final class WildclawRecruit extends CardImpl {

    public WildclawRecruit(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        this.addAbility(LifelinkAbility.getInstance());
        this.addAbility(new EntersBattlefieldTriggeredAbility(new CreateTokenEffect(new ScimitarToken(), 1), false));
    }

    public WildclawRecruit(final WildclawRecruit card) {
        super(card);
    }

    @Override
    public WildclawRecruit copy() {
        return new WildclawRecruit(this);
    }
}
