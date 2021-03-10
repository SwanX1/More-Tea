package dev.cernavskis.moretea.config;

import org.apache.commons.lang3.tuple.Pair;

import dev.cernavskis.moretea.MoreTea;
import knightminer.simplytea.core.config.TeaDrink;
import knightminer.simplytea.core.config.TeaDrink.TeaEffect;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = MoreTea.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreTeaConfig {

  public static class Server {
    public TeaDrink MINT_TEA;

    public Server(Builder builder) {
      builder.comment("Stats for each available drink type").push("drinks");
      MINT_TEA = new TeaDrink("mint", builder, TeaEffect.HERBAL, 2, 0.5, 20, 2);
      builder.pop();
    }
  }

  public static final ForgeConfigSpec serverSpec;
  public static final Server SERVER;
  static {
    final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
    serverSpec = specPair.getRight();
    SERVER = specPair.getLeft();
  }

  @SubscribeEvent
  public static void onConfigReload(final ModConfig.Reloading event) {
    if (event.getConfig().getType() == ModConfig.Type.SERVER) {
      SERVER.MINT_TEA.invalidEffects();
    }
  }
}