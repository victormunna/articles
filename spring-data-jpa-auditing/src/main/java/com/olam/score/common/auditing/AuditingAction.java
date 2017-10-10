package com.olam.score.common.auditing;

public enum AuditingAction {

    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String actionTypeName;

    private AuditingAction(String actionType) {
        this.actionTypeName = actionType;
    }

    public String actionType() {
        return this.actionTypeName;
    }

    @Override
    public String toString() {
        return actionTypeName;
    }
}
