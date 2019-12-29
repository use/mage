package mage.cards.d;

import mage.MageInt;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import java.util.UUID;
import mage.abilities.common.DealsDamageToAPlayerAllTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.keyword.ExploreTargetEffect;
import mage.constants.SetTargetPointer;
import mage.filter.common.FilterControlledCreaturePermanent;

/**
 * @author uses
 */
public final class DeepwoodStalker extends CardImpl {

    public DeepwoodStalker(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{G}");

        this.subtype.add(SubType.CAT);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Whenever a Cat you conrtol deals combat damage to a player, that creature explores.
        Effect effect = new ExploreTargetEffect();
        effect.setText("that creature explores");
        this.addAbility(new DealsDamageToAPlayerAllTriggeredAbility(
            effect,
            new FilterControlledCreaturePermanent(SubType.CAT, "a Cat you control"), false, SetTargetPointer.PERMANENT, true
        ));
    }

    private DeepwoodStalker(final DeepwoodStalker card) {
        super(card);
    }

    @Override
    public DeepwoodStalker copy() {
        return new DeepwoodStalker(this);
    }
}
