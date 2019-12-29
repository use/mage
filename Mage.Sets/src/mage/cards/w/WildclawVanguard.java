
package mage.cards.w;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.MyTurnCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.effects.keyword.ScryEffect;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Zone;

/**
 *
 * @author uses
 */
public final class WildclawVanguard extends CardImpl {

    public WildclawVanguard(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(3);
        this.toughness = new MageInt(1);

        this.addAbility(new SimpleStaticAbility(
            Zone.BATTLEFIELD,
            new ConditionalContinuousEffect(
                new GainAbilitySourceEffect(
                    FirstStrikeAbility.getInstance(),
                    Duration.WhileOnBattlefield
                ), MyTurnCondition.instance,
                "As long as it's your turn, "
                + "{this} has first strike."
            )
        ));

        this.addAbility(new AttacksTriggeredAbility(new ScryEffect(1), false));
    }

    public WildclawVanguard(final WildclawVanguard card) {
        super(card);
    }

    @Override
    public WildclawVanguard copy() {
        return new WildclawVanguard(this);
    }
}
