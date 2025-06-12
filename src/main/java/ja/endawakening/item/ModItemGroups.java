package ja.endawakening.item;

import ja.endawakening.EndAwakening;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup END_AWAKENING_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EndAwakening.MOD_ID, "end_awakening_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VOID_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.endawakening.end_awakening_items"))
                    .entries((displayContext, entries) ->{
                        entries.add(ModItems.VOID_CRYSTAL);
                    }).build());


    public static void initialize() {
    }
}
