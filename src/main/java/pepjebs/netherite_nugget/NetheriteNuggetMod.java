package pepjebs.netherite_nugget;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pepjebs.netherite_nugget.config.NetheriteNuggetConfig;

@Mod(NetheriteNuggetMod.MOD_ID)
public class NetheriteNuggetMod {

    public static final String MOD_ID = "netherite_nugget";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> NETHERITE_NUGGET_ITEM = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties().isImmuneToFire().group(ItemGroup.MISC)));

    public NetheriteNuggetMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, NetheriteNuggetConfig.spec);

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }
}
