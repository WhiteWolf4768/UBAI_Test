package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.bot.VectorCalculator;
import com.developersunknown.ubai.senses.Sense;
import com.developersunknown.ubai.utils.RangeCalculator;
import lombok.extern.slf4j.Slf4j;

import javax.vecmath.Vector3f;
import java.util.List;
import java.util.Map;

@Slf4j
public class DegreeToTarget extends Sense {
    public DegreeToTarget(String senseId, Bot player, Bot target, Map<String, List<Float>> params) {
        super(senseId, player, target, params);
    }

    @Override
    public float calculateScore() {

        log.info("Sense {} params: {min_value = {}, max_value = {}}", getSenseId(), getParams().get("min_value"), getParams().get("max_value"));
        log.info("My {} position = {}", getPlayer().getName(), getPlayer().getPos());
        log.info("Target {} position = {}", getTarget().getName(), getTarget().getPos());
        log.info("My {} vector direction = {}", getPlayer().getName(), getPlayer().getDirection());

        Vector3f directionToTarget = VectorCalculator.getDirection(getPlayer().getPos(), getTarget().getPos());

        double radiansBetweenVectors = getPlayer().getDirection().angle(directionToTarget);
        Double degrees = Math.toDegrees(radiansBetweenVectors);

        log.info("Normalized Vector from {} to {} = {}", getPlayer().getName(), getTarget().getName(), directionToTarget);
        log.info("Angle between {} and {}. Rad: {}, Deg: {}, DegInteger: {}", getPlayer().getDirection(), directionToTarget, radiansBetweenVectors, degrees, degrees.intValue());

        float minRange = getParams().get("min_value").get(0);
        float minValue = getParams().get("min_value").get(1);
        float maxRange = getParams().get("max_value").get(0);
        float maxValue = getParams().get("max_value").get(1);

        return RangeCalculator.calculateRange(minRange, minValue, maxRange, maxValue, degrees.intValue());
    }
}
