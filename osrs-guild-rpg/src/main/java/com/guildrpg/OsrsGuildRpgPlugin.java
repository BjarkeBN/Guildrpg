package com.guildrpg;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Osrs Guild RPG"
)
public class OsrsGuildRpgPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OsrsGuildRpgConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Osrs Guild RPG started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Osrs Guild RPG stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Osrs Guild RPG says " + config.greeting(), null);
		}
	}

	@Provides
	OsrsGuildRpgConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OsrsGuildRpgConfig.class);
	}
}
