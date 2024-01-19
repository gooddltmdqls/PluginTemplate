package xyz.icetang.lib

import xyz.icetang.lib.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class PluginTemplate : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()

        setupKommand()

        logger.info("Enabled!")
    }

    override fun onDisable() {
        super.onDisable()

        logger.info("Disabled!")
    }

    private fun setupKommand() {
        kommand {
            register("example") {
                executes {
                    sender.sendPlainMessage("Hello, World!")
                }
            }
        }
    }
}