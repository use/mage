package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.LimitedTimesPerTurnActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.TimingRule;
import mage.constants.Zone;
import mage.game.permanent.token.ScimitarToken;

/**
 * @author uses
 */
public final class LeoninForgemaster extends CardImpl {

    public LeoninForgemaster(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.ARTIFICER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        LimitedTimesPerTurnActivatedAbility ability = new LimitedTimesPerTurnActivatedAbility(
            Zone.BATTLEFIELD,
            new CreateTokenEffect(new ScimitarToken(), 1),
            new ManaCostsImpl("{1}{W}"),
            1
        );
        ability.setTiming(TimingRule.SORCERY);
        this.addAbility(ability);

    }

    private LeoninForgemaster(final LeoninForgemaster card) {
        super(card);
    }

    @Override
    public LeoninForgemaster copy() {
        return new LeoninForgemaster(this);
    }
}
