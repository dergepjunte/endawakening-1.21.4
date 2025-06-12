// Pfad: src/main/java/ja/endawakening/EndAwakeningDataGenerator.java
package ja.endawakening;

import ja.endawakening.datagen.ModLootTableProvider;
import ja.endawakening.world.ModBiomes; // Import hinzufügen
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class EndAwakeningDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		// Diese Zeile sagt dem Data Generator, er soll unser Biom "bootstrappen" (erstellen).
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
	}
}