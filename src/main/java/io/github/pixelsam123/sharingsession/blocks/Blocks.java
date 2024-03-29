package io.github.pixelsam123.sharingsession.blocks;

import io.github.pixelsam123.sharingsession.SharingSession;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class Blocks {
    public static final Block PYRO_ORE = registerBlock(
        "pyro_ore",
        new ExperienceDroppingBlock(
            UniformIntProvider.create(5, 10),
            FabricBlockSettings.copyOf(net.minecraft.block.Blocks.IRON_ORE).strength(8f)
        )
    );

    public static final Block PYRO_BLOCK = registerBlock(
        "pyro_block",
        new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.IRON_BLOCK).strength(12f))
    );

    /**
     * Fungsi pembantu untuk registrasi block.
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(
            Registries.BLOCK,
            new Identifier(SharingSession.MOD_ID, name),
            block
        );
    }

    /**
     * Fungsi pembantu untuk registrasi item untuk sebuah block.
     */
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
            Registries.ITEM,
            new Identifier(SharingSession.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void initializeBlocks() {
        SharingSession.LOGGER.info("Mulai menginisialisasi Block-block!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(PYRO_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PYRO_BLOCK);
        });

        SharingSession.LOGGER.info("Selesai menginisialisasi Block-block!");
    }
}
