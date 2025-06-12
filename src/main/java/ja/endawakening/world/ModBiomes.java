// Pfad: src/main/java/ja/endawakening/world/ModBiomes.java

package ja.endawakening.world;

import ja.endawakening.EndAwakening;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.SpawnSettings;

public class ModBiomes {
    public static final RegistryKey<Biome> CRYSTAL_CAVES = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(EndAwakening.MOD_ID, "crystal_caves"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(CRYSTAL_CAVES, createCrystalCaves(context));
    }

    private static Biome createCrystalCaves(Registerable<Biome> context) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        // Spawns wieder hinzufügen
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 4, 4));

        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.5f)
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .fogColor(0x5a2a9a)
                        .skyColor(0x1a0d2b)
                        // Partikel wieder hinzufügen
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.PORTAL, 0.005f))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(new net.minecraft.world.biome.GenerationSettings.Builder().build()) // Leere Generation-Settings
                .build();
    }

    // Die Registrierungsmethode wieder aktivieren!
    public static void registerModBiomes() {
        TheEndBiomes.addHighlandsBiome(CRYSTAL_CAVES, 1.0);
    }
}