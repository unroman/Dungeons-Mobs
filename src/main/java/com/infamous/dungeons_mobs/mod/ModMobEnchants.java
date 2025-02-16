package com.infamous.dungeons_mobs.mod;

import com.baguchan.enchantwithmob.mobenchant.MobEnchant;
import com.infamous.dungeons_mobs.DungeonsMobs;
import com.infamous.dungeons_mobs.mobenchants.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMobEnchants {
    public static final DeferredRegister<MobEnchant> MOB_ENCHANTS_DEFERRED = DeferredRegister.create(MobEnchant.class, DungeonsMobs.MODID);

    public static final RegistryObject<RushMobEnchant> RUSH = MOB_ENCHANTS_DEFERRED.register("rush", () -> new RushMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.COMMON, 3)));
    public static final RegistryObject<RegenerationMobEnchant> REGENERATION = MOB_ENCHANTS_DEFERRED.register("regeneration", () -> new RegenerationMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.COMMON, 3)));
    public static final RegistryObject<RadianceMobEnchant> RADIANCE = MOB_ENCHANTS_DEFERRED.register("radiance", () -> new RadianceMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.RARE, 3)));

    public static final RegistryObject<GravityPulseMobEnchant> GRAVITY_PULSE = MOB_ENCHANTS_DEFERRED.register("gravity_pulse", () -> new GravityPulseMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.RARE, 3)));
    public static final RegistryObject<BurningMobEnchant> BURNING = MOB_ENCHANTS_DEFERRED.register("burning", () -> new BurningMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.UNCOMMON, 3)));
    public static final RegistryObject<ChillingMobEnchant> CHILLING = MOB_ENCHANTS_DEFERRED.register("chilling", () -> new ChillingMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.UNCOMMON, 3)));
    public static final RegistryObject<HealsAlliesMobEnchant> HEALS_ALLIES = MOB_ENCHANTS_DEFERRED.register("heals_allies", () -> new HealsAlliesMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.RARE, 3)));
    public static final RegistryObject<DeflectMobEnchant> DEFLECT = MOB_ENCHANTS_DEFERRED.register("deflect", () -> new DeflectMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.UNCOMMON, 1)));
    public static final RegistryObject<EchoMobEnchant> ECHO = MOB_ENCHANTS_DEFERRED.register("echo", () -> new EchoMobEnchant(new MobEnchant.Properties(MobEnchant.Rarity.VERY_RARE, 3)));
}
