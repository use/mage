
package mage.cards.p;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.common.LookLibraryAndPickControllerEffect;
import mage.abilities.keyword.TrampleAbility;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 *
 * @author uses
 */
public final class Pridecaller extends CardImpl {

    private static final FilterCard filter = new FilterCard("a Cat card");

    static {
        filter.add(new SubtypePredicate(SubType.CAT));
    }

    public Pridecaller(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{G}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.WARRIOR);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);

        this.addAbility(TrampleAbility.getInstance());

        this.addAbility(new AttacksTriggeredAbility(
            new LookLibraryAndPickControllerEffect(
                new StaticValue(5), false, new StaticValue(1), filter, Zone.LIBRARY, false,
                true, false, Zone.HAND, true, false, false
            ).setBackInRandomOrder(true)
        , false));
    }

    public Pridecaller(final Pridecaller card) {
        super(card);
    }

    @Override
    public Pridecaller copy() {
        return new Pridecaller(this);
    }
}
