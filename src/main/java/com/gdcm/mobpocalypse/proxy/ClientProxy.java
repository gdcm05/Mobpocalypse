package com.gdcm.mobpocalypse.proxy;

import com.gdcm.mobpocalypse.Mobpocalypse;
import com.gdcm.mobpocalypse.entity.general.ModEntities;
import com.gdcm.mobpocalypse.entity.general.RegisterEntities;
import com.gdcm.mobpocalypse.entity.mini_mogus.MiniMogus;
import com.gdcm.mobpocalypse.entity.mini_mogus.RenderMiniMogus;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import software.bernie.geckolib3.GeckoLib;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit(FMLPreInitializationEvent e)
    {

        RenderingRegistry.registerEntityRenderingHandler(MiniMogus.class, RenderMiniMogus::new);
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e)
    {


    }

}
