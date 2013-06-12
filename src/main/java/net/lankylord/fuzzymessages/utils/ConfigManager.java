/*
 * Copyright (c) 2013, LankyLord
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.lankylord.fuzzymessages.utils;

import net.lankylord.fuzzymessages.FuzzyMessages;
import org.bukkit.ChatColor;

/**
 *
 * @author LankyLord
 */
public class ConfigManager {

    private FuzzyMessages plugin;
    public static boolean enableCustomJoin;
    public static boolean enableCustomQuit;
    public static boolean enableColouredDeath;
    public static boolean enableDisplayNames;
    public static String customJoinMessage;
    public static String customQuitMessage;

    public ConfigManager(FuzzyMessages plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public String applyColourCodes(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public final void loadConfig() {
        enableCustomJoin = plugin.getConfig().getBoolean("enable-custom-join");
        enableCustomQuit = plugin.getConfig().getBoolean("enable-custom-quit");
        enableColouredDeath = plugin.getConfig().getBoolean("enable-coloured-death");
        enableDisplayNames = plugin.getConfig().getBoolean("enable-display-names");

        customJoinMessage = this.applyColourCodes(plugin.getConfig().getString("custom-join-message"));
        customQuitMessage = this.applyColourCodes(plugin.getConfig().getString("custom-quit-message"));
    }
}