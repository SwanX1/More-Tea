package dev.cernavskis.moretea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(MoreTea.MOD_ID)
public class MoreTea {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "moretea";
  
  public MoreTea() {
    LOGGER.debug("Loading More Tea!");
    MinecraftForge.EVENT_BUS.register(this);
  }
}
