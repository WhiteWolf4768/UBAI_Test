package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import com.developersunknown.ubai.utils.RangeCalculator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class TargetDistance extends Sense {

    public TargetDistance(String senseId, Bot player, Bot target, Map<String, List<Float>> params) {
        super(senseId, player, target, params);
    }

    @Override
    public float calculateScore() {
        log.info("Sense {} params: {min_value = {}, max_value = {}}", getSenseId(), getParams().get("min_value"), getParams().get("max_value"));
        log.info("My {} position = {}", getPlayer().getName(), getPlayer().getPos());
        log.info("Target {} position = {}", getTarget().getName(), getTarget().getPos());

        float minRange = getParams().get("min_value").get(0);
        float minValue = getParams().get("min_value").get(1);
        float maxRange = getParams().get("max_value").get(0);
        float maxValue = getParams().get("max_value").get(1);

        float distance = getPlayer().getPos().distance(getTarget().getPos());

        log.info("Distance between {} and {} = {}", getPlayer().getName(), getTarget().getName(), distance);

        return RangeCalculator.calculateRange(minRange, minValue, maxRange, maxValue, distance);
    }
}
