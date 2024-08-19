package de.jstn.firstmod.item;

import de.jstn.firstmod.GudMod;
import de.jstn.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GudMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEM_TAB = CREATIVE_MODE_TAB_REGISTRY.register("bismuth_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
            .title(Component.translatable("creativetab.firstmod.bismuth_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.BISMUTH);
                output.accept(ModItems.RAW_BISMUTH);
            } )
            .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB_REGISTRY.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GudMod.MOD_ID, "bismuth_items_tab"))
            .title(Component.translatable("creativetab.firstmod.bismuth_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.BISMUTH_BLOCK);
                output.accept(ModBlocks.BISMUTH_ORE);
            } )
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_REGISTRY.register(eventBus);
    }
}
