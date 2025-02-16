package com.infamous.dungeons_mobs.interfaces;

import com.infamous.dungeons_mobs.config.DungeonsMobsConfig;
import com.infamous.dungeons_mobs.mod.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.raid.Raider;
import net.minecraftforge.common.BiomeDictionary;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum BiomeSpecificRaider {
    MOUNTAINEER(
            ModEntityTypes.MOUNTAINEER.get(),
            EntityType.VINDICATOR,
            DungeonsMobsConfig.COMMON.MOUNTAINEER_BIOME_TYPES.get()),
    ICEOLOGER(
            ModEntityTypes.ICEOLOGER.get(),
            EntityType.EVOKER,
            DungeonsMobsConfig.COMMON.ICEOLOGER_BIOME_TYPES.get()),
    WINDCALLER(
            ModEntityTypes.WINDCALLER.get(),
            EntityType.EVOKER,
            DungeonsMobsConfig.COMMON.WINDCALLER_BIOME_TYPES.get()),
    SQUALL_GOLEM(
            ModEntityTypes.SQUALL_GOLEM.get(),
            EntityType.RAVAGER,
            DungeonsMobsConfig.COMMON.SQUALL_GOLEM_BIOME_TYPES.get()),

    /*,
    ILLUSIONER(
            EntityType.ILLUSIONER,
            EntityType.ILLUSIONER,
            DungeonsMobsConfig.COMMON.ILLUSIONER_BIOME_TYPES.get())
     */
    ;

    private final EntityType<? extends Raider> entityType;
    private final EntityType<? extends Raider> equivalentType;
    private final Set<BiomeDictionary.Type> biomeTypes = new HashSet<>();

    BiomeSpecificRaider(EntityType<? extends Raider> entityTypeIn, EntityType<? extends Raider> equivalentTypeIn, List<? extends String> biomeTypesList){
        this.entityType = entityTypeIn;
        this.equivalentType = equivalentTypeIn;

        List<String> filteredBiomesList = biomeTypesList
                .stream()
                .filter((type) -> !type.startsWith("!"))
                .collect(Collectors.toList());
        for(BiomeDictionary.Type type : BiomeDictionary.Type.getAll()){
            if(filteredBiomesList.contains(type.getName())){
                this.biomeTypes.add(type);
            }
        }
    }

    public EntityType<? extends Raider> getType(){
        return this.entityType;
    }

    public EntityType<? extends Raider> getEquivalentType(){
        return this.equivalentType;
    }

    public Set<BiomeDictionary.Type> getBiomeTypeSet(){
        return this.biomeTypes;
    }
}
