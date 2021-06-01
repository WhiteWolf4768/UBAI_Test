package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import com.developersunknown.ubai.utils.RangeCalculator;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Slf4j
public class TargetHpPoints extends Sense {

    public TargetHpPoints(String senseId, Bot target, Map<String, List<Float>> params) {
        super(senseId, target, params);
    }

    @Override
    public float calculateScore() {
        log.info("Sense {} params: {min_value = {}, max_value = {}}", getSenseId(), getParams().get("min_value"), getParams().get("max_value"));
        log.info("Target {} maxHp: {}, currHP: {}", getTarget().getName(), getTarget().getMaxHp(), getTarget().getHp());

        float minRange = getParams().get("min_value").get(0);
        float minValue = getParams().get("min_value").get(1);
        float maxRange = getParams().get("max_value").get(0);
        float maxValue = getParams().get("max_value").get(1);

        int hp = getTarget().getHp();

        float hpPercent = new BigDecimal(hp)
                .divide(new BigDecimal(getTarget().getMaxHp()), 5, RoundingMode.FLOOR)
                .floatValue();

        return RangeCalculator.calculateRange(minRange, minValue, maxRange, maxValue, hpPercent);
    }
}
