package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.DealsDamageToAPlayerAllTriggeredAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapTargetCost;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.effects.keyword.ScryEffect;
import mage.abilities.keyword.DoubleStrikeAbility;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SetTargetPointer;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.common.TargetControlledPermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 * @author uses
 */
public final class SkyPounceCaptain extends CardImpl {

    private static final FilterControlledCreaturePermanent filter
            = new FilterControlledCreaturePermanent("untapped creatures you control");
    private static final FilterPermanent filter2
            = new FilterControlledCreaturePermanent(SubType.CAT, "a Cat you control");

    static {
        filter.add(Predicates.not(TappedPredicate.instance));
    }

    public SkyPounceCaptain(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{W}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // Doublestrike
        this.addAbility(DoubleStrikeAbility.getInstance());

        // Tap two untapped creatures you control: target creature gains flying until end of turn.
        Ability ability = new SimpleActivatedAbility(
                Zone.BATTLEFIELD,
                new GainAbilityTargetEffect(FlyingAbility.getInstance(), Duration.EndOfTurn),
                new TapTargetCost(new TargetControlledPermanent(2, 2, filter, false))
        );
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);

        // Whenever a cat you conrtol deals combat damage to a player, scry 1.
        Ability ability2 = new DealsDamageToAPlayerAllTriggeredAbility(
                new ScryEffect(1),
                filter2,
                false, SetTargetPointer.NONE, true
        );
        this.addAbility(ability2);
    }

    private SkyPounceCaptain(final SkyPounceCaptain card) {
        super(card);
    }

    @Override
    public SkyPounceCaptain copy() {
        return new SkyPounceCaptain(this);
    }
}
