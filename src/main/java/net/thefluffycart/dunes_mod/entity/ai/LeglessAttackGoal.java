package net.thefluffycart.dunes_mod.entity.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.thefluffycart.dunes_mod.entity.custom.LeglessEntity;

public class LeglessAttackGoal extends MeleeAttackGoal {
    private final LeglessEntity entity;
    private int attackDelay = 7;
    private int ticksUntilNextAttack = 7;
    private boolean shouldCountTillNextAttack = false;

    public LeglessAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((LeglessEntity) pMob);
    }


    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr))
        {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation())
            {
                entity.setAttacking(true);
            }

            if(isTimeToAttack())
            {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        }

        else
        {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr)
    {
        return pDistToEnemySqr <=this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown()
    {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    @Override
    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    @Override
    public int getTicksUntilNextAttack() {
        return ticksUntilNextAttack;
    }

    protected void performAttack(LivingEntity pEnemy)
    {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void start() {
        super.start();
        this.attackDelay = 8;
        this.ticksUntilNextAttack = 8;
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack)
        {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1,0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
