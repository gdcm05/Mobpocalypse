package com.gdcm.mobpocalypse.entity.mini_mogus;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import com.gdcm.mobpocalypse.entity.mini_mogus.MiniMogus;
import com.gdcm.mobpocalypse.entity.mini_mogus.MiniMogusModel;


public class RenderMiniMogus extends GeoEntityRenderer<MiniMogus>
{

    public RenderMiniMogus(RenderManager rendererManager)
    {
        super(rendererManager, new MiniMogusModel());
            this.shadowSize = 0.2f;

    }

}
