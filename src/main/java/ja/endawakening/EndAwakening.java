// Pfad: src/main/java/ja/endawakening/EndAwakening.java
package ja.endawakening;

import ja.endawakening.block.ModBlocks;
import ja.endawakening.item.ModItemGroups;
import ja.endawakening.item.ModItems;
import ja.endawakening.world.ModBiomes;
import net.fabricmc.api.DedicatedServerModInitializer; // WICHTIGER IMPORT
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Die Klasse muss 'DedicatedServerModInitializer' implementieren
public class EndAwakening implements ModInitializer, DedicatedServerModInitializer {

	public static final String MOD_ID = "endawakening";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Ich übernehme deine neuen Methodennamen wie "initialize"
		ModBlocks.initialize();
		ModItems.initialize();
		ModItemGroups.initialize();
		LOGGER.info("Hello Fabric world!");
	}

	// DIESE METHODE HAT GEFEHLT
	@Override
	public void onInitializeServer() {
		// Wir fügen die Log-Nachricht wieder hinzu, um es zu testen
		LOGGER.info("Server is initializing, preparing to add biomes...");
		ModBiomes.registerModBiomes();
	}
}