package com.developersunknown.ubai.actions.impl;

import com.developersunknown.ubai.actions.Action;
import com.developersunknown.ubai.senses.Sense;

import java.util.List;

public class HealerHealingX extends Action {

    public HealerHealingX(String actionId, float actionWeight, float momentumWeight, List<Sense> senseList) {
        super(actionId, actionWeight, momentumWeight, senseList);
    }
}
