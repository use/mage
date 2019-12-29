package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author uses
 */
public final class DellieWorld extends ExpansionSet {

    private static final DellieWorld instance = new DellieWorld();

    public static DellieWorld getInstance() {
        return instance;
    }

    private DellieWorld() {
        super("Dellie World", "DEL", ExpansionSet.buildDate(2019, 12, 28), SetType.EXPANSION);
        this.blockName = "Dellie World";
        this.hasBoosters = true;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        this.maxCardNumberInBooster = 269;

        cards.add(new SetCardInfo("Deepwood Stalker", 1, Rarity.UNCOMMON, mage.cards.d.DeepwoodStalker.class));
        cards.add(new SetCardInfo("Foremost Cub", 2, Rarity.UNCOMMON, mage.cards.f.ForemostCub.class));
        cards.add(new SetCardInfo("Graymane Strategist", 3, Rarity.RARE, mage.cards.g.GraymaneStrategist.class));
        cards.add(new SetCardInfo("Leonin Forgemaster", 4, Rarity.RARE, mage.cards.l.LeoninForgemaster.class));
        cards.add(new SetCardInfo("Leonin Reinforcer", 5, Rarity.RARE, mage.cards.l.LeoninReinforcer.class));
        cards.add(new SetCardInfo("Leonin Requisitioner", 6, Rarity.UNCOMMON, mage.cards.l.LeoninRequisitioner.class));
        cards.add(new SetCardInfo("Lost Pride Champion", 7, Rarity.RARE, mage.cards.l.LostPrideChampion.class));
        cards.add(new SetCardInfo("Lost Pride Avenger", 18, Rarity.MYTHIC, mage.cards.l.LostPrideAvenger.class));
        cards.add(new SetCardInfo("Pridecaller", 8, Rarity.UNCOMMON, mage.cards.p.Pridecaller.class));
        cards.add(new SetCardInfo("Prowl Squad Commander", 16, Rarity.RARE, mage.cards.p.ProwlSquadCommander.class));
        cards.add(new SetCardInfo("Realm Guardian", 9, Rarity.RARE, mage.cards.r.RealmGuardian.class));
        cards.add(new SetCardInfo("Stonepaw Brawler", 10, Rarity.RARE, mage.cards.s.StonepawBrawler.class));
        cards.add(new SetCardInfo("Stonepaw Martialist", 11, Rarity.RARE, mage.cards.s.StonepawMartialist.class));
        cards.add(new SetCardInfo("Wildclaw Reclaimer", 12, Rarity.UNCOMMON, mage.cards.w.WildclawReclaimer.class));
        cards.add(new SetCardInfo("Wildclaw Recruit", 13, Rarity.UNCOMMON, mage.cards.w.WildclawRecruit.class));
        cards.add(new SetCardInfo("Skypounce Captain", 17, Rarity.RARE, mage.cards.s.SkyPounceCaptain.class));
        cards.add(new SetCardInfo("Wildclaw Tracker", 14, Rarity.COMMON, mage.cards.w.WildclawTracker.class));
        cards.add(new SetCardInfo("Wildclaw Vanguard", 15, Rarity.UNCOMMON, mage.cards.w.WildclawVanguard.class));
    }
}
