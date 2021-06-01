package com.developersunknown.ubai.senses.impl;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class TargetClass extends Sense {

    public TargetClass(String senseId, Bot target, Map<String, List<Float>> params) {
        super(senseId, target, params);
    }

    @Override
    public float calculateScore() {
        log.info("Sense {} params: {}", getSenseId(), getParams().toString());
        log.info("Target {} class = {}", getTarget().getName(), getTarget().getBotClass());

        Float weight = getParams().get(getTarget().getBotClass().name().toLowerCase()).get(0);

        if (weight != null) {
            return weight;
        } else {
            return 0;
        }
    }
}
