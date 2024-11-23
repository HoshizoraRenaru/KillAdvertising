package org.hoshizora.killadvertising

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("星空れなる｜HoshizoraRenaru EternaL Plugin")
        logger.info("KillAd has been activated.")
        server.pluginManager.registerEvents(Listener(this), this)
    }

    override fun onDisable() {
        logger.info("KillAd has been disabled.")
    }
}
