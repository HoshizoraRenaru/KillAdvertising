package org.hoshizora.killadvertising

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin

class Listener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val victim = event.entity
        val killer = victim.killer

        if (killer != null) {
            val weapon = killer.inventory.itemInMainHand
            val weaponName = if (weapon.type == Material.AIR) {
                "Punch"
            } else if (weapon.hasItemMeta() && weapon.itemMeta!!.hasDisplayName()) {
                weapon.itemMeta!!.displayName
            } else {
                weapon.type.name.replace("_", " ")
                    .lowercase()
                    .split(" ")
                    .joinToString(" ") { it.replaceFirstChar { char -> char.uppercaseChar() } }
            }

            val weaponEmoji = when (weapon.type) {
                Material.BOW -> "➴"
                Material.CROSSBOW -> "➴"
                else -> "🗡"
            }

            event.deathMessage = "${killer.name}${ChatColor.YELLOW} [${ChatColor.RESET}${weaponName}${ChatColor.RESET}${ChatColor.YELLOW}]$weaponEmoji ${ChatColor.RED}${victim.name}"
        }
    }
}
