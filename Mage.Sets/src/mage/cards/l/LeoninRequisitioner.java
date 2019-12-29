package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.search.SearchLibraryPutInHandEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.target.common.TargetCardInLibrary;

/**
 * @author uses
 */
public final class LeoninRequisitioner extends CardImpl {

    private static final FilterCard filter
            = new FilterCard("Cat or Equipment card");

    static {
        filter.add(Predicates.or(
                new SubtypePredicate(SubType.CAT),
                new SubtypePredicate(SubType.EQUIPMENT)
        ));
    }

    public LeoninRequisitioner(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{G}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // When Leonin Requisitioner enters the battlefield, you may search your library for a Cat or Equipment card, 
        // reveal it, put it into your hand, then shuffle your library.
        this.addAbility(new EntersBattlefieldTriggeredAbility(new SearchLibraryPutInHandEffect(
                new TargetCardInLibrary(filter), true, true), true));
    }

    private LeoninRequisitioner(final LeoninRequisitioner card) {
        super(card);
    }

    @Override
    public LeoninRequisitioner copy() {
        return new LeoninRequisitioner(this);
    }
}
