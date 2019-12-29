package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldControlledTriggeredAbility;
import mage.abilities.effects.keyword.ScryEffect;
import mage.abilities.keyword.FlashAbility;
import mage.abilities.keyword.VigilanceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 * @author uses
 */
public final class StonepawMartialist extends CardImpl {

    private static final FilterPermanent filter
        = new FilterCreaturePermanent("{this} or another Cat");

    static {
        filter.add(new SubtypePredicate(SubType.CAT));
    }

    public StonepawMartialist(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.MONK);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        // Flash
        this.addAbility(FlashAbility.getInstance());

        // Vigilance
        this.addAbility(VigilanceAbility.getInstance());

        // Whenever Stonepaw Martialist or another Cat enters the battlefield under your control, scry 1.
        this.addAbility(new EntersBattlefieldControlledTriggeredAbility(
                new ScryEffect(1),
                filter
        ));
    }

    private StonepawMartialist(final StonepawMartialist card) {
        super(card);
    }

    @Override
    public StonepawMartialist copy() {
        return new StonepawMartialist(this);
    }
}
