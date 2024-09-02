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
                output.accept(ModItems.RUBY);
                output.accept(ModItems.SAPHIRE);
                output.accept(ModItems.TOPAZ);
                output.accept(ModItems.CHISEL);
                output.accept(ModItems.RADISH);
                output.accept(ModItems.FROSTFIRE_ICE);
                output.accept(ModItems.STARLIGHT_ASHES);
            } )
            .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB_REGISTRY.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GudMod.MOD_ID, "bismuth_items_tab"))
            .title(Component.translatable("creativetab.firstmod.bismuth_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.BISMUTH_BLOCK);
                output.accept(ModBlocks.RUBY_BLOCK);
                output.accept(ModBlocks.SAPHIRE_BLOCK);
                output.accept(ModBlocks.TOPAZ_BLOCK);
                output.accept(ModBlocks.BISMUTH_ORE);
                output.accept(ModBlocks.RUBY_ORE);
                output.accept(ModBlocks.SAPHIRE_ORE);
                output.accept(ModBlocks.TOPAZ_ORE);
                output.accept(ModBlocks.MAGIC_BLOCK);
            } )
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_REGISTRY.register(eventBus);
    }
}
