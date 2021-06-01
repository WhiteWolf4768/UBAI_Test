package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import com.developersunknown.ubai.utils.RangeCalculator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class HealsLeft extends Sense {
    public HealsLeft(String senseId, Bot target, Map<String, List<Float>> params) {
        super(senseId, target, params);
    }

    @Override
    public float calculateScore() {

        float minRange = getParams().get("min_value").get(0);
        float minValue = getParams().get("min_value").get(1);
        float maxRange = getParams().get("max_value").get(0);
        float maxValue = getParams().get("max_value").get(1);

        log.info("Sense {} params: {min_value = {}, max_value = {}}", getSenseId(), getParams().get("min_value"), getParams().get("max_value"));
        log.info("Me {} maxHeals: {}, currHeals: {}", getTarget().getName(), getTarget().getMaxHealCount(), getTarget().getHealCount());

        return RangeCalculator.calculateRange(minRange, minValue, maxRange, maxValue, getTarget().getHealCount());
    }
}
