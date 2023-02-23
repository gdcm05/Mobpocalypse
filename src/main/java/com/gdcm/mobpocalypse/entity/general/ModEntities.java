package com.gdcm.mobpocalypse.entity.general;

import com.gdcm.mobpocalypse.Mobpocalypse;
import com.gdcm.mobpocalypse.entity.mini_mogus.MiniMogus;
import com.gdcm.mobpocalypse.entity.mini_mogus.RenderMiniMogus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;

public class ModEntities {

    public static void init()
    {
        int id = 1;

        EntityRegistry.registerModEntity(new ResourceLocation(Mobpocalypse.MODID, "entity.mini_mogus"), MiniMogus.class, "mini_mogus", id++, Mobpocalypse.instance, 64, 3, true, 0x222222, 0x555555);

    }


}
