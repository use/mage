package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldControlledTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.game.permanent.token.ScimitarToken;

/**
 * @author uses
 */
public final class LeoninReinforcer extends CardImpl {

    private static final FilterPermanent filter
        = new FilterCreaturePermanent("{this} or another Cat");

    static {
        filter.add(new SubtypePredicate(SubType.CAT));
    }

    public LeoninReinforcer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.ARTIFICER);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        this.addAbility(new EntersBattlefieldControlledTriggeredAbility(
            new CreateTokenEffect(new ScimitarToken()),
            filter
        ));
    }

    private LeoninReinforcer(final LeoninReinforcer card) {
        super(card);
    }

    @Override
    public LeoninReinforcer copy() {
        return new LeoninReinforcer(this);
    }
}
