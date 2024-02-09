package io.github.pixelsam123.sharingsession.items;

import io.github.pixelsam123.sharingsession.SharingSession;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Items {
    public static final Item PYRO_INGOT =
        registerItem("pyro_ingot", new Item(new FabricItemSettings()));

    /**
     * Fungsi pembantu untuk registrasi item.
     */
    private static Item registerItem(String name, Item item) {
        return Registry.register(
            Registries.ITEM,
            new Identifier(SharingSession.MOD_ID, name),
            item
        );
    }

    public static void initializeItems() {
        SharingSession.LOGGER.info("Mulai menginisialisasi Item-item!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PYRO_INGOT);
        });

        SharingSession.LOGGER.info("Selesai menginisialisasi Item-item!");
    }
}
