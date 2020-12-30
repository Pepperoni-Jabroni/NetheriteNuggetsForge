package pepjebs.netherite_nugget.loot;

import net.minecraft.entity.EntityType;
import net.minecraft.loot.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pepjebs.netherite_nugget.NetheriteNuggetMod;
import pepjebs.netherite_nugget.config.NetheriteNuggetConfig;

@Mod.EventBusSubscriber(modid = NetheriteNuggetMod.MOD_ID)
public class NetheriteNuggetBruteLootTable {

    @SubscribeEvent
    public static void onLootTablesLoaded(LootTableLoadEvent event) {
        // Forge clowniness: EntityType.field_242287_aj => EntityType.PIGLIN_BRUTE
        if (event.getName().equals(EntityType.field_242287_aj.getLootTable())) {
            double dropChance = NetheriteNuggetConfig.piglinBruteNetheriteNuggetDropChance.get();
            dropChance = Math.min(dropChance, 1.0);
            if (dropChance > 0.0) {
                event.getTable().addPool(LootPool.builder()
                        .rolls(BinomialRange.of(1, (float) dropChance))
                        .addEntry(ItemLootEntry.builder(NetheriteNuggetMod.NETHERITE_NUGGET_ITEM.get()))
                        .name("netherite_nugget_piglin_brute")
                        .build());
            }
        }
    }
}
