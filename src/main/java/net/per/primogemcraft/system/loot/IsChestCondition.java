package net.per.primogemcraft.system.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.per.primogemcraft.registry.PGCLootConditions;

public class IsChestCondition implements LootItemCondition {
    public static final net.minecraft.world.level.storage.loot.Serializer<IsChestCondition> SERIALIZER =
            new net.minecraft.world.level.storage.loot.Serializer<>() {
                @Override
                public void serialize(com.google.gson.JsonObject json, IsChestCondition value, com.google.gson.JsonSerializationContext context) {
                }

                @Override
                public IsChestCondition deserialize(com.google.gson.JsonObject json, com.google.gson.JsonDeserializationContext context) {
                    return new IsChestCondition();
                }
            };

    @Override
    public LootItemConditionType getType() {
        return PGCLootConditions.IS_CHEST.get();
    }

    @Override
    public boolean test(LootContext context) {
        var table = java.util.Optional.ofNullable(context.getResolver().getLootTable(context.getQueriedLootTableId()));
        return table.filter(t -> t.getParamSet() == LootContextParamSets.CHEST).isPresent();
    }
}
