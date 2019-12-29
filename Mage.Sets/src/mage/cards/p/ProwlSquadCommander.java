package mage.cards.p;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.DealsDamageToAPlayerAllTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.PreventAllDamageToSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SetTargetPointer;
import mage.constants.SubType;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.game.permanent.token.ScimitarToken;

/**
 * @author uses
 */
public final class ProwlSquadCommander extends CardImpl {

    private static final FilterPermanent filter
            = new FilterControlledCreaturePermanent(SubType.CAT, "a Cat you control");

    public ProwlSquadCommander(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{G}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Prevent all damage that would be dealt to ~.
        this.addAbility(new SimpleStaticAbility(new PreventAllDamageToSourceEffect(Duration.WhileOnBattlefield)));
        
        // Whenever a Cat you conrtol deals combat damage to a player, draw a card, then create a Scimitar token.
        Ability ability = new DealsDamageToAPlayerAllTriggeredAbility(
                new DrawCardSourceControllerEffect(1), filter,
                false, SetTargetPointer.NONE, true
        );
        ability.addEffect(new CreateTokenEffect(new ScimitarToken()));
        this.addAbility(ability);

    }

    private ProwlSquadCommander(final ProwlSquadCommander card) {
        super(card);
    }

    @Override
    public ProwlSquadCommander copy() {
        return new ProwlSquadCommander(this);
    }
}
