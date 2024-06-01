package com.github.bitcubed.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that marks the method as the
 * argument of the plugin command.
 *
 * @since 0.9
 * @author Bit³ Studios
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Arg {

    @NotNull String name() default "";

    int index();

    @NotNull String permission() default "";
}