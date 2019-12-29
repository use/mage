package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.TriggeredAbility;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DoIfCostPaid;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToBattlefieldEffect;
import mage.abilities.keyword.HasteAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.permanent.ControllerPredicate;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.ZoneChangeEvent;

/**
 * @author uses
 */
public final class LostPrideAvenger extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("a Cat you control");

    static {
        filter.add(new SubtypePredicate(SubType.CAT));
        filter.add(new ControllerPredicate(TargetController.YOU));
    }

    public LostPrideAvenger(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{G}{G}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.BERSERKER);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Haste
        this.addAbility(HasteAbility.getInstance());

        // Trample
        this.addAbility(TrampleAbility.getInstance());

        // Whenever a Cat you control dies while ~ is in your graveyard, you may pay 1G.
        // If you do, return ~ from your graveyard to the battlefield tapped.
        TriggeredAbility ability = new DiesWhileInGraveyardTriggeredAbility(
                new DoIfCostPaid(
                        new ReturnSourceFromGraveyardToBattlefieldEffect(true),
                        new ManaCostsImpl("{1}{G}")),
                filter);
        this.addAbility(ability);
    }

    private LostPrideAvenger(final LostPrideAvenger card) {
        super(card);
    }

    @Override
    public LostPrideAvenger copy() {
        return new LostPrideAvenger(this);
    }
}

class DiesWhileInGraveyardTriggeredAbility extends TriggeredAbilityImpl {

    protected FilterCreaturePermanent filter;

    public DiesWhileInGraveyardTriggeredAbility(Effect effect, FilterCreaturePermanent filter) {
        super(Zone.GRAVEYARD, effect, false);
        this.filter = filter;
    }

    public DiesWhileInGraveyardTriggeredAbility(final DiesWhileInGraveyardTriggeredAbility ability) {
        super(ability);
        this.filter = ability.filter;
    }

    @Override
    public DiesWhileInGraveyardTriggeredAbility copy() {
        return new DiesWhileInGraveyardTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.ZONE_CHANGE;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        ZoneChangeEvent zEvent = (ZoneChangeEvent) event;
        for (Zone z : Zone.values()) {
            if (game.getShortLivingLKI(sourceId, z) && z != Zone.GRAVEYARD) {
                return false;
            }
        }
        if (zEvent.isDiesEvent()) {
            if (filter.match(zEvent.getTarget(), sourceId, controllerId, game)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever " + filter.getMessage() + " dies while {this} is in your graveyard, " + super.getRule();
    }

}
