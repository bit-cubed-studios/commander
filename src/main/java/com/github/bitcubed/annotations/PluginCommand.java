package com.github.bitcubed.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that marks the class as a plugin command.
 *
 * @since 1.0
 * @author Bit³ Studios
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PluginCommand {

    /**
     * The plugin command's name.
     *
     * @since 1.0
     * @return Returns the plugin command's name.
     */
    @NotNull String name();

    /**
     * The plugin command's applicable initiators.
     *
     * @since 1.0
     * @return Returns the plugin command's applicable initiators.
     */
    @NotNull Initiator targetInitiator();

    /**
     * The plugin command's description.
     *
     * @since 1.0
     * @return Returns the plugin command's description.
     */
    String description() default "";

    /**
     * The plugin command's permission.
     *
     * @since 1.0
     * @return Returns the plugin command's permission.
     */
    String permission() default "";

    /**
     * The plugin command's usage.
     *
     * @since 1.0
     * @return Returns the plugin command's usage.
     */
    String usage() default "";

    /**
     * The plugin command's aliases.
     *
     * @since 1.0
     * @return Returns the plugin command's description.
     */
    String[] aliases() default { };

    /**
     * All the possible command initiators.
     *
     * @since 1.0
     * @author Bit³ Studios
     */
    enum Initiator {
        PLAYER,
        CONSOLE,
        BOTH
    }
}