package com.gdcm.mobpocalypse.entity.mini_mogus;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.UUID;

import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.LOOP;

public class MiniMogus extends EntityTameable implements IAnimatable
{

    private AnimationFactory factory;

    public MiniMogus( World worldIn)
    {
        super(worldIn);
        this.setTamed(false);
    }


    public EntityAgeable createChild(EntityAgeable ageable) {
        MiniMogus miniMogus = new MiniMogus(this.world);
        UUID uuid = this.getOwnerId();

        if (uuid != null)
        {
            miniMogus.setOwnerId(uuid);
            miniMogus.setTamed(true);
        }

        return miniMogus;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idlestandup.mini_mogus", LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController<MiniMogus>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }


    protected void initEntityAI()
    {
        this.aiSit = new EntityAISit(this);

        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.targetTasks.addTask(1, new EntityAIWatchClosest(this, EntityMob.class, 10.0F));

    }

    @Override
    protected void applyEntityAttributes()
    {

        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);

    }



    public boolean processInteract(EntityPlayer player, EnumHand hand) {

        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed() == false) {

            if (itemstack.getItem() == Items.GOLD_INGOT) {

                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }

                if (!this.world.isRemote) {
                    if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.setAttackTarget((EntityLivingBase) null);
                        this.aiSit.setSitting(true);
                        this.setHealth(20.0F);
                        this.playTameEffect(true);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.playTameEffect(false);
                        this.world.setEntityState(this, (byte) 6);
                    }

                }
                return true;
            }

        }
        return super.processInteract(player, hand);
    }

    @Override
    public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {return false; }

}
