package xyz.icetang.lib

import xyz.icetang.lib.icemmand.icemmand
import org.bukkit.plugin.java.JavaPlugin

class PluginTemplate : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()

        setupCommands()

        logger.info("Enabled!")
    }

    override fun onDisable() {
        super.onDisable()

        logger.info("Disabled!")
    }

    private fun setupCommands() {
        icemmand {
            register("example") {
                executes {
                    sender.sendPlainMessage("Hello, World!")
                }
            }
        }
    }
}