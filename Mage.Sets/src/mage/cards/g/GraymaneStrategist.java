package mage.cards.g;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.CastAsThoughItHadFlashAllEffect;
import mage.abilities.effects.common.continuous.LookAtTopCardOfLibraryAnyTimeEffect;
import mage.abilities.effects.common.continuous.PlayTheTopCardEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 * @author uses
 */
public final class GraymaneStrategist extends CardImpl {

    private static final FilterCard filter = new FilterCard("Cat or Equipment cards");
    private static final FilterCard filter2 = new FilterCard("Cat cards");
    
    static {
        filter.add(Predicates.or(
            new SubtypePredicate(SubType.CAT),
            new SubtypePredicate(SubType.EQUIPMENT)));
        filter2.add(new SubtypePredicate(SubType.CAT));
    }

    public GraymaneStrategist(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.ADVISOR);
        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // You may look at the top card of your library any time.
        this.addAbility(new SimpleStaticAbility(new LookAtTopCardOfLibraryAnyTimeEffect()));

        // You may cast the top card of your library if it's a Cat or Equipment.
        this.addAbility(new SimpleStaticAbility(
            new PlayTheTopCardEffect(filter).setText(
                "you may cast the top card of your library if it's a Cat or Equipment card"
            )
        ));

        // You may cast Cat cards as though they had flash.
        this.addAbility(new SimpleStaticAbility(
            Zone.BATTLEFIELD,
            new CastAsThoughItHadFlashAllEffect(Duration.WhileOnBattlefield, filter2)
        ));
    }

    private GraymaneStrategist(final GraymaneStrategist card) {
        super(card);
    }

    @Override
    public GraymaneStrategist copy() {
        return new GraymaneStrategist(this);
    }
}
