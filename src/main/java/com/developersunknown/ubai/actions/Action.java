package com.developersunknown.ubai.actions;

import com.developersunknown.ubai.bot.Bot;
import com.developersunknown.ubai.senses.Sense;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public abstract class Action implements ActionInterface {

    private String actionId;
    private float modificationFactor;

    protected float actionWeight;
    protected float momentumWeight;

    protected List<Sense> senseList;

    public Action(String actionId, float actionWeight, float momentumWeight, List<Sense> senseList) {
        this.actionId = actionId;
        this.actionWeight = actionWeight;
        this.momentumWeight = momentumWeight;
        this.senseList = senseList;

        modificationFactor = 1 - new BigDecimal(1)
                .divide(new BigDecimal(senseList.size()), 5, RoundingMode.FLOOR)
                .floatValue();
    }

    public float calculateWeight() {
        log.info("Calculate weight for action: {}", actionId);
        log.info("Number of senses = {}", senseList.size());
        log.info("Modification factor for action: {} = {}", actionId, modificationFactor);
        log.info("Modification factor = 1 - (1 / {})", senseList.size());
        List<Float> adjustedSenseScoreList = new ArrayList<>();

        senseList.forEach(sense -> {
            float senseScore = sense.calculateScore();
            log.info("Sense score for {} = {}", sense.getSenseId(), senseScore);
            Float ass = senseScore * (1 + modificationFactor * (1 - senseScore));
            log.info("Adjusted Sense score for {} = {}", sense.getSenseId(), ass);
            log.info("Adjusted Sense score = {} * (1 + {} * (1 - {}))", senseScore, modificationFactor, senseScore);
            adjustedSenseScoreList.add(ass);
        });

        StringBuilder stringBuilder = new StringBuilder();

        adjustedSenseScoreList.forEach(ass -> {
            stringBuilder.append(ass);
            stringBuilder.append(" * ");
        });

        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());

        float completeAss = adjustedSenseScoreList.get(0);
        for (int i = 1; i < adjustedSenseScoreList.size(); i++) {
            completeAss = completeAss * adjustedSenseScoreList.get(i);
        }

//        Проверить пред. действие
//        if (checkPreviousAction()) {
//
//        }

        float actionScore = completeAss * actionWeight;

        log.info("Action score for action: {} = {}", actionId, actionScore);
        log.info("Action score = ({}) * {}", stringBuilder, actionWeight);
        log.info("Action score = {} * {}", completeAss, actionWeight);

        return actionScore;
    }

    private boolean checkPreviousAction(Bot player) {
        return player.getPreviousAction().equals(actionId);
    }
}
