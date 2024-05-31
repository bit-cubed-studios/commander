package com.github.bitcubed.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that marks the method as the
 * plugin command's executor.
 *
 * @since 0.9
 * @author Bit³ Studios
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Execute {

    /**
     * Will the plugin command prevent empty arguments (args.length == 0)?
     * It is recommended to use this if your plugin command has arguments.
     *
     * @since 1.0
     * @return Returns true if the plugin command will prevent empty arguments, false otherwise.
     */
    boolean preventEmptyArguments() default false;
}