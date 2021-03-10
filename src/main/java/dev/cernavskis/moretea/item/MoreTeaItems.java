package dev.cernavskis.moretea.item;

import dev.cernavskis.moretea.MoreTea;
import dev.cernavskis.moretea.config.MoreTeaConfig;
import knightminer.simplytea.core.Registration;
import knightminer.simplytea.item.TeaCupItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = MoreTea.MOD_ID, bus = Bus.MOD)
class MoreTeaItems {
  private static final Item.Properties TEA_PROPERTIES = new Item.Properties().tab(Registration.group).stacksTo(1).durability(2).setNoRepair().craftRemainder(Registration.cup);

  public static final Item MINT_TEABAG = new Item(new Item.Properties().tab(Registration.group));
  public static final Item MINT_TEA_CUP = new TeaCupItem(TEA_PROPERTIES.food(MoreTeaConfig.SERVER.MINT_TEA));

  @SubscribeEvent
  public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();

    MoreTea.LOGGER.debug("Registering items...");
    register(r, MINT_TEABAG, "teabag_mint");
    register(r, MINT_TEA_CUP, "cup_tea_mint");
  }

  /**
   * Registers a forge registry object using the given name and a domain of "moretea"
   * 
   * @param registry Forge registry
   * @param value    Value to register
   * @param name     Registration name
   * @param <V>      Value class, extends registry class
   * @param <R>      Registry class
   * @return Registered value
   */
  private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value, String name) {
    value.setRegistryName(new ResourceLocation(MoreTea.MOD_ID, name));
    registry.register(value);
    return value;
  }
}
