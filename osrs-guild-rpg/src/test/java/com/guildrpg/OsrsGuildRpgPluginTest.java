package com.guildrpg;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class OsrsGuildRpgPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(OsrsGuildRpgPlugin.class);
		RuneLite.main(args);
	}
}