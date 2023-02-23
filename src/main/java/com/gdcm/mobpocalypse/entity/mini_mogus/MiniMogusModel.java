package com.gdcm.mobpocalypse.entity.mini_mogus;

import com.gdcm.mobpocalypse.Mobpocalypse;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@SideOnly(Side.CLIENT)
public class MiniMogusModel extends AnimatedGeoModel<MiniMogus>
{

    private static final ResourceLocation modelResource = new ResourceLocation(Mobpocalypse.MODID, "geo/entities/mini_mogus.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(Mobpocalypse.MODID, "textures/entities/mini_mogus_tex.png");
    private static final ResourceLocation animationResource = new ResourceLocation(Mobpocalypse.MODID, "animations/minimogus_anims.json");

    @Override
    public ResourceLocation getModelLocation(MiniMogus object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(MiniMogus object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MiniMogus object) {
        return animationResource;
    }

}
