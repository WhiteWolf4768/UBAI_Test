package com.developersunknown.ubai.behaviors;

import com.developersunknown.ubai.actions.AbstractAction;

import java.util.List;

public class Behavior {

    protected final String behaviorId;

    protected final List<AbstractAction> actionList;

    public Behavior(String behaviorId, List<AbstractAction> actionList) {
        this.behaviorId = behaviorId;
        this.actionList = actionList;
    }

    public AbstractAction chooseAction() {
        return null;
    }
}
