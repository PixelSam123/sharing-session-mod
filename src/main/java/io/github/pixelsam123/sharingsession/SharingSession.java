package io.github.pixelsam123.sharingsession;

import io.github.pixelsam123.sharingsession.blocks.Blocks;
import io.github.pixelsam123.sharingsession.items.Items;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharingSession implements ModInitializer {
    /**
     * Mod ID adalah nama identifikasi unik untuk mod-mu.
     * Usahakan menggunakan nama yang kreatif untuk Mod ID
     * agar mod-mu tidak bentrokan dengan mod lain.
     */
    public static final String MOD_ID = "sharingsession";

    /**
     * Logger ini digunakan untuk menulis teks ke console Minecraft serta log file.
     * Sebagai best practice, gunakan Mod ID sebagai nama logger ini.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Mulai menginialisasi Mod!");

        Items.initializeItems();
        Blocks.initializeBlocks();

        LOGGER.info("Selesai menginialisasi Mod!");
    }
}