package com.infamous.dungeons_mobs.mod;

import com.infamous.dungeons_mobs.entities.blaze.WildfireEntity;
import com.infamous.dungeons_mobs.entities.creepers.IcyCreeperEntity;
import com.infamous.dungeons_mobs.entities.ender.BlastlingEntity;
import com.infamous.dungeons_mobs.entities.ender.EndersentEntity;
import com.infamous.dungeons_mobs.entities.ender.SnarelingEntity;
import com.infamous.dungeons_mobs.entities.ender.WatchlingEntity;
import com.infamous.dungeons_mobs.entities.golem.SquallGolemEntity;
import com.infamous.dungeons_mobs.entities.illagers.*;
import com.infamous.dungeons_mobs.entities.jungle.LeapleafEntity;
import com.infamous.dungeons_mobs.entities.jungle.PoisonQuillVineEntity;
import com.infamous.dungeons_mobs.entities.jungle.QuickGrowingVineEntity;
import com.infamous.dungeons_mobs.entities.jungle.WhispererEntity;
import com.infamous.dungeons_mobs.entities.piglin.FungusThrowerEntity;
import com.infamous.dungeons_mobs.entities.piglin.ZombifiedFungusThrowerEntity;
import com.infamous.dungeons_mobs.entities.projectiles.*;
import com.infamous.dungeons_mobs.entities.redstone.RedstoneCubeEntity;
import com.infamous.dungeons_mobs.entities.redstone.RedstoneGolemEntity;
import com.infamous.dungeons_mobs.entities.redstone.RedstoneMineEntity;
import com.infamous.dungeons_mobs.entities.slime.ConjuredSlimeEntity;
import com.infamous.dungeons_mobs.entities.summonables.*;
import com.infamous.dungeons_mobs.entities.undead.*;
import com.infamous.dungeons_mobs.entities.water.DrownedNecromancerEntity;
import com.infamous.dungeons_mobs.entities.water.PoisonAnemoneEntity;
import com.infamous.dungeons_mobs.entities.water.QuickGrowingKelpEntity;
import com.infamous.dungeons_mobs.entities.water.SunkenSkeletonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.infamous.dungeons_mobs.DungeonsMobs.DUNGEONS_MOBS;
import static com.infamous.dungeons_mobs.DungeonsMobs.MODID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final List<String> ENTITY_IDS = new ArrayList<>();

    // ZOMBIES
    public static final RegistryObject<EntityType<JungleZombieEntity>> JUNGLE_ZOMBIE = registerEntity("jungle_zombie", () ->
                    EntityType.Builder.<JungleZombieEntity>of(com.infamous.dungeons_mobs.entities.undead.JungleZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "jungle_zombie").toString()),
            0x4f7d33, 0x00afa8);


    public static final RegistryObject<EntityType<FrozenZombieEntity>> FROZEN_ZOMBIE = registerEntity("frozen_zombie", () ->
                    EntityType.Builder.<FrozenZombieEntity>of(FrozenZombieEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "frozen_zombie").toString()),
            0x639694, 0xbae1ec
    );

    // SKELETONS
    public static final RegistryObject<EntityType<MossySkeletonEntity>> MOSSY_SKELETON = registerEntity("mossy_skeleton", () ->
                    EntityType.Builder.<MossySkeletonEntity>of(MossySkeletonEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.99F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "mossy_skeleton").toString()),
            0xd6d7c6, 0x4a5d18
    );


    public static final RegistryObject<EntityType<SkeletonVanguardEntity>> SKELETON_VANGUARD = registerEntity("skeleton_vanguard", () ->
                    EntityType.Builder.<SkeletonVanguardEntity>of(SkeletonVanguardEntity::new, MobCategory.MONSTER)
                            .sized(0.6F * 1.1F, 1.99F * 1.1F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "skeleton_vanguard").toString()),
            0x493615, 0xe8b42f
    );

    public static final RegistryObject<EntityType<NecromancerEntity>> NECROMANCER = registerEntity("necromancer", () ->
                    EntityType.Builder.<NecromancerEntity>of(NecromancerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F * 1.3F, 1.99F * 1.3F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "necromancer").toString()),
            0x3f243d, 0x0b9cbb
    );


    // ILLAGERS

    public static final RegistryObject<EntityType<RoyalGuardEntity>> ROYAL_GUARD = registerEntity("royal_guard", () ->
                    EntityType.Builder.<RoyalGuardEntity>of(RoyalGuardEntity::new, MobCategory.MONSTER)
                            .sized(0.6F * 1.2F, 1.95F * 1.2F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "royal_guard").toString()),
            0x676767, 0x014675
    );

    public static final RegistryObject<EntityType<IceologerEntity>> ICEOLOGER = registerEntity("iceologer", () ->
                    EntityType.Builder.<IceologerEntity>of(IceologerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "iceologer").toString()),
            0x173873, 0xb6c6ca
    );

    public static final RegistryObject<EntityType<MageEntity>> MAGE = registerEntity("mage", () ->
                    EntityType.Builder.of(MageEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "mage").toString()),
            0x951f75, 0xe3ab58
    );

    public static final RegistryObject<EntityType<MageCloneEntity>> MAGE_CLONE = registerEntityWithoutEgg("mage_clone", () ->
            EntityType.Builder.of(MageCloneEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
                    .build(new ResourceLocation(MODID, "mage_clone").toString())
    );

    public static final RegistryObject<EntityType<GeomancerEntity>> GEOMANCER = registerEntity("geomancer", () ->
                    EntityType.Builder.of(GeomancerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "geomancer").toString()),
            0x373b3b, 0x8b5ea3
    );

    public static final RegistryObject<EntityType<WindcallerEntity>> WINDCALLER = registerEntity("windcaller", () ->
                    EntityType.Builder.<WindcallerEntity>of(WindcallerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "windcaller").toString()),
            0x348179, 0xdc6c46
    );

