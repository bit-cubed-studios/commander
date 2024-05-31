package com.github.bitcubed.structure;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the structure of the plugin command.
 *
 * @since 0.9
 * @author Bit³ Studios
 */
public class Structure {
    private final CommandSender sender;
    private final String[] strings;

    public Structure(@NotNull CommandSender sender, @NotNull final String[] strings) {
        this.sender = sender;
        this.strings = strings;
    }

    /**
     * Gets the plugin command's strings/args.
     *
     * @since 1.0
     * @return The plugin command's strings/args.
     */
    public String[] getStrings() {
        return this.strings;
    }

    /**
     * Gets the command sender.
     *
     * @since 1.0
     * @return The command sender.
     */
    public CommandSender getSender() {
        return this.sender;
    }
}