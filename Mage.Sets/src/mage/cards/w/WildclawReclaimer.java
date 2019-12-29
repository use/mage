package mage.cards.w;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.DealsCombatDamageToAPlayerTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.game.permanent.token.ScimitarToken;

/**
 * @author uses
 */
public final class WildclawReclaimer extends CardImpl {

    public WildclawReclaimer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.WARRIOR);
        this.power = new MageInt(2);
        this.toughness = new MageInt(3);

        this.addAbility(new DealsCombatDamageToAPlayerTriggeredAbility(
            new CreateTokenEffect(new ScimitarToken(), 1), false
        ).setOrPlaneswalker(true));
    }

    private WildclawReclaimer(final WildclawReclaimer card) {
        super(card);
    }

    @Override
    public WildclawReclaimer copy() {
        return new WildclawReclaimer(this);
    }
}
