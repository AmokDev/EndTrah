package dev.amok.EndTrah.Initializers;

import dev.amok.EndTrah.Plugin;

import org.bukkit.command.CommandExecutor;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class CommandInit {

	public static void init() {
		try {
			ClassPath cp = ClassPath.from(CommandInit.class.getClassLoader());
			for (ClassInfo classInfo : cp.getTopLevelClassesRecursive("dev.amok.EndTrah.Commands")) {
				Class<?> clazz = Class.forName(classInfo.getName());
				try {
					if (CommandExecutor.class.isAssignableFrom(clazz)) {
						CommandExecutor command = (CommandExecutor) clazz.getDeclaredConstructor().newInstance();
						String commandName = classInfo.getSimpleName().replace("Command", "");
						Plugin.plugin.getCommand(commandName).setExecutor(command);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
