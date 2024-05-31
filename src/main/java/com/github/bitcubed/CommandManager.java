package com.github.bitcubed;

import com.github.bitcubed.annotations.Argument;
import com.github.bitcubed.annotations.Execute;
import com.github.bitcubed.annotations.PluginCommand;
import com.github.bitcubed.structure.Structure;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static org.joor.Reflect.*;

/**
 * A class used in managing plugin commands.
 *
 * @since 1.0
 * @author Bit³ Studios
 */
public class CommandManager {
    private final Plugin plugin;

    public CommandManager(@NotNull final Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers the plugin command.
     *
     * @since 1.0
     * @param object The {@link PluginCommand}-annotated class.
     */
    public void registerCommand(@NotNull final Object object) {
        final Class<?> targetClass = object.getClass();

        if(!targetClass.isAnnotationPresent(PluginCommand.class)) return;

        final PluginCommand pluginCommand = targetClass.getAnnotation(PluginCommand.class);

        final Optional<Method> executeMethod = Arrays.stream(targetClass.getMethods())
                                                     .filter(method -> method.isAnnotationPresent(Execute.class))
                                                     .findAny();

        final Set<Method> argumentMethods = Arrays.stream(targetClass.getMethods())
                                                     .filter(method -> method.isAnnotationPresent(Argument.class))
                                                     .findAny().stream().collect(Collectors.toSet());

        final PluginCommand.Initiator targetInitiator = pluginCommand.targetInitiator();

        final Command baseCommand = new Command(pluginCommand.name(),
                                                pluginCommand.description(),
                                                pluginCommand.usage(),
                                                List.of(pluginCommand.aliases())) {
            @Override
            public boolean execute(CommandSender sender, String commandLabel, String[] args) {
                final boolean allowPlayer = (targetInitiator == PluginCommand.Initiator.PLAYER && sender instanceof Player),
                              allowConsole = (targetInitiator == PluginCommand.Initiator.CONSOLE && sender instanceof ConsoleCommandSender),
                              allowBoth = (allowPlayer || allowConsole);

                if(args != null) {
                    final Structure structure = new Structure(sender, args);

                    executeMethod.ifPresent(method -> on(object).call(method.getName(), structure));

                    argumentMethods.forEach(method -> {
                        final Argument argument = method.getAnnotation(Argument.class);

                        final String name = argument.name();
                        final int targetIndex = argument.index();

                        if(targetIndex < args.length && name.equalsIgnoreCase(args[targetIndex])) {

                            on(object).call(method.getName(), structure);

                        }
                    });
                    return true;
                }
                return false;
            }

            @Override
            public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
                return Collections.emptyList();
            }
        };
    }

    /**
     * Gets the command map in {@link org.bukkit.Server}.
     *
     * @since 1.0
     * @return The command map
     */
    public CommandMap getCommandMap() {

        return on(Bukkit.getServer()).field("commandMap").get();

    }
}