//    public static final RegistryObject<EntityType<EnchanterEntity>> ENCHANTER = registerEntityWithoutEgg("enchanter", () ->
//    EntityType.Builder.<EnchanterEntity>of(EnchanterEntity::new, EntityClassification.MONSTER)
//            .sized(0.6F, 1.95F)
//            .clientTrackingRange(8)
//            .build(new ResourceLocation(MODID, "enchanter").toString())//,
//            //0x62162c, 0xfbd600
//    );

    public static final RegistryObject<EntityType<DungeonsIllusionerEntity>> ILLUSIONER = registerEntity("illusioner", () ->
                    EntityType.Builder.<DungeonsIllusionerEntity>of(DungeonsIllusionerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "illusioner").toString()),
            0x603e5c, 0x945c45
    );

    public static final RegistryObject<EntityType<IllusionerCloneEntity>> ILLUSIONER_CLONE = registerEntityWithoutEgg("illusioner_clone", () ->
            EntityType.Builder.<IllusionerCloneEntity>of(IllusionerCloneEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
                    .build(new ResourceLocation(MODID, "illusioner_clone").toString())
    );

    public static final RegistryObject<EntityType<MountaineerEntity>> MOUNTAINEER = registerEntity("mountaineer", () ->
                    EntityType.Builder.<MountaineerEntity>of(MountaineerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "mountaineer").toString()),
            0x715039, 0xe6e4d4
    );

    // CREEPER

    public static final RegistryObject<EntityType<IcyCreeperEntity>> ICY_CREEPER = registerEntity("icy_creeper", () ->
                    EntityType.Builder.<IcyCreeperEntity>of(IcyCreeperEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.7F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "icy_creeper").toString()),
            0x5ccea5, 0xd9eef2
    );

    // WRAITH

    public static final RegistryObject<EntityType<WraithEntity>> WRAITH = registerEntity("wraith", () ->
                    EntityType.Builder.of(WraithEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.99F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "wraith").toString()),
            0x0a2c40, 0x82d8f8
    );

    // SLIME

    public static final RegistryObject<EntityType<ConjuredSlimeEntity>> CONJURED_SLIME = registerEntityWithoutEgg("conjured_slime", () ->
            EntityType.Builder.<ConjuredSlimeEntity>of(ConjuredSlimeEntity::new, MobCategory.MONSTER)
                    .sized(2.04F, 2.04F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "conjured_slime").toString())
    );

    // REDSTONE

    public static final RegistryObject<EntityType<RedstoneCubeEntity>> REDSTONE_CUBE = registerEntityWithoutEgg("redstone_cube", () ->
            EntityType.Builder.<RedstoneCubeEntity>of(RedstoneCubeEntity::new, MobCategory.MONSTER)
                    .sized(1.0F, 1.0F)
                    .clientTrackingRange(10)
                    .fireImmune()
                    .build(new ResourceLocation(MODID, "redstone_cube").toString())
    );

    public static final RegistryObject<EntityType<RedstoneGolemEntity>> REDSTONE_GOLEM = registerEntity("redstone_golem", () ->
                    EntityType.Builder.<RedstoneGolemEntity>of(RedstoneGolemEntity::new, MobCategory.MONSTER)
                            .sized(2.66F, 3.83F)
                            .clientTrackingRange(10)
                            .fireImmune()
                            .build(new ResourceLocation(MODID, "redstone_golem").toString()),
            0xaeaaa6, 0xe3260c
    );

    // JUNGLE

    public static final RegistryObject<EntityType<WhispererEntity>> WHISPERER = registerEntity("whisperer", () ->
                    EntityType.Builder.of(WhispererEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 2.25F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "whisperer").toString()),
            0x80a242, 0xe20703
    );

    public static final RegistryObject<EntityType<LeapleafEntity>> LEAPLEAF = registerEntity("leapleaf", () ->
                    EntityType.Builder.<LeapleafEntity>of(LeapleafEntity::new, MobCategory.MONSTER)
                            .sized(1.9F, 1.9F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "leapleaf").toString()),
            0x818a1a, 0x8a54ef
    );

    public static final RegistryObject<EntityType<QuickGrowingVineEntity>> QUICK_GROWING_VINE = registerEntity("quick_growing_vine", () ->
                    EntityType.Builder.of(QuickGrowingVineEntity::new, MobCategory.MONSTER)
                            //.fireImmune()
                            .sized(1.0F, 2.5F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "quick_growing_vine").toString()),
            0x90ad49, 0xfbc883
    );

    public static final RegistryObject<EntityType<PoisonQuillVineEntity>> POISON_QUILL_VINE = registerEntity("poison_quill_vine", () ->
                    EntityType.Builder.of(PoisonQuillVineEntity::new, MobCategory.MONSTER)
                            //.fireImmune()
                            .sized(1.0F, 2.5F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "poison_quill_vine").toString()),
            0x90ad49, 0x632cbb
    );

    // GOLEM
    public static final RegistryObject<EntityType<SquallGolemEntity>> SQUALL_GOLEM = registerEntity("squall_golem", () ->
                    EntityType.Builder.<SquallGolemEntity>of(SquallGolemEntity::new, MobCategory.MONSTER)
                            .sized(1.9F, 2.75F) // 42 px wide, 29px tall + 16px of height
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "squall_golem").toString()),
            0x828f8f, 0xffd426
    );


    // PIGLIN
    public static final RegistryObject<EntityType<FungusThrowerEntity>> FUNGUS_THROWER = registerEntity("fungus_thrower", () ->
                    EntityType.Builder.of(FungusThrowerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "fungus_thrower").toString()),
            10051392, 0x336baf
    );

    public static final RegistryObject<EntityType<ZombifiedFungusThrowerEntity>> ZOMBIFIED_FUNGUS_THROWER = registerEntity("zombified_fungus_thrower", () ->
                    EntityType.Builder.of(ZombifiedFungusThrowerEntity::new, MobCategory.MONSTER)
                            .fireImmune()
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "zombified_fungus_thrower").toString()),
            15373203, 0x336baf
    );

    // WATER
    public static final RegistryObject<EntityType<WhispererEntity>> WAVEWHISPERER = registerEntity("wavewhisperer", () ->
                    EntityType.Builder.of(WhispererEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 2.25F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "wavewhisperer").toString()),
            0x48a867, 0x69ebff
    );

    public static final RegistryObject<EntityType<QuickGrowingKelpEntity>> QUICK_GROWING_KELP = registerEntity("quick_growing_kelp", () ->
                    EntityType.Builder.of(QuickGrowingKelpEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 2.5F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "quick_growing_kelp").toString()),
            0x2b9477, 0x0d8f99
    );

    public static final RegistryObject<EntityType<PoisonAnemoneEntity>> POISON_ANEMONE = registerEntity("poison_anemone", () ->
                    EntityType.Builder.of(PoisonAnemoneEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 2.5F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "poison_anemone").toString()),
            0x2b9477, 0xc436cd
    );

    public static final RegistryObject<EntityType<DrownedNecromancerEntity>> DROWNED_NECROMANCER = registerEntity("drowned_necromancer", () ->
                    EntityType.Builder.of(DrownedNecromancerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F * 1.5F, 1.95F * 1.5F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "drowned_necromancer").toString()),
            9433559, 0x274d72
    );

    public static final RegistryObject<EntityType<SunkenSkeletonEntity>> SUNKEN_SKELETON = registerEntity("sunken_skeleton", () ->
                    EntityType.Builder.of(SunkenSkeletonEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.99F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "sunken_skeleton").toString()),
            0x87a964, 0xc06fe5
    );

    // ENDER MOBS

    public static final RegistryObject<EntityType<EndersentEntity>> ENDERSENT = registerEntity("endersent", () ->
                    EntityType.Builder.of(EndersentEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 5.6F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "endersent").toString()),
            1447446, 0
    );

    public static final RegistryObject<EntityType<BlastlingEntity>> BLASTLING = registerEntity("blastling", () ->
                    EntityType.Builder.of(BlastlingEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 2.4F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "blastling").toString()),
            0x03030a, 0x8900b0
    );

    public static final RegistryObject<EntityType<WatchlingEntity>> WATCHLING = registerEntity("watchling", () ->
                    EntityType.Builder.of(WatchlingEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 2.4F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "watchling").toString()),
            0x110e13, 0xff84f7
    );

    public static final RegistryObject<EntityType<SnarelingEntity>> SNARELING = registerEntity("snareling", () ->
                    EntityType.Builder.of(SnarelingEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 2.4F)
                            .clientTrackingRange(8)
                            .build(new ResourceLocation(MODID, "snareling").toString()),
            0x161616, 0xdbe64e
    );

    // BLAZES

    public static final RegistryObject<EntityType<WildfireEntity>> WILDFIRE = registerEntity("wildfire", () ->
                    EntityType.Builder.of(WildfireEntity::new, MobCategory.MONSTER)
                            .fireImmune()
                            .sized(0.9F, 2.25F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "wildfire").toString()),
            0x8b3401, 0xffd528
    );

    // Projectiles
    public static final RegistryObject<EntityType<SlimeballEntity>> SLIMEBALL = registerEntityWithoutEgg("slimeball", () ->
            EntityType.Builder.<SlimeballEntity>of(SlimeballEntity::new, MobCategory.MISC)
                    .sized(0.3125F, 0.3125F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(new ResourceLocation(MODID, "slimeball").toString())
    );

    public static final RegistryObject<EntityType<CobwebProjectileEntity>> COBWEB_PROJECTILE = registerEntityWithoutEgg("cobweb_projectile", () ->
            EntityType.Builder.<CobwebProjectileEntity>of(CobwebProjectileEntity::new, MobCategory.MISC)
                    .sized(0.3125F, 0.3125F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(new ResourceLocation(MODID, "cobweb_projectile").toString())
    );

    // Traps
    public static final RegistryObject<EntityType<BlueNethershroomEntity>> BLUE_NETHERSHROOM = registerEntityWithoutEgg("blue_nethershroom", () ->
            EntityType.Builder.<BlueNethershroomEntity>of(BlueNethershroomEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(new ResourceLocation(MODID, "blue_nethershroom").toString())
    );

    public static final RegistryObject<EntityType<GeomancerWallEntity>> GEOMANCER_WALL = registerEntityWithoutEgg("geomancer_wall", () ->
            EntityType.Builder.<GeomancerWallEntity>of(GeomancerWallEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.0F, 2.5F)
                    .clientTrackingRange(6)
                    .updateInterval(2)
                    .build(new ResourceLocation(MODID, "geomancer_wall").toString())
    );

    public static final RegistryObject<EntityType<GeomancerBombEntity>> GEOMANCER_BOMB = registerEntityWithoutEgg("geomancer_bomb", () ->
            EntityType.Builder.<GeomancerBombEntity>of(GeomancerBombEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.0F, 2.5F)
                    .clientTrackingRange(6)
                    .updateInterval(2)
                    .build(new ResourceLocation(MODID, "geomancer_bomb").toString())
    );

    public static final RegistryObject<EntityType<RedstoneMineEntity>> REDSTONE_MINE = registerEntityWithoutEgg("redstone_mine", () ->
            EntityType.Builder.<RedstoneMineEntity>of(RedstoneMineEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.0F, 0.5F)
                    .clientTrackingRange(6)
                    .updateInterval(2)
                    .build(new ResourceLocation(MODID, "redstone_mine").toString())
    );

    public static final RegistryObject<EntityType<IceCloudEntity>> ICE_CLOUD = registerEntityWithoutEgg("ice_cloud", () ->
            EntityType.Builder.<IceCloudEntity>of(IceCloudEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(2.0F, 1.0F)
                    .clientTrackingRange(6)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "ice_cloud").toString())
    );

    public static final RegistryObject<EntityType<WindcallerTornadoEntity>> TORNADO = registerEntityWithoutEgg("tornado", () ->
            EntityType.Builder.<WindcallerTornadoEntity>of(WindcallerTornadoEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(3.25F, 6F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "tornado").toString())
    );

    public static final RegistryObject<EntityType<WindcallerBlastProjectileEntity>> WINDCALLER_BLAST_PROJECTILE = ENTITY_TYPES.register("windcaller_blast_projectile", () ->
            EntityType.Builder.<WindcallerBlastProjectileEntity>of(WindcallerBlastProjectileEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(2F, 2F)
                    .build(new ResourceLocation(MODID, "windcaller_blast_projectile").toString())
    );

    public static final RegistryObject<EntityType<TridentStormEntity>> TRIDENT_STORM = registerEntityWithoutEgg("trident_storm", () ->
            EntityType.Builder.of(TridentStormEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(2F, 32F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "trident_storm").toString())
    );


    public static final RegistryObject<EntityType<NecromancerOrbEntity>> NECROMANCER_ORB = ENTITY_TYPES.register("necromancer_orb", () ->
            EntityType.Builder.<NecromancerOrbEntity>of(NecromancerOrbEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(0.5F, 0.5F)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "necromancer_orb").toString())
    );

    public static final RegistryObject<EntityType<DrownedNecromancerOrbEntity>> DROWNED_NECROMANCER_ORB = ENTITY_TYPES.register("drowned_necromancer_orb", () ->
            EntityType.Builder.<DrownedNecromancerOrbEntity>of(DrownedNecromancerOrbEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(0.5F, 0.5F)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "drowned_necromancer_orb").toString())
    );

    public static final RegistryObject<EntityType<PoisonQuillEntity>> POISON_QUILL = ENTITY_TYPES.register("poison_quill", () ->
            EntityType.Builder.<PoisonQuillEntity>of(PoisonQuillEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(0.35F, 0.35F)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "poison_quill").toString())
    );

    public static final RegistryObject<EntityType<MageMissileEntity>> MAGE_MISSILE = ENTITY_TYPES.register("mage_missile", () ->
            EntityType.Builder.<MageMissileEntity>of(MageMissileEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(0.35F, 0.35F)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "mage_missile").toString())
    );

    public static final RegistryObject<EntityType<SummonSpotEntity>> SUMMON_SPOT = registerEntityWithoutEgg("summon_spot", () ->
            EntityType.Builder.<SummonSpotEntity>of(SummonSpotEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.0F, 2.0F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "summon_spot").toString())
    );

    public static final RegistryObject<EntityType<SimpleTrapEntity>> SIMPLE_TRAP = registerEntityWithoutEgg("simple_trap", () ->
            EntityType.Builder.of(SimpleTrapEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(2.0F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "simple_trap").toString())
    );

    public static final RegistryObject<EntityType<KelpTrapEntity>> KELP_TRAP = registerEntityWithoutEgg("kelp_trap", () ->
            EntityType.Builder.of(KelpTrapEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(2.0F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "kelp_trap").toString())
    );

    public static final RegistryObject<EntityType<WraithFireEntity>> WRAITH_FIRE = registerEntityWithoutEgg("wraith_fire", () ->
            EntityType.Builder.of(WraithFireEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(3.25F, 1.25F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(MODID, "wraith_fire").toString())
    );

    public static final RegistryObject<EntityType<AreaDamageEntity>> AREA_DAMAGE = registerEntityWithoutEgg("area_damage", () ->
            EntityType.Builder.<AreaDamageEntity>of(AreaDamageEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.0F, 1.0F)
                    .clientTrackingRange(10)
                    .updateInterval(1)
                    .build(new ResourceLocation(MODID, "area_damage").toString())
    );

    public static final RegistryObject<EntityType<BlastlingBulletEntity>> BLASTLING_BULLET = registerEntityWithoutEgg("blastling_bullet", () ->
            EntityType.Builder.<BlastlingBulletEntity>of(BlastlingBulletEntity::new, MobCategory.MISC)
                    .sized(0.3F, 0.3F)
                    .clientTrackingRange(4)
                    .updateInterval(2)
                    .build(new ResourceLocation(MODID, "blastling_bullet").toString())
    );

    public static final RegistryObject<EntityType<SnarelingGlobEntity>> SNARELING_GLOB = registerEntityWithoutEgg("snareling_glob", () ->
            EntityType.Builder.<SnarelingGlobEntity>of(SnarelingGlobEntity::new, MobCategory.MISC)
                    .sized(0.6F, 0.6F)
                    .clientTrackingRange(4)
                    .updateInterval(2)
                    .build(new ResourceLocation(MODID, "snareling_glob").toString())
    );


    private static <T extends Mob> RegistryObject<EntityType<T>> registerEntity(String key, Supplier<EntityType<T>> sup, int primaryColor, int secondaryColor) {
        ENTITY_IDS.add(key);
        RegistryObject<EntityType<T>> entityType = ENTITY_TYPES.register(key, sup);

        SPAWN_EGGS.register(key + "_spawn_egg", () -> new ForgeSpawnEggItem(entityType, primaryColor, secondaryColor, new Item.Properties().tab(DUNGEONS_MOBS)));

        return entityType;
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntityWithoutEgg(String key, Supplier<EntityType<T>> sup) {
        ENTITY_IDS.add(key);
        RegistryObject<EntityType<T>> entityType = ENTITY_TYPES.register(key, sup);

        return entityType;
    }

}
