// Pfad: src/main/java/ja/endawakening/datagen/ModLootTableProvider.java
package ja.endawakening.datagen;

import ja.endawakening.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Diese Zeile sorgt dafür, dass der Block sich selbst droppt.
        addDrop(ModBlocks.VOID_STONE);
    }
}