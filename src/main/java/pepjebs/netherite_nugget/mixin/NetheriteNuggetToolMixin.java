package pepjebs.netherite_nugget.mixin;

import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pepjebs.netherite_nugget.NetheriteNuggetMod;

@Mixin(ItemTier.class)
public class NetheriteNuggetToolMixin {
    @Shadow
    @Final
    private final LazyValue<Ingredient> repairMaterial;

    public NetheriteNuggetToolMixin() {
        this.repairMaterial = null;
    }

    @Inject(
            method="getRepairMaterial",
            at= @At("HEAD"),
            cancellable = true
    )
    private void onGetRepairMaterial(CallbackInfoReturnable cir) {
        if (this.repairMaterial.getValue().test(new ItemStack(Items.NETHERITE_INGOT))) {
            cir.setReturnValue(Ingredient.fromItems(NetheriteNuggetMod.NETHERITE_NUGGET_ITEM.get()));
        }
    }
}
