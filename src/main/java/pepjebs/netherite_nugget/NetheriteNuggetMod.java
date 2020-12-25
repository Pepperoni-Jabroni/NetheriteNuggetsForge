package pepjebs.netherite_nugget;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(NetheriteNuggetMod.MOD_ID)
public class NetheriteNuggetMod {

    public static final String MOD_ID = "netherite_nugget";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> NETHERITE_NUGGET_ITEM = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties().isImmuneToFire().group(ItemGroup.MISC)));

    public NetheriteNuggetMod() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
