package com.gdcm.mobpocalypse;

import com.gdcm.mobpocalypse.entity.mini_mogus.MiniMogus;
import com.gdcm.mobpocalypse.entity.mini_mogus.RenderMiniMogus;
import com.gdcm.mobpocalypse.proxy.CommonProxy;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(modid = Mobpocalypse.MODID, name = Mobpocalypse.NAME, version = Mobpocalypse.VERSION)
public class Mobpocalypse
{
    public static final String MODID = "mobpocalypse";
    public static final String NAME = "Mobpocalypse";
    public static final String VERSION = "0.0.1";


    @SidedProxy(clientSide = "com.gdcm.mobpocalypse.proxy.ClientProxy", serverSide = "com.gdcm.mobpocalypse.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Mobpocalypse instance;
    private static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }


    @EventHandler
    public void regularPreInit(FMLPreInitializationEvent event)
    {

        GeckoLib.initialize();

    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void registerRenderers(FMLPreInitializationEvent event) {
            RenderingRegistry.registerEntityRenderingHandler(MiniMogus.class, RenderMiniMogus::new);

    }


}
