package mage.cards.r;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.LoyaltyAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.cost.CostModificationEffectImpl;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AbilityType;
import mage.constants.CardType;
import mage.constants.CostModificationType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.game.Game;
import mage.util.CardUtil;

/**
 * @author uses
 */
public final class RealmGuardian extends CardImpl {

    public RealmGuardian(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}{W}");

        this.subtype.add(SubType.CAT);
        this.subtype.add(SubType.KNIGHT);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        this.addAbility(new SimpleStaticAbility(new RealmGuardianCostIncreaseEffect()));

    }

    private RealmGuardian(final RealmGuardian card) {
        super(card);
    }

    @Override
    public RealmGuardian copy() {
        return new RealmGuardian(this);
    }
}

class RealmGuardianCostIncreaseEffect extends CostModificationEffectImpl {

    private static final String effectText = "Loyalty abilities your opponents activate cost {2} more to activate";

    RealmGuardianCostIncreaseEffect() {
        super(Duration.WhileOnBattlefield, Outcome.Benefit, CostModificationType.INCREASE_COST);
        staticText = effectText;
    }

    RealmGuardianCostIncreaseEffect(RealmGuardianCostIncreaseEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source, Ability abilityToModify) {
        CardUtil.increaseCost(abilityToModify, 2);
        return true;
    }

    @Override
    public boolean applies(Ability abilityToModify, Ability source, Game game) {
        if (abilityToModify.getAbilityType() == AbilityType.ACTIVATED &&
            game.getOpponents(source.getControllerId()).contains(abilityToModify.getControllerId()) &&
            abilityToModify instanceof LoyaltyAbility
        ) {
            return true;
        }
        return false;
    }

    @Override
    public RealmGuardianCostIncreaseEffect copy() {
        return new RealmGuardianCostIncreaseEffect(this);
    }

}
