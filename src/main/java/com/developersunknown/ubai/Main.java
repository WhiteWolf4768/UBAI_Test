package com.developersunknown.ubai;

import com.developersunknown.ubai.actions.Action;
import com.developersunknown.ubai.actions.impl.HealerHealingX;
import com.developersunknown.ubai.behaviors.healer.HealerBehavior;
import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.bot.BotClass;
import com.developersunknown.ubai.senses.Sense;
import com.developersunknown.ubai.senses.impl.*;
import lombok.extern.slf4j.Slf4j;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {
        Bot playerPuff = new Bot("Puff", BotClass.HEALER, 300, 300, 2, 4, false, false, true, new Point3f(1, 1, 1), new Vector3f(2,2,0),null);
        Bot mcLoud = new Bot("McLoud", BotClass.STORMTROOPER, 100, 400, 0, 0, true, false,true, new Point3f(2, 2, 2), new Vector3f(0,0,0),null);
        Bot crystal = new Bot("Crystal", BotClass.SNIPER, 150, 200, 0, 0, false, false, false,new Point3f(5, 5, 0), new Vector3f(0,0,0),null);

//        Bot mcLoud = new Bot("McLoud", BotClass.STORMTROOPER, 400, 400, true, false, new Point3f(2,2,2), null);
//        Bot crystal = new Bot("Crystal", BotClass.SNIPER, 150, 200, false, false, new Point3f(1,1,1), null);
//        Bot crystal = new Bot("Crystal", BotClass.SNIPER, 200, 200, false, false, new Point3f(1,1,1), null);

        List<Sense> sensesMcLoud = new ArrayList<>();
        List<Sense> sensesCrystal = new ArrayList<>();

        //Puff senses
        HealsLeft healsLeft = new HealsLeft("healsLeft", playerPuff, Map.of("min_value", List.of(0f, 0.0f),
                "max_value", List.of(2f, 1.0f)));

        //Mcloud
        TargetClass targetClass = new TargetClass("targetClass", mcLoud, Map.of("tank", List.of(1f),
                "stormtrooper", List.of(0.3f),
                "scout", List.of(0.2f),
                "sniper", List.of(0.2f),
                "healer", List.of(0.1f)));
        IsTargetOnSpot targetOnSpot = new IsTargetOnSpot("targetOnSpot", mcLoud, Map.of("true", List.of(1f),
                "false", List.of(0.3f)));
        TargetDistance targetDistance = new TargetDistance("targetDistance", playerPuff, mcLoud, Map.of("min_value", List.of(3f, 1.0f),
                "max_value", List.of(20f, 0.0f)));
        IsTargetNearShield isTargetNearShield = new IsTargetNearShield("isTargetNearShield", mcLoud, Map.of("true", List.of(1f),
                "false", List.of(0.3f)));
        TargetHpPoints targetHpPoints = new TargetHpPoints("targetHpPoints", mcLoud, Map.of("min_value", List.of(0.3f, 1.0f),
                "max_value", List.of(0.6f, 0.0f)));
        IsTargetPlayer isTargetPlayer = new IsTargetPlayer("targetIsPlayer", mcLoud, Map.of("true", List.of(1f),
                "false", List.of(0.65f)));
        DegreeToTarget degreeToTarget = new DegreeToTarget("degreeToTarget", playerPuff, mcLoud, Map.of("min_value", List.of(120f, 1.0f),
                "max_value", List.of(180f, 0.0f)));

        sensesMcLoud.addAll(List.of(targetClass, targetOnSpot, targetDistance, isTargetNearShield, targetHpPoints, healsLeft, isTargetPlayer, degreeToTarget));

        //Crystal
        TargetClass targetClass2 = new TargetClass("targetClass", crystal, Map.of("tank", List.of(1f),
                "stormtrooper", List.of(0.3f),
                "scout", List.of(0.2f),
                "sniper", List.of(0.2f),
                "healer", List.of(0.1f)));
        IsTargetOnSpot targetOnSpot2 = new IsTargetOnSpot("targetOnSpot", crystal, Map.of("true", List.of(1f),
                "false", List.of(0.3f)));
        TargetDistance targetDistance2 = new TargetDistance("targetDistance", playerPuff, crystal, Map.of("min_value", List.of(3f, 1.0f),
                "max_value", List.of(20f, 0.0f)));
        IsTargetNearShield isTargetNearShield2 = new IsTargetNearShield("isTargetNearShield", crystal, Map.of("true", List.of(1f),
                "false", List.of(0.3f)));
        TargetHpPoints targetHpPoints2 = new TargetHpPoints("targetHpPoints", crystal, Map.of("min_value", List.of(0.3f, 1.0f),
                "max_value", List.of(0.6f, 0.0f)));
        IsTargetPlayer isTargetPlayer2 = new IsTargetPlayer("targetIsPlayer", crystal, Map.of("true", List.of(1f),
                "false", List.of(0.65f)));
        DegreeToTarget degreeToTarget2 = new DegreeToTarget("degreeToTarget", playerPuff, crystal, Map.of("min_value", List.of(120f, 1.0f),
                "max_value", List.of(180f, 0.0f)));

        sensesCrystal.addAll(List.of(targetClass2, targetOnSpot2, targetDistance2, isTargetNearShield2, targetHpPoints2, healsLeft, isTargetPlayer2, degreeToTarget2));

        HealerHealingX healerHealingMcLoud = new HealerHealingX("healerHealingMcloud", 1, 3, sensesMcLoud);
        HealerHealingX healerHealingCrystal = new HealerHealingX("healerHealingCrystal", 1, 3, sensesCrystal);

        List<Action> actionList = new ArrayList();

        actionList.addAll(List.of(healerHealingMcLoud, healerHealingCrystal));

        HealerBehavior healerBehavior = new HealerBehavior("HealerBehavior", actionList);


        log.info("Me: {}", playerPuff);
        log.info("BOT: {}", mcLoud);
        log.info("BOT: {}", crystal);
        healerBehavior.chooseAction();
    }
}
