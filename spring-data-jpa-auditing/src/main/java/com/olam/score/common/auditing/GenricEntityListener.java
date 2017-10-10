package com.olam.score.common.auditing;

import static javax.transaction.Transactional.TxType.MANDATORY;
import static org.programming.mitra.Action.DELETED;
import static org.programming.mitra.Action.INSERTED;
import static org.programming.mitra.Action.UPDATED;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.transaction.Transactional;

import org.programming.mitra.BeanUtil;

public class GenricEntityListener<EntityClass> {
//https://dzone.com/articles/jpa-auditing-automatically-persisting-audit-logs
    @PostPersist
    public void prePersist(EntityClass target) {
        perform(target, INSERTED);
    }

    @PostUpdate
    public void preUpdate(EntityClass target) {
        perform(target, UPDATED);
    }

    @PostRemove
    public void preRemove(EntityClass target) {
        perform(target, DELETED);
    }

    @Transactional(MANDATORY)
    private void perform(EntityClass target, AuditingAction action) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        entityManager.persist(new EntityClassHistory(target, action));
    }
}
