package com.developersunknown.ubai.actions.impl;

import com.developersunknown.ubai.actions.AbstractAction;
import com.developersunknown.ubai.senses.Sense;

import java.util.List;

public class HealerIdle extends AbstractAction {

    public HealerIdle(String actionId, float actionWeight, float momentumWeight, List<Sense> senseList) {
        super(actionId, actionWeight, momentumWeight, senseList);
    }
}
