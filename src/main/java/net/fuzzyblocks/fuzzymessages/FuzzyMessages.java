/*
 * Copyright (c) 2013 LankyLord.
 * All rights reserved.
 * 
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * The name of the author may not be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fuzzyblocks.fuzzymessages;

import net.fuzzyblocks.fuzzymessages.listeners.DeathListener;
import net.fuzzyblocks.fuzzymessages.utils.ConfigManager;
import net.fuzzyblocks.fuzzymessages.listeners.QuitListener;
import net.fuzzyblocks.fuzzymessages.listeners.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author LankyLord
 */
public class FuzzyMessages extends JavaPlugin {

    @Override
    public void onDisable() {
        saveConfig();
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveConfig();
        ConfigManager.loadConfig(this);
        if (ConfigManager.enableCustomJoin)
            getServer().getPluginManager().registerEvents(new JoinListener(), this);
        if (ConfigManager.enableCustomQuit || ConfigManager.enableCustomKick)
            getServer().getPluginManager().registerEvents(new QuitListener(), this);
        if (ConfigManager.enableColouredDeath)
            getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }
}