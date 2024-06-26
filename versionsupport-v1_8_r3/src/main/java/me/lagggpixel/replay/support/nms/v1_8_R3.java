package me.lagggpixel.replay.support.nms;

import me.lagggpixel.replay.api.IReplay;
import me.lagggpixel.replay.api.recordable.entity.player.recordables.IEquipment;
import me.lagggpixel.replay.api.support.IVersionSupport;
import me.lagggpixel.replay.support.nms.packets.InjectorHandler;
import me.lagggpixel.replay.support.nms.recordable.entity.player.recordables.Equipment;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;

import java.util.UUID;

public class v1_8_R3 implements IVersionSupport {
  private static v1_8_R3 instance;
  private static IReplay plugin;
  private final CraftServer server;

  public v1_8_R3(IReplay plugin) {
    this.server = (CraftServer) Bukkit.getServer();
    v1_8_R3.plugin = plugin;
    instance = this;

    InjectorHandler.init();
  }

  public static v1_8_R3 getInstance() {
    return instance;
  }

  public IReplay getPlugin() {
    return plugin;
  }

  public CraftServer getServer() {
    return server;
  }

  @Override
  public IEquipment getEquipment(UUID uuid) {
    return new Equipment(uuid);
  }
}
