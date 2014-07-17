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
package net.fuzzyblocks.fuzzymessages.utils;

import net.fuzzyblocks.fuzzymessages.FuzzyMessages;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author LankyLord
 */
public final class ConfigManager {

    public static boolean enableCustomJoin;
    public static boolean enableCustomKick;
    public static boolean enableCustomQuit;
    public static boolean enableColouredDeath;
    public static boolean enableDisplayNames;
    public static String customJoinMessage;
    public static String customKickMessage;
    public static String customQuitMessage;

    private ConfigManager() { }

    public static String applyColourCodes(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void loadConfig(final FuzzyMessages plugin) {
        FileConfiguration fc = plugin.getConfig();
        enableCustomJoin = fc.getBoolean("enable-custom-join", true);
        enableCustomKick = fc.getBoolean("enable-custom-kick", true);
        enableCustomQuit = fc.getBoolean("enable-custom-quit", true);
        enableColouredDeath = fc.getBoolean("enable-coloured-death", true);
        enableDisplayNames = fc.getBoolean("enable-display-names", false);

        customJoinMessage = applyColourCodes(fc.getString("custom-join-message"));
        customKickMessage = applyColourCodes(fc.getString("custom-kick-message"));
        customQuitMessage = applyColourCodes(fc.getString("custom-quit-message"));
    }
}
