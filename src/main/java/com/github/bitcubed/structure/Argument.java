package com.github.bitcubed.structure;

import org.apache.commons.lang.math.NumberUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a plugin command argument.
 *
 * @since 1.0
 * @author Bit³ Studios
 */
public class Argument {
    private final String argument;

    public Argument(@NotNull final String argument) {
        this.argument = argument;
    }

    /**
     * Converts the argument into a {@link Byte}.
     *
     * @since 1.0
     * @return Returns a byte-converted argument.
     */
    public byte toByte() {
        return (NumberUtils.isNumber(argument)) ? NumberUtils.toByte(argument) : 0;
    }

    /**
     * Converts the argument into a {@link Short}.
     *
     * @since 1.0
     * @return Returns a short-converted argument.
     */
    public short toShort() {
        return (NumberUtils.isNumber(argument)) ? NumberUtils.toShort(argument) : 0;
    }

    /**
     * Converts the argument into a {@link Integer}.
     *
     * @since 1.0
     * @return Returns a integer-converted argument.
     */
    public int toInt() {
        return (NumberUtils.isNumber(argument)) ? NumberUtils.toInt(argument) : 0;
    }

    /**
     * Converts the argument into a {@link Long}.
     *
     * @since 1.0
     * @return Returns a long-converted argument.
     */
    public long toLong() {
        return (NumberUtils.isNumber(argument)) ? NumberUtils.toLong(argument) : 0;
    }
}